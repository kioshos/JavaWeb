package CarDepot.Repositories;

import CarDepot.Entities.Driver;
import CarDepot.Interfaces.RepositoryImp;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
        @NoArgsConstructor
public class DriverRepository implements RepositoryImp<Driver> {
    ArrayList<Driver> drivers = new ArrayList<>();
    @Override
    public void add(Driver item) {
        drivers.add(item);
    }

    @Override
    public void remove(Driver item) {
        drivers.remove(item);
    }

    @Override
    public void update(Driver item) {
        for(int index = 0; index < drivers.size(); index++){
            if(drivers.get(index).equals(item)){
                drivers.set(index, item);
            }
        }
    }

    @Override
    public ArrayList<Driver> read() {
        return drivers;
    }

    @Override
    public void bulkInsert(ArrayList<Driver> items) {
        for (int index = 0; index < items.size(); index++) {
            drivers.add(items.get(index));
        }
    }
}
