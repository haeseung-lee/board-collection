package com.greedy.silsub02.view;

import java.util.Date;
import java.util.Scanner;

import com.greedy.silsub02.model.dao.BoardDao;
import com.greedy.silsub02.vo.BoardVO;

public class InputBoard {

	/**
	 * <pre>
	 * 게시글등록 : 
	 * BoardVO객체를 생성하여 글제목, 작성자, 글내용 입력 받음
	 * 글작성은 한번 입력 받을 때마다 줄바꿈 적용
	 * "exit" 키워드 입력 받으면 글작성 종료
	 * 날짜는 현재 날짜로 등록
	 * </pre>
	 */
	public BoardVO inputBoard() {
		
		BoardVO book = new  BoardVO();
		Scanner sc = new Scanner(System.in);
		
		book.setBoardTitle(inputBoardTitle());
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		book.setBoardWriter(writer);
		System.out.println("내용 : ");
		
		String content = "";
		
		while(true) {
			String input = sc.nextLine();
			if(input.equals("exit")) {
				break;
			} else {
				content += input + "\n";
				book.setBoardContent(content);
			}
		}
		
//		do {
//		 book.setBoardContent(sc.nextLine());
//		 sc.nextLine();
//		 System.out.println("여기까진됨");
//		} while(!sc.nextLine().equals("exit"));
		book.setBoardDate(new Date());
		return book;
	}
	
	/**
	 * <pre>
	 * 글번호를 입력받아 리턴
	 * </pre>
	 */
	public int inputBoardNo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력하세요");
		int inputNum = sc.nextInt();
		int no = 0;
		BoardDao bd = new BoardDao();
		
		
		
		return inputNum;
	}
	
	/**
	 * <pre>
	 * 제목을 입력받아 리턴
	 * </pre>
	 */
	public String inputBoardTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 : ");
		String str = sc.nextLine();
		
		return str;
	}
	
	/**
	 * <pre>
	 * 내용을 입력받아 리턴
	 * </pre>
	 */
	public String inputBoardContent() {
		return new BoardVO().getBoardContent();
	}
}
