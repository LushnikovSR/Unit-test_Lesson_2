import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import task_2.Car;
import task_2.Motorcycle;
import task_2.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleTest {

    public String[] companyCarList = {"Toyota", "Toyota", "Toyota", "Toyota", "Toyota", "Toyota", "BMW", "BMW", "BMW", "BMW"};
    public String[] modelCarList = {"SA", "Crown", "Publica", "Corolla", "RAV4", "Prius", "315/1", "507", "2002", "CSL"};
    public Integer[] yearCarList = {1947, 1957, 1961, 1966, 1994, 1997, 1934, 1955, 1968, 1971};
    public String[] companyMotorcycleList = {"Honda", "Honda", "Honda", "Honda", "Honda", "Honda", "Yamaha", "Yamaha", "Yamaha", "Yamaha"};
    public String[] modelMotorcycleList = {"Model D", "Dream E", "Benly J", "Super Cub", "3RC164", "CB750", "Ya-2", "YDS-3", "TD1C 250", "RD350"};
    public Integer[] yearMotorcycleList = {1949, 1951, 1953, 1958, 1964, 1969, 1956, 1966, 1967, 1973};

    public static List<Car> getCarList(String[] companyList, String[] modelList, Integer[] yearList) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < companyList.length; i++) {
            cars.add(new Car(companyList[i], modelList[i], yearList[i]));
        }

        return cars;
    }

    public static List<Motorcycle> getMotorcycleList(String[] companyList, String[] modelList, Integer[] yearList) {
        List<Motorcycle> motorcycles = new ArrayList<>();

        for (int i = 0; i < companyList.length; i++) {
            motorcycles.add(new Motorcycle(companyList[i], modelList[i], yearList[i]));
        }

        return motorcycles;
    }

    /*
    1. Написать модульный тесты по проверке того, что экземпляр объекта Car
    также является экземпляром транспортного средства; (instanceof)
     */
    @Test
    public void checkInstanceCarClassIsInstanceVehicleClass(){
        List<Car> cars = getCarList(companyCarList, modelCarList, yearCarList);
        assertThat(cars.get(0)).isInstanceOf(Vehicle.class);
    }

    /*
    2. Написать модульный тесты по проверке того, объект Car создается с 4-мя колесами
     */
    @Test
    void checkInstanceCarClassHaveFourWheels(){
        List<Car> cars = getCarList(companyCarList, modelCarList, yearCarList);
        assertThat(cars.get(0).getNumWheels()).isEqualTo(4);
    }

    /*
    3. Написать модульный тесты по проверке того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void checkInstanceMotorcycleClassHaveTwoWheels(){
        List<Motorcycle> motorcycles = getMotorcycleList(companyMotorcycleList, modelMotorcycleList, yearMotorcycleList);
        assertThat(motorcycles.get(0).getNumWheels()).isEqualTo(2);
    }

    /*
    4. Написать модульный тесты по проверке того, объект Car развивает скорость 60
    в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkCarReachedTargetSpeed(){
        List<Car> cars = getCarList(companyCarList, modelCarList, yearCarList);
        cars.get(0).testDrive();
        assertThat(cars.get(0).getSpeed()).isEqualTo(60);
    }

    /*
    5. Написать модульный тесты по проверке того, объект Motorcycle
    развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkMotorcycleReachedTargetSpeed(){
        List<Motorcycle> motorcycles = getMotorcycleList(companyMotorcycleList, modelMotorcycleList, yearMotorcycleList);
        motorcycles.get(0).testDrive();
        assertThat(motorcycles.get(0).getSpeed()).isEqualTo(75);
    }

    /*
    6. Написать модульный тесты по проверке того, что в режиме парковки
    (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    public void checkCarParkMethod(){
        List<Car> cars = getCarList(companyCarList, modelCarList, yearCarList);
        cars.get(0).testDrive();
        cars.get(0).park();
        assertThat(cars.get(0).getSpeed()).isEqualTo(0);
    }

    /*
    7. Написать модульный тесты по проверке того, что в режиме парковки
    (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0)
     */
    @Test
    public void checkMotorcycleParkMethod(){
        List<Motorcycle> motorcycles = getMotorcycleList(companyMotorcycleList, modelMotorcycleList, yearMotorcycleList);
        motorcycles.get(0).testDrive();
        motorcycles.get(0).park();
        assertThat(motorcycles.get(0).getSpeed()).isEqualTo(0);
    }
}

