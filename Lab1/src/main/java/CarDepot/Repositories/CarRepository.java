package CarDepot.Repositories;

import CarDepot.Entities.Car;
import CarDepot.Interfaces.RepositoryImp;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
@NoArgsConstructor
public class CarRepository implements RepositoryImp<Car> {
    ArrayList<Car> cars = new ArrayList<>();

    

    @Override
    public void add(Car item) {
        cars.add(item);
    }

    @Override
    public void remove(@NonNull Car item) {
     cars.remove(item);
    }

    @Override
    public void update(@NonNull Car updateItem) {
        for(int index = 0; index < cars.size(); index++){
            if(cars.get(index).equals(updateItem)){
                cars.set(index, updateItem);
                return;
            }
        }
    }

    @Override
    public ArrayList<Car> read() {
        return cars;
    }

    @Override
    public void bulkInsert(ArrayList<Car> items) {
        for(int index = 0; index < items.size(); index++){
            cars.add(items.get(index));
        }
    }
}
