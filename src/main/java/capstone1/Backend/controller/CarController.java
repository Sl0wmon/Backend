package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.CarDto;
import capstone1.Backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/car/add")
    public Response<?> addCar(@RequestBody CarDto carDto) {
        return new Response<>("true", "차량 등록 완료", carService.addCar(carDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/car/view")
    public Response<?> getCar(@RequestBody CarDto carDto) {
        return new Response<>("true", "차량 정보 조회 완료", carService.getCar(carDto.getCarId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/car/view/user")
    public Response<?> getCarByUserId(@RequestBody CarDto carDto) {
        return new Response<>("true", "사용자 차량 정보 조회 완료", carService.getCarByUserId(carDto.getUserId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/car/update")
    public Response<?> updateCar(@RequestBody CarDto carDto) {
        return new Response<>("true", "차량 정보 업데이트 완료", carService.updateCar(carDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/car/delete")
    public Response<?> deleteCar(@RequestBody CarDto carDto) {
        return new Response<>("true", "차량 정보 삭제 완료", carService.deleteCar(carDto.getUserId()));
    }
}
