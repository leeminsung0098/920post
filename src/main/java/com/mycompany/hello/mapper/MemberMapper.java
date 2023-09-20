package com.mycompany.hello.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.hello.domain.BaseSO;
import com.mycompany.hello.domain.BoardVO;
import com.mycompany.hello.domain.MemberVO;
import com.mycompany.hello.domain.SearchDto;

@Component
public interface MemberMapper {
	
	List<MemberVO> selectAll();
	
	MemberVO selectOne(MemberVO vo);
	
	MemberVO select(String ID);
	
	MemberVO selectIner(MemberVO memeber_in);
	
	MemberVO finbyid(MemberVO vo);
	
	MemberVO memberDetail(int USER_ID);
	
	MemberVO memberUpdate(MemberVO USER_ID);
	
	MemberVO memberDelete(MemberVO USER_ID);
	
	List<MemberVO> trashmemberlist();
	
	

	
	// ------- ���� -----
	
	
	List<BoardVO> selectBoardAll();
	
	List<BoardVO> selectListPage(BaseSO so);
	
	List<BoardVO> trashboardList();
	
	BoardVO boardDetail(int BNO);
	
	BoardVO boardUpdate(BoardVO BNO);
	
	BoardVO boardDelete(BoardVO BNO);
	
	BoardVO selectboardIner(BoardVO board);
	
	/**
     * �Խñ� ����Ʈ ��ȸ
     * @return �Խñ� ����Ʈ
     */
    List<MemberVO> findAll(SearchDto params);
    
    /**
     * �Խñ� �� ī����
     * @return �Խñ� ��
     */
    int count(SearchDto params);

}
