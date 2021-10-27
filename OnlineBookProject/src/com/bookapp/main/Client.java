package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int select = 0, bookid = 0, price = 0;
		String title, author, category, authorfind, categoryfind, titlefind;

		BookInter bookinter = new BookImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Press 1) To Add Book");
			System.out.println("Press 2) To Display all books");
			System.out.println("Press 3) To Search Book By Author");
			System.out.println("Press 4) To Search Book By Category");
			System.out.println("Press 5) To Search Book By Title");
			System.out.println("Press 6) To Exit");

			select = sc.nextInt();
			switch (select) {

			case 1:
				Book book = new Book();
				sc.nextLine();
				System.out.println("Enter the Title of Book");
				title = sc.nextLine();
				book.setTitle(title);
				System.out.println("Enter the Name of the Author");
				author = sc.nextLine();
				book.setAuthor(author);
				System.out.println("Enter the Category of Book");
				category = sc.nextLine();
				book.setCategory(category);
				System.out.println("Enter the BookId");
				bookid = sc.nextInt();
				book.setBookid(bookid);
				System.out.println("Enter the Book Price");
				price = sc.nextInt();
				book.setPrice(price);
				bookinter.addBook(book);
				break;
			case 2:
				System.out.println(bookinter.getAllBooks());
				break;
			case 3:
				System.out.println("Enter the Author Name to Search");
				sc.nextLine();
				authorfind = sc.nextLine();
				try {
					System.out.println(bookinter.getBookByAuthor(authorfind));
				} catch (AuthorNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					System.exit(0);
				}
				break;

			case 4:
				System.out.println("Enter the Category to Search");
				sc.nextLine();
				categoryfind = sc.nextLine();
				try {
					System.out.println(bookinter.getBookByCategory(categoryfind));
				} catch (CategoryNotFoundException e) {
					System.out.println(e.getMessage());
					System.exit(0);

				}
				break;
			case 5:
				System.out.println("Enter the Title to Search");
				sc.nextLine();
				titlefind = sc.nextLine();
				try {
					System.out.println(bookinter.getBookByBookName(titlefind));
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
					System.exit(0);

				}
				break;
			default:
				System.exit(0);
			}

		}

	}
}
