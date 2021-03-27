package com.greedy.silsub02.model.comparator;

import java.util.Comparator;

import com.greedy.silsub02.vo.BoardVO;

public class DescBoardTitle implements Comparator<BoardVO>{

	@Override
	public int compare(BoardVO b1, BoardVO b2) {
		
		return b2.getBoardTitle().compareTo(b1.getBoardTitle());
	}

}
