package request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import model.Brand;



import java.math.BigDecimal;

@Builder
@Value

public class CreateCarAdvertisementRequest {
    @NonNull
    private Brand brand;
    @NonNull
    private String model;
    @NonNull
    private BigDecimal carMileage;
    @NonNull
    private int year;
    @NonNull
    private double price;

    public CreateCarAdvertisementRequest(@NonNull Brand brand, @NonNull String model, @NonNull BigDecimal carMileage, @NonNull int year, @NonNull double price) {
        this.brand = brand;
        this.model = model;
        this.carMileage = carMileage;
        this.year = year;
        this.price = price;
    }


}
