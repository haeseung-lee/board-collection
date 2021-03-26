package com.greedy.silsub02.vo;

import java.io.Serializable;
import java.util.Date;

public class BoardVO implements Serializable{
	
	private static final long serialVersionUID = 4246175771718681912L;
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Date boardDate;
	private String boardContent;
	private int readCount;
	
	public BoardVO() {}
	
	public BoardVO(int boardNo, String boardTitle, String boardWriter, Date boardDate, String boardContent) {
		
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
	}
	
//	public void setSerialVersionUID(long serialVersionUID) {
//		BoardVO.serialVersionUID = serialVersionUID;
//	}
	

	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	public Date getBoardDate() {
		return boardDate;
	}
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public int getReadCount() {
		return readCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVO [serialVersionUID=");
		builder.append(serialVersionUID);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", boardTitle=");
		builder.append(boardTitle);
		builder.append(", boardWriter=");
		builder.append(boardWriter);
		builder.append(", boardDate=");
		builder.append(boardDate);
		builder.append(", boardContent=");
		builder.append(boardContent);
		builder.append(", readCount=");
		builder.append(readCount);
		builder.append("]");
		return builder.toString();
	}
}
