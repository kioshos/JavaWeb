package CarDepot.Interfaces;

import CarDepot.CargoType;
import CarDepot.Entities.Car;
import CarDepot.Entities.Driver;
import CarDepot.Entities.Order;
import lombok.NonNull;

import java.util.ArrayList;

public interface DepotImp {
    ArrayList<Driver> getAvailableSuitableDrivers(int exp);
    ArrayList<Car> getSuitableCars(int weight, CargoType cargoType);
    ArrayList<Order> getUnassignedOrders();
    void addDriver(@NonNull Driver driver);
    void addOrder(@NonNull Order order);
    void addCar(@NonNull Car car);
}
