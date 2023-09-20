package com.mycompany.hello.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.hello.Service.BoardServiceImple;
import com.mycompany.hello.Service.MemberServiceImple;
import com.mycompany.hello.domain.BaseSO;
import com.mycompany.hello.domain.BoardVO;
import com.mycompany.hello.domain.MemberVO;

import com.mycompany.hello.domain.Session;

@Controller
public class HomeController {
	
	@Autowired
	MemberServiceImple memberservice;
	
	@Autowired
	BoardServiceImple boardservice;
	
	// �Խù� ����Ʈ 
	@RequestMapping(value="/boardlist")
	public String boardlist(ModelMap map, String ID, HttpSession session, HttpServletRequest request) {
		Session se = (Session)session.getAttribute("session");
		String code = se.getAdmin();
		String setid = se.getId();
//		int cur_page = so.getCur_page();
//		int row = so.getRow();
//		so.setStartindex(((cur_page-1)*row)+1);
//		so.setEndindex(cur_page * row);
		List<BoardVO> listboard = boardservice.selectList();
//		MemberVO member = memberservice.select(ID);
		map.put("listboard", listboard);
//		map.put("member", member);
		map.put("code", code);
		map.put("setid", setid);
		return "boardlist";
	}
	
	@RequestMapping(value="/boardlistpage2", method=RequestMethod.POST)
	@ResponseBody
	public ModelMap boardlistPage(ModelMap map,BaseSO so) {
		int cur_page = so.getCur_page();
		int row = so.getRow();
		so.setStartindex(((cur_page-1)*row)+1);
		so.setEndindex(cur_page * row);
		List<BoardVO> listboard2 = boardservice.selectListPage(so);
		map.put("listboard2", listboard2);
		return map;
	}
	
	@RequestMapping(value="/boardlistdata", method=RequestMethod.POST)
	@ResponseBody
	public ModelMap boardlistdata(BaseSO so,ModelMap map) {
		int cur_page = so.getCur_page();
		int row = so.getRow();
		so.setStartindex(((cur_page-1)*row)+1);
		so.setEndindex(cur_page * row);
		List<BoardVO> listboard2 = boardservice.selectList();
		map.put("listboard2", listboard2);
		return map;
	}
	
	//�󼼺��� ������
	@RequestMapping(value="/boarddetail/{BNO}" , method=RequestMethod.GET)
	public String boarddetail (@PathVariable int BNO, ModelMap map) {
		map.addAttribute("detail", boardservice.boardDetail(BNO));
//		map.put("detail" ,detail);
		return "detail";
	}
	
	//������Ʈ ������
	@RequestMapping(value="/update/{BNO}" , method=RequestMethod.GET)
	public String boardupdate(@PathVariable int BNO, ModelMap map) {
		map.addAttribute("detail", boardservice.boardDetail(BNO));
		return "update";
	}
	
	//������Ʈ �Ϸ� �޼���
	@RequestMapping(value="/updatesucess" , method=RequestMethod.POST)
	public String boardupdateSucess(HttpServletRequest request) {
		BoardVO board = new BoardVO();
		board.setTITLE(request.getParameter("title"));
		board.setCONTENT(request.getParameter("content"));
		board.setBNO(Integer.parseInt(request.getParameter("BNO")));
		System.out.println(request.getParameter("BNO"));
		boardservice.boardUpdate(board);

		return "redirect:/boarddetail/" + request.getParameter("BNO");
	} 
	
	//���� 
//		@RequestMapping(value="/softdelete" , method=RequestMethod.GET)
//		public String boardsoftdelet(HttpServletRequest BNO) {
//			BoardVO board = new BoardVO();
//			board.setBNO(Integer.parseInt(BNO.getParameter("BNO")));
//			boardservice.boardDelete(board);
//			return "redirect:/boardlist";
//		}
	
	// ���� ����
	@RequestMapping(value = "/softdelete", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap boardsoftdelet(BoardVO BNO) {
		ModelMap map = new ModelMap();
		System.out.println("���� ����Ʈ����");

		boardservice.boardDelete(BNO);
		return map;
	}
	// ��� ����
		@RequestMapping(value = "/membersoftdelete", method = RequestMethod.POST)
		@ResponseBody
		public ModelMap membersoftdelet(MemberVO USER_ID) {
			ModelMap map = new ModelMap();
			System.out.println("��� ����Ʈ����");

			memberservice.memberDelete(USER_ID);
			return map;
		}
		
//		//������ �Խñ� �� ����	
//		@RequestMapping(value="/boardlist")
//		public String trash(ModelMap map) {
//			List<BoardVO> listboard = boardservice.trashboardList();
//			List<MemberVO> listmember = memberservice.trashmemberlist();
//			map.put("listboard", listboard);
//			map.put("listmember", listmember);
//			return "trash";
//		}
		
		
	//ȸ�� ����Ʈ ����Ʈ
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public String urservicserlist(ModelMap map, HttpSession session) {
		List<MemberVO> listVo = memberservice.selectList();
		Session se = (Session)session.getAttribute("session");
		String setid = se.getId();
		map.put("id", setid); 
		

		
		
		
		
		
//		Integer user_id = 0;
//		String name = null;
//		for(Iterator iterator = list.iterator(); iterator.hasNext();) {
//			MemberVO vo = (MemberVO) iterator.next();
//			user_id = vo.getUser_id();
//			name = vo.getName();
//			System.out.println(user_id);
//			System.out.println(name);
//		}
//		map.addAttribute("user_id", user_id);
//		map.addAttribute("name", name);
		map.put("listVo", listVo);
		return "index";
	}
	//���λ���Ʈ
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainsite() {	
		return "main";
	}
	//ȸ������ Ȯ�� �޼���
	@RequestMapping(value="/loginChk")
	@ResponseBody
	public ModelMap loginChk(MemberVO vo, HttpServletRequest request) {
		ModelMap map = new ModelMap();
		String result_code = null;
		String group_code = null;
		MemberVO MemberVO = memberservice.selectOne(vo);
		
		System.out.println("���ǰ� Ȯ��");
		if(!"".equals(MemberVO.getID())) {
			if("Y".equals(MemberVO.getDELETE_DATE())){
				result_code = "del";
			}else {
				//���� ���
				HttpSession session = request.getSession(true);
				Session sMem = new Session();
				sMem.setId(MemberVO.getID());
				sMem.setAdmin(MemberVO.getADMIN());
				session.setAttribute("session", sMem);
 				if("adm".equals(MemberVO.getADMIN())) {
					group_code="adm";
				}else {
					group_code="nom";
				}
				result_code = "1004";
			}
		}else {
			result_code = "F";
		}
		System.out.println("���۽� ��Ʈ�� ����");
		map.put("result_code", result_code);
		map.put("group_code", group_code);
		return map;
	}
	//�α��� ������ �ޱ�
	@RequestMapping(value="/loginin")
	@ResponseBody
	public ModelMap loginin(MemberVO vo) {
		ModelMap login = new ModelMap();
		String result_code = null;
		Integer count = 0;
		MemberVO chk = memberservice.selectOne(vo);
		count = chk.getMEMCNT();
		if(count > 0) {
			result_code = "S";
		}else {
			result_code = "F";
		}
		System.out.println("���۽�2 ��Ʈ�� ����");
		login.put("result_code", result_code);
		return login;
	}
//	@RequestMapping(value="/loginin")
//	@ResponseBody
//	public MemberVO idchk(MemberVO vo) {
//		MemberVO id = new MemberVO();
//		return id;
//	}
	//ȸ������ ����Ʈ
	@RequestMapping(value="/inner", method=RequestMethod.GET)
	public String memberin() {
		return "inner_user";
	}
	
	//ȸ������ �޼���
	@RequestMapping(value="/datain" , method=RequestMethod.POST)
	@ResponseBody
	public String memberdata(MemberVO memeber_in) {
		System.out.println("ȸ������ ������");
		memberservice.selectIner(memeber_in);
		return "success";
	}
	
	//��� ������
	@RequestMapping(value="/memberdetail/{USER_ID}" , method=RequestMethod.GET)
	public String memberdetail (@PathVariable int USER_ID, ModelMap map) {
		map.addAttribute("memberdetail", memberservice.memberDetail(USER_ID));
		return "memberdetail";
	}
	
	
	//���� ������Ʈ ������
		@RequestMapping(value="/memberupdate/{USER_ID}" , method=RequestMethod.GET)
		public String memberupdate(@PathVariable int USER_ID, ModelMap map) {
			map.addAttribute("memberdetail", memberservice.memberDetail(USER_ID));
			return "memberupdate";
		}

		// ����������Ʈ �Ϸ� �޼���
		@RequestMapping(value ="/memberupdatesucess", method = RequestMethod.POST)
		public String memberupdateSucess(HttpServletRequest request) {
			MemberVO member = new MemberVO();
			member.setID(request.getParameter("id"));
			member.setPASSWORD(request.getParameter("password"));
			member.setNAME(request.getParameter("name"));
			member.setEMAIL(request.getParameter("email"));
			member.setPHONENUM(request.getParameter("phonenum"));
			member.setBURTH(request.getParameter("burth"));
			member.setDELETE_YN(request.getParameter("delete_yn"));
			member.setADMIN(request.getParameter("admin"));
			member.setUSER_ID(Integer.parseInt(request.getParameter("user_id")));
			System.out.println(request.getParameter("user_id"));
			memberservice.memberUpdate(member);

			return "redirect:/memberdetail/" + request.getParameter("user_id");
		}
		//�Խù��ۼ�
		@RequestMapping(value="/make", method=RequestMethod.GET)
		public String boardmake(ModelMap model , HttpSession session) {
			Session se = (Session)session.getAttribute("session");
			String setwriter = se.getId();
			model.put("WRITER", setwriter);
			return "boardmake";
		}
		//�Խù� ������ 
		
		@RequestMapping(value="/boarddatain" , method=RequestMethod.POST)
		@ResponseBody
		public String memberdata(BoardVO board) {
			System.out.println("�Խù� �ۼ� ����");
			boardservice.selectboardIner(board);
			return "success";
		}
		
		
//		@GetMapping("/post/list.do")
//	    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
//	        List<MemberVO> posts = memberservice.findAllPost(params);
//	        model.addAttribute("posts", posts);
//	        return "testpage";
//	    }
	
	
//	//��ū �����
//	@RequestMapping(value="/datain" , method=RequestMethod.POST)
//	@ResponseBody
//	public String createToken(MemberVO user) {
//		
//		//jwts ��ū ���� , member�� ���̵� �־ ����
//		return Jwts.builder()
//				.signWith(test, SignatureAlgorithm.HS512)
//				.setHeaderParam("tokenuser", "key")
//				.setSubject(user.getId())
//				.setIssuer("minsung")
//				.setExpiration(new Date((new Date()).getTime()))
//				.setIssuedAt(new Date())
//				.compact();
//	}
//	public String testlist(Model model) {
//		
//	}
	
//	@GetMapping("signup")
//	public String signup(MemberVO membervo) {
//		return "member/signup";
//	}

}
