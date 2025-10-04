package LibraryCatalogue;

public interface Repository<T> {
    void addItem(T item);
    void deleteItem(T item);
    void updateItem(T item);
    void display();
}
