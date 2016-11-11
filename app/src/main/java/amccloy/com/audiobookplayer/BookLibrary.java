package amccloy.com.audiobookplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of books, organised by series
 */

public class BookLibrary {
	private List<BookSeries> seriess;
	private List<Book> books;

	public BookLibrary() {
		seriess = new ArrayList<BookSeries>();
		books = new ArrayList<Book>();

	}

	/**
	 * Populates the booklibrary from the file structure in this apps external folder
	 */
	public void populate() {
		FSHelper.test();
	}

	//Adds a book to the library
	public void addBook(Book b) {
		books.add(b);
	}

	//Adds a series to the library
	//TODO Make this not just add all the books to books
	public void addSeries(BookSeries bs) {
		for (Book b : bs.getBooks()) {
			books.add(b);
		}
	}


}
