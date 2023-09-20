package com.mycompany.hello.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.hello.domain.MemberVO;
import com.mycompany.hello.mapper.MemberMapper;

@Service
public class MemberServiceImple{
	
	@Autowired(required=false)
	private MemberMapper memberMapper;
	
	@Transactional(readOnly=true)
	public List<MemberVO> selectList() {
		return memberMapper.selectAll();
	}
	
	@Transactional(readOnly=true)
	public MemberVO selectOne(MemberVO vo) {
		return memberMapper.selectOne(vo);
	}
	
	@Transactional(readOnly=true)
	public MemberVO select(String ID) {
		return memberMapper.select(ID);
	}
	
	@Transactional(readOnly=true)
	public MemberVO selectIner(MemberVO memeber_in) {
		return memberMapper.selectIner(memeber_in);
	}
	
	@Transactional(readOnly=true)
	public MemberVO memberDetail(int USER_ID) {
		return memberMapper.memberDetail(USER_ID);
	}
	@Transactional(readOnly=true)
	public MemberVO memberUpdate(MemberVO member) {
		return memberMapper.memberUpdate(member);
	}
	
	@Transactional(readOnly=true)
	public MemberVO memberDelete(MemberVO USER_ID) {
		return memberMapper.memberDelete(USER_ID);
	}
	
	@Transactional(readOnly=true)
	public List<MemberVO> trashmemberlist() {
		return memberMapper.trashmemberlist();
	}
	
//	@Transactional(readOnly=true)
//	public int memberpage() {	
//	   return memberMapper.findAll();
//	}
	 /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return 게시글 리스트
//     */
//	@Transactional(readOnly=true)
//    public List<PostResponse> findAllPost(final SearchDto params) {
//        return postMapper.findAll(params);
//    }

	
	
	
//	public MemberVO login(MemberVO id, MemberVO password) {
//		MemberVO user = memberMapper.finbyid(id);
//		user.login(password , passwordEncoder);
//		return "";
//	}

}
