package LibraryCatalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PaperInfo {
    protected String title;
    protected String publisher;
    protected Date publishDate;
}
