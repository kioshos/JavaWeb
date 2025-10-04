package CarDepot.Repositories;

import CarDepot.Entities.Order;
import CarDepot.Interfaces.RepositoryImp;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
public class OrderRepository implements RepositoryImp<Order> {
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
    }

    @Override
    public void remove(Order item) {
    orders.remove(item);
    }

    @Override
    public void update(Order item) {
        for(int index = 0; index < orders.size(); index++){
            if(orders.get(index).equals(item)){
                orders.set(index, item);
            }
        }
    }

    @Override
    public ArrayList<Order> read() {
        return orders;
    }

    @Override
    public void bulkInsert(ArrayList<Order> items) {
        for(int index = 0; index < items.size(); index++){
            orders.add(items.get(index));
        }
    }
}
