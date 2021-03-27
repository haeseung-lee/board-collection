package com.greedy.silsub02.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.greedy.silsub02.vo.BoardVO;

public class ResultPrinter {

	/**
	 * <pre>
	 * 전달받은 객체 안에 있는 값 출력
	 * 출력할 내용이 없을 시 "게시물이 없습니다."를 출력
	 * </pre>
	 */
	public void printAllList(ArrayList<BoardVO> list) {
		
		if(list.isEmpty()) {
			
			System.out.println("게시물이 없습니다.");
		} else {
			
			for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));	
			} 
		}
	}
	
	/**
	 * <pre>
	 * 전달받은 내용 출력
	 * </pre>
	 */
	public void printBoard(BoardVO b) {
		
		System.out.println(b);
	}
	
	/**
	 * 에러메세지 출력
	 */
	public void errorPage(String msg) {
		
		switch(msg) {
		
		case "insertBoard" : System.out.println("게시글 등록 실패"); break;
		case "selectOne" : System.out.println("조회된 글이 없습니다."); break;
		case "updateTitle" : System.out.println("게시글 제목 수정 실패!"); break;
		case "updateContent" : System.out.println("게시글 내용 수정 실패!"); break;
		case "deleteBoard" : System.out.println("게시글 삭제 실패!");
		}
	}
	
	/**
	 * 성공메세지 출력
	 */
	public void successPage(String msg) {
		
		switch(msg) {
		
			case "insertBoard" : System.out.println("게시글 등록 성공!"); break;
			case "updateTitle" : System.out.println("게시글 제목 수정 성공!"); break;
			case "updateContent" : System.out.println("게시글 내용 수정 성공!"); break;
			case "deleteBoard" : System.out.println("게시글 삭제 성공!"); break;
		}
	}
	
	/**
	 * 검색결과 없을 시 출력 
	 * "검색 결과가 없습니다."
	 */
	public void noSearchResult() {
		
		System.out.println("검색 결과가 없습니다.");
	}
}
