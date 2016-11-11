package amccloy.com.audiobookplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amccl_000 on 09/11/2016.
 */

public class BookSeries {
	private String seriesTitle;
	private List<Book> books;

	public BookSeries() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}
}
