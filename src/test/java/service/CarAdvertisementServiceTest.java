package service;

import model.Brand;
import model.CarAdvertisement;
import org.junit.Test;
import repository.InMemoryCarAdvertisementRepository;
import request.CreateCarAdvertisementRequest;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CarAdvertisementServiceTest {

    private static final Brand BRAND = Brand.TOYOTA;
    private static final Brand BRANDFIAT = Brand.FIAT;
    private static final String MODEL = "Auris";
    private static final String MODEL500 = "500";
    private static final int YEAR = 2015;
    private static final BigDecimal CARMILEAGE = BigDecimal.valueOf(90000);
    private static final int PRICE = 54000;
    private static final LocalDate LOCAL_DATE = LocalDate.now();

    CarAdvertisementService service = new CarAdvertisementService(InMemoryCarAdvertisementRepository.getInstance());

    CreateCarAdvertisementRequest request1 = CreateCarAdvertisementRequest.builder()
            .brand(BRANDFIAT)
            .model(MODEL500)
            .carMileage(CARMILEAGE)
            .year(YEAR)
            .price(PRICE)
            .build();
    CreateCarAdvertisementRequest request2 = CreateCarAdvertisementRequest.builder()
            .brand(BRANDFIAT)
            .model(MODEL500)
            .carMileage(CARMILEAGE)
            .year(YEAR)
            .price(PRICE)
            .build();
    CreateCarAdvertisementRequest request3 = CreateCarAdvertisementRequest.builder()
            .brand(BRANDFIAT)
            .model(MODEL500)
            .carMileage(CARMILEAGE)
            .year(YEAR)
            .price(PRICE)
            .build();
    Optional<CarAdvertisement> carAdvertisement1 = service.createCarAdvertisement(request1);
    Optional<CarAdvertisement> carAdvertisement2 = service.createCarAdvertisement(request2);
    Optional<CarAdvertisement> carAdvertisement3 = service.createCarAdvertisement(request3);



    @Test
    public void schouldCreateCarAdvertisementWhileThereIsNoCarAdvertisements() {

        //given
        CreateCarAdvertisementRequest request = CreateCarAdvertisementRequest.builder()
                .brand(BRAND)
                .model(MODEL)
                .carMileage(CARMILEAGE)
                .year(YEAR)
                .price(PRICE)
                .build();

        //when
        Optional<CarAdvertisement> carAdvertisement = service.createCarAdvertisement(request);

        //then
        Assertions.assertThat(carAdvertisement.isPresent()).isTrue();
        Assertions.assertThat(carAdvertisement.get().getBrand()).isEqualTo(BRAND);
        Assertions.assertThat(carAdvertisement.get().getModel()).isEqualTo(MODEL);
        Assertions.assertThat(carAdvertisement.get().getCarMileage()).isEqualTo(CARMILEAGE);
        Assertions.assertThat(carAdvertisement.get().getYear()).isEqualTo(YEAR);
        Assertions.assertThat(carAdvertisement.get().getPrice()).isEqualTo(PRICE);
        Assertions.assertThat(carAdvertisement.get().getCreationDate()).isEqualTo(LOCAL_DATE);

    }




    @Test
    public void schouldNotCreateCarAdvertisementWhileThereAreAlreadyThreeAdvertisementsForCarFromParticularBrand() {

        //given
        CreateCarAdvertisementRequest request = CreateCarAdvertisementRequest.builder()
                .brand(BRANDFIAT)
                .model(MODEL500)
                .carMileage(CARMILEAGE)
                .year(YEAR)
                .price(PRICE)
                .build();

        //when
        Optional<CarAdvertisement> carAdvertisement = service.createCarAdvertisement(request);

        //then
        Assertions.assertThat(carAdvertisement.isEmpty()).isTrue();

    }

}