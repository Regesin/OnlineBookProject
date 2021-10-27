package com.bookapp.service;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {
	List<Book> booklist = new ArrayList<>();
	List<Book> authorlist = new ArrayList<>();
	List<Book> categorylist = new ArrayList<>();
	List<Book> booksearchlist = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		booklist.add(book);
	}

	@Override
	public List<Book> getAllBooks() {
		Collections.sort(booklist, (book1, book2) -> {
			return book1.getTitle().compareTo(book2.getTitle());
		});
		if(booklist.size()==0) {
			System.out.println("No books in the Store");
		}
		return booklist;

	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		authorlist.clear();
		for (Book book : booklist) {
			if (book.getAuthor().equals(author)) {
				authorlist.add(book);
				Collections.sort(authorlist, (book1, book2) -> {
					return book1.getAuthor().compareTo(book2.getAuthor());
				});
			}
		}
		if (authorlist.size() == 0) {
			throw new AuthorNotFoundException("There is no book belong this author");
		}
		return authorlist;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		categorylist.clear();
		for (Book book : booklist) {
			if (book.getCategory().equals(category)) {
				categorylist.add(book);
				Collections.sort(categorylist, (book1, book2) -> {
					return book1.getCategory().compareTo(book2.getCategory());
				});
			}

		}
		if (categorylist.size() == 0) {
			throw new CategoryNotFoundException("This Category is not available in the library ");
		}

		return categorylist;
	}

	@Override
	public List<Book> getBookByBookName(String bookname) throws BookNotFoundException {
		booksearchlist.clear();
		for (Book book : booklist) {
			if (book.getTitle().equals(bookname)) {
				booksearchlist.add(book);
				Collections.sort(booksearchlist, (book1, book2) -> {
					return book1.getTitle().compareTo(book2.getTitle());
				});
			}
		}
		if (booksearchlist.size() == 0) {
			throw new BookNotFoundException("This book is not available in the library ");

		}
		return booksearchlist;
	}

}
