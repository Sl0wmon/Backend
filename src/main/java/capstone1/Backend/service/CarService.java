package capstone1.Backend.service;

import capstone1.Backend.dto.CarDto;
import capstone1.Backend.entity.Car;
import capstone1.Backend.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car addCar(CarDto carDto) {
        Car car = new Car();
        car.setCarId(carDto.getCarId());
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

    public boolean deleteCar(String carId) {
        List<Car> car = carRepository.findByCarId(carId);
        if (!car.isEmpty()) {
            for (Car c : car) {
                if (c.getCarId().equals(carId)) {
                    carRepository.delete(c);
                    return true;
                }
            }
        }
        return false;
    }
}
