package com.greedy.silsub02.model.comparator;

import java.util.Comparator;

import com.greedy.silsub02.vo.BoardVO;

public class AscBoardTitle implements Comparator<BoardVO>{

	@Override
	public int compare(BoardVO b1, BoardVO b2) {
		
		return b1.getBoardTitle().compareTo(b2.getBoardTitle());
	}
  
}
