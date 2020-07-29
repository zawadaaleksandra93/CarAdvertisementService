package repository;

import model.CarAdvertisement;
import request.CreateCarAdvertisementRequest;

import java.util.List;

public interface CarAdvertisementRepository {

    CarAdvertisement create(CreateCarAdvertisementRequest request);

    List<CarAdvertisement> findAll();

    long numberOfCarsFromListWithSameBrandAsUsersCar(CreateCarAdvertisementRequest request);
}
