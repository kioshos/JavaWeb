package CarDepot;

import CarDepot.Entities.Car;
import CarDepot.Entities.Driver;
import CarDepot.Entities.Order;
import CarDepot.Interfaces.DepotImp;
import CarDepot.Interfaces.RepositoryImp;
import lombok.NonNull;

import java.util.ArrayList;

public class DepotService implements DepotImp {
    private RepositoryImp<Car> carRepository;
    private RepositoryImp<Driver> driverRepository;
    private RepositoryImp<Order> orderRepository;

    public DepotService(RepositoryImp<Car> carRepository, RepositoryImp<Driver> driverRepository, RepositoryImp<Order> orderRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.orderRepository = orderRepository;
    }

    public ArrayList<Car> getSuitableCars(int weight, CargoType cargoType) {
        ArrayList<Car> cars = carRepository.read();

        return new ArrayList<>(cars.stream().filter(car -> car.canCarry(cargoType, weight))
                .sorted((c1, c2) -> {
                    double excess1 = c1.getCarryingCapacity() - weight;
                    double excess2 = c2.getCarryingCapacity() - weight;

                    return Double.compare(excess1, excess2);
                }).toList()) ;
    }
    public ArrayList<Driver> getAvailableSuitableDrivers(int experience) {
        ArrayList<Driver> drivers = driverRepository.read();
        return new ArrayList<>(drivers.stream().filter(driver -> driver.getCurrentOrder() == null && driver.getExperience() >= experience)
                .toList());
    }
    public ArrayList<Order> getUnassignedOrders() {
        ArrayList<Order> orders = orderRepository.read();
        return new ArrayList<>(orders.stream()
                .filter(order -> !order.isAssigned())
                .toList());
    }
    public void addOrder(@NonNull Order order) {
        orderRepository.add(order);
    }

    public void addCar(@NonNull Car car) {
        carRepository.add(car);
    }

    public void addDriver(@NonNull Driver driver) {
        driverRepository.add(driver);
    }
}
