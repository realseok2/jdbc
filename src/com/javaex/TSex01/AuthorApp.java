package com.javaex.TSex01;

import java.util.List;

import com.javaex.author01.AuthorDao;
import com.javaex.author01.AuthorVo;

public class AuthorApp {

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		// 작가 추가
		// authorDao.authorInsert("이문열", "경북 영양");
		// authorDao.authorInsert("박경리", "경상남도 통영");
		// authorDao.authorInsert("이말년", "침착맨");
		// authorDao.authorInsert("김기안", "기안팔십사");

		// 작가 수정
		authorDao.authorUpdate(3, "수정 - 이말년", "수정 - 털복숭이 침착맨");

		// 작가 삭제
		authorDao.authorDelete(2);

		// 작가 리스트
		List<AuthorVo> authorList = authorDao.getAuthorList();

		// 출력코드
		System.out.println("===========================");
		for (AuthorVo vo : authorList) {
			System.out.println(vo.getAuthorId() + ",   " + vo.getAuthorName() + ",   " + vo.getAuthorDesc());
		}
		System.out.println("===========================");

	}

}
