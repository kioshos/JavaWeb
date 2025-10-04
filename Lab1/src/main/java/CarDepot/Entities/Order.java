package CarDepot.Entities;

import CarDepot.CargoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String destination;
    private CargoType cargoType;

    private int quantity;
    private int weight;
    private int neededExperience;

    private boolean isAssigned;
    private boolean isCompleted;
}