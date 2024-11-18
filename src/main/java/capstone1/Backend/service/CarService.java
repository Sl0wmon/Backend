package capstone1.Backend.service;

import capstone1.Backend.dto.CarDto;
import capstone1.Backend.entity.Car;
import capstone1.Backend.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Car getCar(String carId) {
        return carRepository.findById(carId).orElse(null);
    }

    public Car getCarByUserId(String userId) {
        return carRepository.findByUserId(userId).orElse(null);
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
}
