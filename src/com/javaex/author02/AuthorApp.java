/*
 	Dao 만들기, Vo 사용
*/

package com.javaex.author02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		//등록
		AuthorVo vo01 = new AuthorVo("이문열", "경북 영양");
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02 = new AuthorVo("박경리", "경상남도 통영");
		 authorDao.authorInsert(vo02);

		//수정
		AuthorVo vo03 = new AuthorVo(2, "박경리", "경상남도 통영 --> Update");
		authorDao.authorUpdate(vo03); 
		 //authorDao.authorUpdate(2, "박경리", "경상남도 통영 --> Update");
		
		//삭제
		
		authorDao.authorDelete(2);

		
		
		
		
		
		// 리스트 가져오기
		List<AuthorVo> authorList = authorDao.getAuthorList();

		// 출력코드
		System.out.println("===========================");
		for (AuthorVo vo : authorList) {

			System.out.println(vo.getAuthorId() + ",   " + vo.getAuthorName() + ",   " + vo.getAuthorDesc());

		}
		System.out.println("===========================");

	}

}
