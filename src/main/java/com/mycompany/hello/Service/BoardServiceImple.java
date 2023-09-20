package com.mycompany.hello.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.hello.domain.BaseSO;
import com.mycompany.hello.domain.BoardVO;
import com.mycompany.hello.mapper.MemberMapper;


@Service
public class BoardServiceImple {
	@Autowired(required=false)
	MemberMapper boardmapper;
	
	@Transactional(readOnly=true)
	public List<BoardVO> selectList() {
		return boardmapper.selectBoardAll();
	}
	
	@Transactional(readOnly=true)
	public List<BoardVO> selectListPage(BaseSO so) {
		return boardmapper.selectListPage(so);
	}
	
	@Transactional(readOnly=true)
	public BoardVO boardDetail(int BNO) {
		return boardmapper.boardDetail(BNO);
	}
	
	@Transactional(readOnly=true)
	public BoardVO boardUpdate(BoardVO board) {
		return boardmapper.boardUpdate(board);
	}
	
	@Transactional(readOnly=true)
	public BoardVO boardDelete(BoardVO BNO) {
		return boardmapper.boardDelete(BNO);
	}
	
	@Transactional(readOnly=true)
	public List<BoardVO> trashboardList() {
		return boardmapper.trashboardList();
	}
	
	@Transactional(readOnly=true)
	public BoardVO selectboardIner(BoardVO board) {
		return boardmapper.selectboardIner(board);
	}

}
