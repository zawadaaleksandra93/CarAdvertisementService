package service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Brand;


import model.CarAdvertisement;
import repository.CarAdvertisementRepositiory;
import repository.InMemoryCarAdvertisementRepository;
import request.CreateCarAdvertisementRequest;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
public class CarAdvertisementService {
    
    private CarAdvertisementRepositiory repositiory;

    private List<CarAdvertisement> carAdvertisements;

    public CarAdvertisementService(InMemoryCarAdvertisementRepository instance) {

    }


    public Optional<CarAdvertisement> createCarAdvertisement(CreateCarAdvertisementRequest request){
     long numberOfCarsFromListWithSameBrandAsUsersCar = repositiory.numberOfCarsFromListWithSameBrandAsUsersCar(request);
        if (numberOfCarsFromListWithSameBrandAsUsersCar>=3){
            return Optional.empty();
        }

        return Optional.of(repositiory.create(request));
    }

    public List<CarAdvertisement> findAll() {
        return repositiory.findAll();
    }
}
