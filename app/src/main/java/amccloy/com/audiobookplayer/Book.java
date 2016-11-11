package amccloy.com.audiobookplayer;

import java.util.List;

/**
 * Representation of a single book
 */

public class Book {
	private String title;
	private List<Chapter> chapters;
	private String coverFilepath;
	private boolean isRead;

	private int curChapter; // position in chapters list
	private int curPosition; // in ms
}
