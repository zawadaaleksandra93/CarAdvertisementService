package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
public class CarAdvertisement {
    LocalDate creationTime;
    private String brand;
    private String model;
    private BigDecimal carMileage;
    private int year;
    private double price;

}
