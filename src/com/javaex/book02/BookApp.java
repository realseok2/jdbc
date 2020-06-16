package com.javaex.book02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();

		// 책 추가
//		BookVo vo01 = new BookVo("우리들의 찌그러진 영웅", "다림", "2012-01-23", 1);
//		bookDao.bookInsert(vo01);
//		
//		BookVo vo02 = new BookVo("신서유기", "민음사", "2000-02-01", 1);
//		bookDao.bookInsert(vo02);

		// 책 수정
		BookVo vo03 = new BookVo(2, "이말년 삼국지", "네이버웹툰", "2009-11-11", 1);
		bookDao.bookUpdate(vo03);

		// 책 삭제
		bookDao.bookDelete(2);

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
