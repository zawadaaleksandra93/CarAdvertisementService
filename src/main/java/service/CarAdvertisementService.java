package service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import model.CarAdvertisement;
import repository.CarAdvertisementRepository;
import repository.InMemoryCarAdvertisementRepository;
import request.CreateCarAdvertisementRequest;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class CarAdvertisementService {

    private CarAdvertisementRepository repository;


    public CarAdvertisementService(InMemoryCarAdvertisementRepository instance) {
        this.repository = instance;
    }


    public Optional<CarAdvertisement> createCarAdvertisement(CreateCarAdvertisementRequest request) {
        long numberOfCarsFromListWithSameBrandAsUsersCar = repository.numberOfCarsFromListWithSameBrandAsUsersCar(request);
        if (numberOfCarsFromListWithSameBrandAsUsersCar >= 3) {
            return Optional.empty();
        }

        return Optional.of(repository.create(request));
    }

    public List<CarAdvertisement> findAll() {
        return repository.findAll();
    }
}
