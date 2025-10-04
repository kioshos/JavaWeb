package CarDepot.Interfaces;

import CarDepot.Entities.Driver;
import CarDepot.Entities.Order;

public interface ObserverImp {
    void notify(Order order, Driver driver);
}
