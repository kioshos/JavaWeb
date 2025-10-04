package CarDepot.Entities;
import CarDepot.CargoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private double carryingCapacity;
    private ArrayList<CargoType> supportedCargoTypes = new ArrayList<>();
    private boolean isAvailable;

    public boolean canCarry(CargoType cargoType, double weight) {
        return supportedCargoTypes.contains(cargoType) && carryingCapacity >= weight;
    }
}
