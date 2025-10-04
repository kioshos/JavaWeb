package CarDepot;

import CarDepot.Entities.Order;
import CarDepot.Interfaces.GenerateEntityImp;
import net.datafaker.Faker;

import java.util.ArrayList;

public class OrderGenerator implements GenerateEntityImp<Order> {
    Faker faker = new Faker();
    @Override
    public ArrayList<Order> generateEntity(int count) {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String destination = faker.address().city();
            CargoType type = faker.options().option(CargoType.class);
            int quantity = faker.number().numberBetween(7, 45);
            int experience = faker.number().numberBetween(1, 10);
            int weight = faker.number().numberBetween(500, 5000);
            orders.add(i, new Order(destination,type,quantity,weight,experience,false,false));
        }
        return orders;
    }
}
