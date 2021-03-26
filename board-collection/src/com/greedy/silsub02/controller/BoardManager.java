package com.greedy.silsub02.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.greedy.silsub02.model.dao.BoardDao;
import com.greedy.silsub02.view.InputBoard;
import com.greedy.silsub02.view.ResultPrinter;
import com.greedy.silsub02.vo.BoardVO;

public class BoardManager {
	
	private BoardDao bd;
	private ResultPrinter rp;
	
	/**
	 * <pre>
	 * 새 게시글 등록용 메소드
	 * </pre>
	 */
	public void insertBoard(BoardVO b) {
		bd = new BoardDao();
		rp = new ResultPrinter();
		b.setBoardNo(0);
		
			if(bd.readBoardList().isEmpty()) {
				//새로운 리스트생성
				b.setBoardNo(1);
			} else {
				b.setBoardNo(bd.readBoardList().size()+1);
			}
			
		ArrayList<BoardVO> list = bd.readBoardList();
		list.add(b);
		if(bd.writeBoardList(list) == 1) {
			rp.successPage("insertBoard");
		}
	}
	
	
	
	/**
	 * <pre>
	 * 게시글 전체 조회용 메소드
	 * </pre>
	 */
	public void selectAllList() {
		bd = new BoardDao();
		rp = new ResultPrinter();
		rp.printAllList(bd.readBoardList());  // 매개변수?
	}
	
	/**
	 * <pre>
	 * 게시글 1개 조회용 메소드
	 * </pre>
	 */
	public void selectOneBoard(int boardNo) {
		bd = new BoardDao();
		rp = new ResultPrinter();
		int num = 0;
		ArrayList<BoardVO> list = bd.readBoardList();
		
		for(int i = 0; i < list.size(); i++) {
			if(boardNo == list.get(i).getBoardNo()) {
				list.get(i).setReadCount(list.get(i).getReadCount() +1 );
				
				num = 1;
				break;
			} 
		}
		
		bd.writeBoardList(list);
		
		rp = new ResultPrinter();
		if(num == 1) {
			rp.successPage("selectOneBoard");
		} else {
			rp.errorPage("selectOneBoard");
		}
		
	}
	
	/**
	 * <pre>
	 * 게시글 제목 변경용 메소드
	 * </pre>
	 */
	public void updateBoardTitle(int boardNo, String title) {
		bd = new BoardDao();
		ArrayList<BoardVO> list = bd.readBoardList(); 
		int num = 0;
		for(int i = 0; i < list.size(); i++) {
			
			if(boardNo == list.get(i).getBoardNo()) {
				list.get(i).setBoardTitle(title);
				
				num = 1; break;
			} 
		}
		bd.writeBoardList(list);
		if(num == 1) {
			System.out.println("제목변경 성공");
			
		} else {
			System.out.println("없는번호.");
		}
		
	}
	
	/**
	 * <pre>
	 * 게시글 내용 변경용 메소드
	 * </pre>
	 */
	public void updateBoardContent(int boardNo, String content) {
		
	}
	
	/**
	 * <pre>
	 * 게시글 삭제용 메소드
	 * </pre>
	 */
	public void deleteBoard(int boardNo) {
		
		
	}
	
	/**
	 * <pre>
	 * 게시글 검색용 메소드
	 * </pre>
	 */
	public void searchBoard(String title) {
		
	}
	
	/**
	 * <pre>
	 * 정렬 처리용 메소드
	 * </pre>
	 */
	public void sortList(Comparator<BoardVO> c) {
		
	}
	
}
