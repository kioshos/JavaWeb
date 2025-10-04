package LibraryCatalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends PaperInfo {
    private String author;
    private String genre;
    private int pages;
    public Book(String title, String publisher, Date publishDate, String author, String genre, int pages) {
        super(title, publisher, publishDate);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
}
