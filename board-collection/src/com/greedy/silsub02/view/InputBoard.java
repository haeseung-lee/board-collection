package com.greedy.silsub02.view;

import java.util.ArrayList;
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
		
		BoardVO board = new  BoardVO();
		
		board.setBoardTitle(inputBoardTitle());
		Scanner sc = new Scanner(System.in);
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		board.setBoardWriter(writer);
		board.setBoardContent(inputBoardContent());
		board.setBoardDate(new Date());
		return board;
//		내용 직접입력
//		System.out.println("내용 : ");
//		
//		String content = "";
//		
//		while(true) {
//			String input = sc.nextLine();
//			if(input.equals("exit")) {
//				break;
//			} else {
//				content += input + "\n";
//				board.setBoardContent(content);
//			}
//		}
		
//		do {
//		 book.setBoardContent(sc.nextLine());
//		 sc.nextLine();
//		 System.out.println("여기까진됨");
//		} while(!sc.nextLine().equals("exit"));
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
		
//		입력받은 번호를 찾아서 있으면 return 없으면 error message 출력하고 메소드 종료하고 싶다면?		
		BoardDao bd = new BoardDao();
		int num = 0;
		ArrayList<BoardVO> list = bd.readBoardList();
		for(int i = 0; i < list.size(); i++) {
			if(inputNum == list.get(i).getBoardNo()) {
				num = inputNum;
				break;
			}
		}
		return num;
	}
	
	/**
	 * <pre>
	 * 제목을 입력받아 리턴
	 * </pre>
	 */
	public String inputBoardTitle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("글제목 : ");
		String str = sc.nextLine();
		return str;
	}
	
	/**
	 * <pre>
	 * 내용을 입력받아 리턴
	 * </pre>
	 */
	public String inputBoardContent() {		
	
	BoardVO board = new BoardVO();
	Scanner sc= new Scanner(System.in);
	
	System.out.println("내용 : ");
	String content = "";
		while(true) {
			String input = sc.nextLine();
			if(input.equals("exit")) {
				break;
			} else {
				content += input + "\n";
			}
		}
		return content;
	}
}
