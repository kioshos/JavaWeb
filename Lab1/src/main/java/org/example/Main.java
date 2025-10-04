package org.example;

import CarDepot.*;
import CarDepot.Entities.Car;
import CarDepot.Entities.Driver;
import CarDepot.Entities.Order;
import CarDepot.Interfaces.GenerateEntityImp;
import CarDepot.Interfaces.RepositoryImp;
import CarDepot.Repositories.CarRepository;
import CarDepot.Repositories.DriverRepository;
import CarDepot.Repositories.OrderRepository;
import LibraryCatalogue.Book;
import LibraryCatalogue.Catalogue;
import LibraryCatalogue.PaperInfo;
import LibraryCatalogue.Repository;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int DRIVER_COUNT = 7;
    private static final int ORDER_COUNT = 14;
    private static final int CAR_COUNT = 7;
    public static void main(String[] args) {

        Catalogue catalog = new Catalogue();

        catalog.initializeTestData(3);

        catalog.display();

        catalog.displayGroupedByType();

        ArrayList<PaperInfo> found = (ArrayList<PaperInfo>) catalog.searchByTitle(" ");

        ArrayList<Book> authorBooks = (ArrayList<Book>) catalog.searchBooksByAuthor(" ");

        found.forEach(System.out::println);
        authorBooks.forEach(System.out::println);


        System.out.println();
        System.out.println("==============================");
        System.out.println();


        GenerateEntityImp<Car> carGenerateEntityImp = new CarsGenerator();
        GenerateEntityImp<Driver> driverGenerateEntityImp = new DriversGenerator();
        GenerateEntityImp<Order> orderGenerateEntityImp = new OrderGenerator();

        ArrayList<Car> cars = carGenerateEntityImp.generateEntity(CAR_COUNT);
        ArrayList<Driver> drivers = driverGenerateEntityImp.generateEntity(DRIVER_COUNT);
        ArrayList<Order> orders = orderGenerateEntityImp.generateEntity(ORDER_COUNT);

        cars.forEach(System.out::println);
        drivers.forEach(System.out::println);
        orders.forEach(System.out::println);

        RepositoryImp<Car> carRepository = new CarRepository();
        RepositoryImp<Driver> driverRepository = new DriverRepository();
        RepositoryImp<Order> orderRepository = new OrderRepository();

        carRepository.bulkInsert(cars);
        driverRepository.bulkInsert(drivers);
        orderRepository.bulkInsert(orders);

        DepotService depotService = new DepotService(carRepository,driverRepository,orderRepository);

        DispatcherService dispatcher = new DispatcherService(depotService);
        dispatcher.assignOrderToDriver();




    }
}