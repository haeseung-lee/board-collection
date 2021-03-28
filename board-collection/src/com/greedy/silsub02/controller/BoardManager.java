package com.greedy.silsub02.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.greedy.silsub02.model.dao.BoardDao;
import com.greedy.silsub02.view.InputBoard;
import com.greedy.silsub02.view.ResultPrinter;
import com.greedy.silsub02.vo.BoardVO;

public class BoardManager {
	
	private BoardDao bd = new BoardDao();;
	private ResultPrinter rp = new ResultPrinter();;
	
	/**
	 * <pre>
	 * 새 게시글 등록용 메소드
	 * </pre>
	 */
	public void insertBoard(BoardVO b) {
		
		ArrayList<BoardVO> list = bd.readBoardList();
		int boardNo = 0;
			if(list.isEmpty()) {
				//없는경우 새로운 리스트생성
				list = new ArrayList<>();
				boardNo = 1;
			} else {
				//있는 경우 기존리스트의 마지막 인덱스의 글번호 조회
				boardNo = list.get(list.size()-1).getBoardNo() + 1;
			}
		b.setBoardNo(boardNo);
		list.add(b);
		bd.writeBoardList(list);
		rp.successPage("insertBoard");
//		rp.errorPage("insertBoard"); -- 어떤경우가 실패?
	}
	
	/**
	 * <pre>
	 * 게시글 전체 조회용 메소드
	 * </pre>
	 */
	public void selectAllList() {
		rp.printAllList(bd.readBoardList());  
	}
	
	/**
	 * <pre>
	 * 게시글 1개 조회용 메소드
	 * </pre>
	 */
	public void selectOneBoard(int boardNo) {
		
		bd = new BoardDao();
		
		ArrayList<BoardVO> list = bd.readBoardList();
		int num = -1;
		for(int i = 0; i < list.size(); i++) {
			
			if(boardNo == list.get(i).getBoardNo()) {
				list.get(i).setReadCount(list.get(i).getReadCount() +1 );
				num = i;
				break;
			} 
		}
		
		rp = new ResultPrinter();
		if(num != -1) {
			
			bd.writeBoardList(list);
			rp.successPage("selectOne");
			System.out.println(list.get(num));
		} else {
			
			rp.errorPage("selectOne");
		}
	}
	
	/**
	 * <pre>
	 * 게시글 제목 변경용 메소드
	 * </pre>
	 */
	public void updateBoardTitle(int boardNo, String title) {
		
		ArrayList<BoardVO> list = bd.readBoardList(); 
		int num = -1;
		for(int i = 0; i < list.size(); i++) {
			
			if(boardNo == list.get(i).getBoardNo()) {
				list.get(i).setBoardTitle(title);
				num = i; 
				break;
			} 
		}
		
		if(num != -1) {
			
			bd.writeBoardList(list);
			rp.successPage("updateTitle");
			System.out.println("수정된제목 : " + list.get(num).getBoardTitle());
		} else {
			
			rp.errorPage("updateTitle");
		}
	}
	
	/**
	 * <pre>
	 * 게시글 내용 변경용 메소드
	 * </pre>
	 */
	public void updateBoardContent(int boardNo, String content) {
		
		ArrayList<BoardVO> list = bd.readBoardList(); 
		int num = -1;
		for(int i = 0; i < list.size(); i++) {
			
			if(boardNo == list.get(i).getBoardNo()) {
				
				list.get(i).setBoardContent(content);
				num = i;
				break;
			} 
		}
		
		if(num != -1) {
			
			bd.writeBoardList(list);
			rp.successPage("updateContent");
			System.out.println("수정된 내용 : " + list.get(num).getBoardContent());
		} else {
			
			rp.errorPage("updateContent");
		}
	}
	
	/**
	 * <pre>
	 * 게시글 삭제용 메소드
	 * </pre>
	 */
	public void deleteBoard(int boardNo) {
		
		ArrayList<BoardVO> list = bd.readBoardList(); 
		int num = -1;
		for(int i = 0; i < list.size(); i++) {
			
			if(boardNo == list.get(i).getBoardNo()) {
				list.remove(i);
				num = i; break;
			} 
		}
		
		if(num != -1) {
			
			bd.writeBoardList(list);
			rp.successPage("deleteBoard");
		} else {
			
			rp.errorPage("deleteBoard");
		}
	}
	
	/**
	 * <pre>
	 * 게시글 검색용 메소드
	 * </pre>
	 */
	public void searchBoard(String title) {
		
		ArrayList<BoardVO> allList = bd.readBoardList();
		rp.printAllList(allList);
		//TODO 전체글 조회가 다 출력하라는게 맞는건지?
		
		ArrayList<BoardVO> searchList = new ArrayList<>();
		for(int i = 0; i < allList.size(); i++) {
			
			if(title.equals(allList.get(i).getBoardTitle())) {
				
				searchList.add(allList.get(i)); break;
			} 
		}
		
		if(!searchList.isEmpty()) {
			
			System.out.println("검색한 제목 : " + title);
			rp.printBoard(searchList.get(0));
		} else {
			
			rp.noSearchResult();
		}
	}

	/**
	 * <pre>
	 * 정렬 처리용 메소드
	 * </pre>
	 */
	public void sortList(Comparator<BoardVO> c) {
		
		ArrayList<BoardVO> list = bd.readBoardList();
		list.sort(c);
		rp.printAllList(list);
	}
}
