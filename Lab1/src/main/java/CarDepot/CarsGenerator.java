package CarDepot;

import CarDepot.Entities.Car;
import CarDepot.Interfaces.GenerateEntityImp;
import net.datafaker.Faker;

import java.util.ArrayList;

public class CarsGenerator implements GenerateEntityImp<Car> {
    private Faker faker = new Faker();
    @Override
    public ArrayList<Car> generateEntity(int count) {
        ArrayList<Car> cars = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String carModel = faker.vehicle().model();
            double carryingCapacity = faker.number().numberBetween(500, 5000);
            ArrayList<CargoType> types = new ArrayList<>();
            for(int j = 1; j <= faker.number().numberBetween(1,6); j++) {
                CargoType type = faker.options().option(CargoType.class);
                types.add(type);
            }
            cars.add(i, new Car(carModel,carryingCapacity,types,true));
        }
        return cars;
    }
}
