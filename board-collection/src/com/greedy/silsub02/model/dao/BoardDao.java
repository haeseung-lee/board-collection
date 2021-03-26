package com.greedy.silsub02.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.greedy.silsub02.vo.BoardVO;

public class BoardDao {

	public BoardDao() {}
	
	/**
	 * boardList.txt 파일에서 리스트 목록 불러오기
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ArrayList<BoardVO> readBoardList() {
		
		ObjectInputStream objIn = null;
		ArrayList<BoardVO> result = new ArrayList<>(); 
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/com/greedy/silsub02/model/dao/boardList.txt")));
			
			while(true){
				
				result.add((BoardVO) objIn.readObject());
			}
			
		}catch(EOFException e) {
			
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (FileNotFoundException e1) {
			System.out.println("파일이 없음");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if(objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
			
		
//		try {
//			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/com/greedy/silsub02/model/dao/boardList.txt")));
//			while(true) {
//				
//				try {
//					
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(objIn != null) {
//				try {
//					objIn.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
		
	}
	
	/**
	 * boardList.txt파일에 리스트 기록하기
	 * 파일 성공여부를 정수값으로 전달
	 * 실패 : 0, 성공 : 1 
	 */
	public int writeBoardList(ArrayList<BoardVO> list) {
		
		
		ObjectOutputStream objOut = null; 

		
		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/greedy/silsub02/model/dao/boardList.txt")));
			
		
			
			for(int i = 0; i < list.size(); i++) {
				objOut.writeObject(list.get(i));
			}
			objOut.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
//		try {
//			
//			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/com/greedy/silsub02/model/dao/boardList.txt")));
//			
//			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/greedy/silsub02/model/dao/boardList.txt")));
//			
//			
//			for(int i = 0; i < list.size(); i++) {
//				objOut.writeObject(list.get(i));
//			}
//			objOut.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(objOut != null) {
//				try {
//					objOut.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
		return 1;
	}
	
}
