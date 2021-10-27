package com.bookapp.service;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public interface BookInter {
	void addBook(Book book);

	List<Book> getAllBooks();

	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	List<Book> getBookByCategory(String author) throws CategoryNotFoundException;

	List<Book> getBookByBookName(String author) throws BookNotFoundException;

}
