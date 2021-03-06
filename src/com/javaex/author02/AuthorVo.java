package com.javaex.author02;

public class AuthorVo {

//--------------------------------------------------------------------------------------	필드
	private int authorId; // 작가 코드
	private String authorName; // 작가 이름
	private String authorDesc; // 작가 설명

//--------------------------------------------------------------------------------------	생성자
	public int getAuthorId() {
		return authorId;
	}

	public AuthorVo(String authorName, String authorDesc) {
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	public AuthorVo(int authorId, String authorName, String authorDesc) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

//--------------------------------------------------------------------------------------	getter, setter

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

//--------------------------------------------------------------------------------------	일반 메소드

	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

}
