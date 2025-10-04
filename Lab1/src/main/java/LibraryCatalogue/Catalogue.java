package LibraryCatalogue;
import lombok.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalogue implements Repository<PaperInfo>{
    private ArrayList<PaperInfo> papers = new ArrayList<PaperInfo>();
    @Override
    public void addItem(@NonNull PaperInfo item) {
        papers.add(item);
    }
    public void addBook(Book book) {
        addItem(book);
    }
    public void addAlmanac(Almanac almanac) {
        addItem(almanac);
    }
    public void addNewspaper(Newspaper newspaper) {
        addItem(newspaper);
    }
    @Override
    public void deleteItem(@NonNull PaperInfo deleteItem) {
        papers.remove(deleteItem);
    }
    @Override
    public void updateItem(@NonNull PaperInfo updateItem) {
        for(int i = 0; i < papers.size(); i++){
            if(papers.get(i).equals(updateItem)){
                papers.set(i, updateItem);
                return;
            }
        }
    }
    @Override
    public void display() {
        papers.forEach(item -> System.out.println(item));
    }
    public void displayGroupedByType() {
        Map<String, List<PaperInfo>> grouped = papers.stream()
                .collect(Collectors.groupingBy(p -> p.getClass().getSimpleName()));

        grouped.forEach((type, items) -> {
            System.out.println("=== " + type + " ===");
            items.forEach(System.out::println);
            System.out.println();
        });
    }

    public List<PaperInfo> searchByTitle(String title) {
        return papers.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByAuthor(String author) {
        return papers.stream()
                .filter(p -> p instanceof Book)
                .map(p -> (Book) p)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public void initializeTestData(int countPerType) {
        for (int i = 0; i < countPerType; i++) {
            addBook(PapersGenerator.generateBook());
            addNewspaper(PapersGenerator.generateNewspaper());
            addAlmanac(PapersGenerator.generateAlmanac());
        }
    }
}
