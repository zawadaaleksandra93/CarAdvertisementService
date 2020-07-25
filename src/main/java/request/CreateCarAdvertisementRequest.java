package request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
@AllArgsConstructor
public class CreateCarAdvertisementRequest {
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private BigDecimal carMileage;
    @NonNull
    private int year;
    @NonNull
    private double price;
}
