package LibraryCatalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Newspaper extends PaperInfo {
    private int issueNumber;
    private Map<String, String> columns;

    public Newspaper(String title, String publisher, Date publishDate, int issueNumber, LocalDate date, Map<String, String> columns) {
        super(title, publisher, publishDate);
        this.issueNumber = issueNumber;
        this.columns = columns;
    }
}
