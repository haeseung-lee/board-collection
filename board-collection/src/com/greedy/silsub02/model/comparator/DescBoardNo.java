package com.greedy.silsub02.model.comparator;

import java.util.Comparator;

import com.greedy.silsub02.vo.BoardVO;

public class DescBoardNo implements Comparator<BoardVO>{
    
	@Override
	public int compare(BoardVO b1, BoardVO b2) {
		
		return b2.getBoardNo() - b1.getBoardNo();
	}

}
