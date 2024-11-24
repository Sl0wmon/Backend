package capstone1.Backend.service;

import capstone1.Backend.dto.CarDto;
import capstone1.Backend.entity.Car;
import capstone1.Backend.repository.CarRepository;
import capstone1.Backend.repository.ConsumableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ConsumableRepository consumableRepository;

    public Car addCar(CarDto carDto) {
        Car car = new Car();
        car.setCarId(carDto.getManufacturer().toUpperCase() + carDto.getYear() + System.currentTimeMillis());
        car.setUserId(carDto.getUserId());
        car.setManufacturer(carDto.getManufacturer());
        car.setSize(carDto.getSize());
        car.setModel(carDto.getModel());
        car.setFuel(carDto.getFuel());
        car.setDisplacement(carDto.getDisplacement());
        car.setYear(carDto.getYear());
        return carRepository.save(car);
    }

    public List<Car> getCar(String carId) {
        return carRepository.findByCarId(carId);
    }

    public List<Car> getCarByUserId(String userId) {
        return carRepository.findByUserId(userId);
    }

    public Car updateCar(CarDto carDto) {
        Car car = carRepository.findById(carDto.getCarId()).orElse(null);
        if (car == null) {
            return null;
        }
        car.setManufacturer(carDto.getManufacturer());
        car.setSize(carDto.getSize());
        car.setModel(carDto.getModel());
        car.setFuel(carDto.getFuel());
        car.setDisplacement(carDto.getDisplacement());
        car.setYear(carDto.getYear());
        return carRepository.save(car);
    }

    public boolean deleteCar(String userId) {
        List<Car> car = carRepository.findByUserId(userId);
        if (!car.isEmpty()) {
            for (Car c : car) {
                consumableRepository.deleteById(c.getCarId());
                carRepository.delete(c);
            }
            return true;
        }
        return false;
    }

    public String getManufacturer(String userId) {
        List<Car> car = carRepository.findByUserId(userId);
        if (!car.isEmpty()) {
            return car.get(0).getManufacturer();
        }
        return null;
    }
}
