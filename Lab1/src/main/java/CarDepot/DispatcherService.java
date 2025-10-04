package CarDepot;

import CarDepot.Entities.Car;
import CarDepot.Entities.Driver;
import CarDepot.Entities.Order;
import CarDepot.Interfaces.DepotImp;
import CarDepot.Interfaces.ObserverImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class DispatcherService implements ObserverImp {
    private DepotImp depotService;

    public DispatcherService(DepotImp depotService) {
        this.depotService = depotService;
    }
    public void assignOrderToDriver() {
        ArrayList<Order> availableOrders = depotService.getUnassignedOrders();

        System.out.println("Available orders: " + availableOrders);

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        Order targetOrder = availableOrders.get(choose);

        ArrayList<Car> cars = depotService.getSuitableCars(targetOrder.getWeight(), targetOrder.getCargoType());
        ArrayList<Driver> availableDrivers = depotService.getAvailableSuitableDrivers(targetOrder.getNeededExperience());



        System.out.println("Drivers available: " + availableDrivers);

        choose =  scanner.nextInt();



        Driver targetDriver = availableDrivers.get(choose);

        System.out.println("Cars available: " + cars);
        choose = scanner.nextInt();
        Car targetCar = cars.get(choose);


        targetDriver.setCar(targetCar);
        targetDriver.setDriverObserver(this);
        targetDriver.setCurrentOrder(targetOrder);

        targetOrder.setAssigned(true);

        System.out.println("Assigned order to driver: " + targetDriver.getName() + ", order: " + targetOrder.getDestination());
        targetDriver.completingOrder();
    }
    @Override
    public void notify(Order order, Driver driver) {
        System.out.println("Driver: " + driver.getName() + " completed " + order.getDestination() + " order");
    }
}
