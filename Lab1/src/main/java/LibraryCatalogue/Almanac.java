package LibraryCatalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Almanac extends PaperInfo {
    private String genre;
    private int pages;
    private ArrayList<Book> books;

    public Almanac(String title, String publisher, Date publishDate, String genre, int pages, ArrayList<Book> books) {
        super(title, publisher, publishDate);
        this.genre = genre;
        this.pages = pages;
        this.books = books;
    }
}
