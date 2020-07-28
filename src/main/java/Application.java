import model.Brand;
import model.CarAdvertisement;
import repository.InMemoryCarAdvertisementRepository;
import request.CreateCarAdvertisementRequest;
import service.CarAdvertisementService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static CreateCarAdvertisementRequest carAdvertisementRequest;

    public static void main(String[] args) {
        CarAdvertisementService carAdvertisementService = new CarAdvertisementService(InMemoryCarAdvertisementRepository.getInstance());
        Scanner scanner = new Scanner(System.in);

        createCarAdvertisement(carAdvertisementService, scanner);
        printAllCarAdvertisements(carAdvertisementService);





    }

    private static void createCarAdvertisement(CarAdvertisementService service, Scanner scanner) {
        System.out.println("hello!");
        System.out.println("please choose number for brand of your car:");
        System.out.println("1. AUDI");
        System.out.println("2. BMW");
        System.out.println("3. FIAT");
        System.out.println("4. KIA");
        System.out.println("5. TOYOTA");
        String usersBrand = scanner.next();
        Brand brandFromUser = null;
        if (usersBrand.equalsIgnoreCase(ONE)) {
            brandFromUser = Brand.AUDI;
        } else if (usersBrand.equalsIgnoreCase(TWO)) {
            brandFromUser = Brand.BMW;
        } else if (usersBrand.equalsIgnoreCase(THREE)) {
            brandFromUser = Brand.FIAT;
        } else if (usersBrand.equalsIgnoreCase(FOUR)) {
            brandFromUser = Brand.KIA;
        } else if (usersBrand.equalsIgnoreCase(FIVE)) {
            brandFromUser = Brand.TOYOTA;
        }

        System.out.println("please provide car model ");
        String carModelFromUser = scanner.next();
        System.out.println("please provide milage of your car: ");
        BigDecimal carMilageFromUser = scanner.nextBigDecimal();
        System.out.println("please provide year: ");
        int usersCarYear = scanner.nextInt();
        System.out.println("please provide requested price");
        double usersCarPrice = scanner.nextDouble();

        CreateCarAdvertisementRequest request = new CreateCarAdvertisementRequest(brandFromUser, carModelFromUser, carMilageFromUser, usersCarYear, usersCarPrice);

        Optional<CarAdvertisement> carAdvertisement = service.createCarAdvertisement(request);
        if (carAdvertisement.isEmpty()) {
            System.out.println("cannot create car advertisement");
        } else {
            System.out.println("Done");
        }

    }
private static void printAllCarAdvertisements(CarAdvertisementService service){
    List<CarAdvertisement> carAdvertisementList = service.findAll();
carAdvertisementList.forEach(ca -> {
    System.out.println("advertisement ");
    System.out.println("car brand: " + ca.getBrand());
    System.out.println("car model: " + ca.getModel());
    System.out.println("car milage: " + ca.getCarMileage());
    System.out.println("car year: " + ca.getYear());
    System.out.println("car price: " + ca.getPrice());
});
}
}
