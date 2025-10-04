package CarDepot.Interfaces;

import java.util.ArrayList;

public interface RepositoryImp<T> {
    void add(T item);
    void remove(T item);
    void update(T item);
    ArrayList<T> read();
    void bulkInsert(ArrayList<T> items);
}
