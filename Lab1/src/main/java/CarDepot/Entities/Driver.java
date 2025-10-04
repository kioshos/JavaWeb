package CarDepot.Entities;

import CarDepot.Interfaces.ObserverImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private Car car;
    private String name;
    private int experience;
    private double balance;

    private Order currentOrder;
    private ObserverImp driverObserver;

    public Driver(String name, int experience, Car car) {
        this.name = name;
        this.experience = experience;
        this.car = car;
        this.balance = 0.0;
    }
    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
        this.balance = 0.0;
    }
    public void completingOrder(){
        try{
            System.out.println("The driver is in the way");
            Thread.sleep(10000);
            completeOrder();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public void completeOrder() {
        currentOrder.setCompleted(true);

        if (driverObserver != null) {
            driverObserver.notify(currentOrder, this);
        }

        currentOrder = null;
    }
}
