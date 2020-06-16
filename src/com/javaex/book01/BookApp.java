package com.javaex.book01;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();

		// 책 추가
//		bookDao.bookInsert("우리들의 찌그러진 영웅", "다림", "2012-02-22", 1);
//		bookDao.bookInsert("삼국지", "민음사", "2007-08-15", 1);
//		bookDao.bookInsert("토지", "민음사", "2007-08-15", 2);
//		bookDao.bookInsert("유시민 일기", "민음사", "2007-08-15", 3);
//		bookDao.bookInsert("순정만화", "민음사", "2007-08-15", 4);
//		bookDao.bookInsert("오직두사람", "민음사", "2007-08-15", 5);
//		bookDao.bookInsert("26년", "민음사", "2007-08-15", 4);
//		bookDao.bookInsert("기안팔십사", "민음사", "2007-08-15", 6);

		// 책 수정
		bookDao.bookUpdate(2, "이말년 삼국지", "네이버웹툰", "2009-11-11", 6);

		// 책 삭제
//		bookDao.bookDelete(1);

		// 책 리스트 준비
		List<BookVo> bookList = bookDao.getBookList();

		// 출력 내용
		System.out.println("==================================");
		for (BookVo vo : bookList) {
			System.out.println(vo.getBookId() + ",   " + vo.getTitle() + ",   " + vo.getPubs() + ",   "
					+ vo.getPubDate() + ",   " + vo.getAuthorId());
		}

	}

}
