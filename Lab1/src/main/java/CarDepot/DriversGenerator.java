package CarDepot;

import CarDepot.Entities.Driver;
import CarDepot.Interfaces.GenerateEntityImp;
import net.datafaker.Faker;

import java.util.ArrayList;

public class DriversGenerator implements GenerateEntityImp<Driver> {
    private Faker faker = new Faker();
    @Override
    public ArrayList<Driver> generateEntity(int count) {
        ArrayList<Driver> drivers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String name = faker.formula1().driver();
            int experience = faker.number().numberBetween(1, 10);
            drivers.add(i, new Driver(name, experience));
        }
        return drivers;
    }
}
