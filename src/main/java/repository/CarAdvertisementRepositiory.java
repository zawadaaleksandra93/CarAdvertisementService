package repository;

import model.CarAdvertisement;
import request.CreateCarAdvertisementRequest;

import java.util.List;

public interface CarAdvertisementRepositiory {

    CarAdvertisement create(CreateCarAdvertisementRequest request);

     List<CarAdvertisement> findAll();

long numberOfCarsFromListWithSameBrandAsUsersCar(CreateCarAdvertisementRequest request);
}
