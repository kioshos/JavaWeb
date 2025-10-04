package LibraryCatalogue;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;

public class PapersGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Book generateBook() {
        String title = faker.book().title();
        String author = faker.book().author();
        String publisher = faker.book().publisher();

        String genre = faker.book().genre();
        int pages = 100 + random.nextInt(400);
        Date publishDate = faker.date().between(new Date(01,01,1971),new Date(01,01,2025));
        return new Book(title, publisher, publishDate, author, genre, pages);
    }

    public static Newspaper generateNewspaper() {
        String title = faker.book().title();
        String publisher = faker.book().publisher();

        Date publishDate = faker.date().between(new Date(01,01,1971),new Date(01,01,2025));
        int issueNumber = 1 + random.nextInt(1000);

        LocalDate date = LocalDate.now().minusDays(random.nextInt(512));
        Map<String, String> columns = generateFakeColumns();
        return new Newspaper(title, publisher, publishDate, issueNumber, date, columns);
    }

    public static Almanac generateAlmanac() {
        String title = faker.book().title();
        String publisher = faker.book().publisher();

        Date publishDate = faker.date().between(new Date(01,01,1971),new Date(01,01,2025));

        String genre = faker.book().genre();
        int pages = 100 + random.nextInt(200);
        ArrayList<Book> papers = (ArrayList<Book>)generateBookList(2 + random.nextInt(4));

        return new Almanac(title, publisher, publishDate, genre, pages, papers);
    }

    private static Map<String, String> generateFakeColumns() {
        Map<String, String> columns = new HashMap<>();
        int numColumns = 2 + random.nextInt(4);

        for (int i = 0; i < numColumns; i++) {
            String columnTitle = faker.book().author();
            String content = faker.lorem().sentence(10 + random.nextInt(20));
            columns.put(columnTitle, content);
        }

        return columns;
    }

    private static List<Book> generateBookList(int size) {
        ArrayList<Book> books = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            books.add(generateBook());
        }

        return books;
    }
}
