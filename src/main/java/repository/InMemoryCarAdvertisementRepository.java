package repository;


import model.Brand;
import model.CarAdvertisement;
import request.CreateCarAdvertisementRequest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class InMemoryCarAdvertisementRepository implements CarAdvertisementRepositiory {


    private List<CarAdvertisement> carAdvertisements;
    private static InMemoryCarAdvertisementRepository repository;

    public static InMemoryCarAdvertisementRepository getInstance() {
        if (repository == null) {
            repository = new InMemoryCarAdvertisementRepository();
        }
        return repository;
    }


    @Override
    public CarAdvertisement create(CreateCarAdvertisementRequest request) {

        LocalDate creationDate = LocalDate.now();

        CarAdvertisement carAdvertisement = CarAdvertisement.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .carMileage(request.getCarMileage())
                .year(request.getYear())
                .price(request.getPrice())
                .creationDate(creationDate)
                .build();
        carAdvertisements.add(carAdvertisement);

        return carAdvertisement;
    }

    @Override
    public List<CarAdvertisement> findAll() {
        return Collections.unmodifiableList(carAdvertisements);
    }

    @Override
    public long numberOfCarsFromListWithSameBrandAsUsersCar(CreateCarAdvertisementRequest request) {
        Brand modelFromUser =request.getBrand();
        long numberOfCarsFromListWithSameBrandAsUsersCar = carAdvertisements.stream()
                .filter(carAdvertisements -> carAdvertisements.getBrand().equals(modelFromUser))
                .count();
        return numberOfCarsFromListWithSameBrandAsUsersCar;
    }

}
