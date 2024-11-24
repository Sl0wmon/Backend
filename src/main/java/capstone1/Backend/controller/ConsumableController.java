package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.AddConsumableDto;
import capstone1.Backend.dto.ConsumableDto;
import capstone1.Backend.service.ConsumableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConsumableController {
    private final ConsumableService consumableService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/consumable/add")
    public Response<?> addConsumable(@RequestBody AddConsumableDto addConsumableDto) {
        return new Response<>("true", "소모품 추가 완료",
                consumableService.addConsumable(addConsumableDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/consumable/view")
    public Response<?> getConsumable(@RequestBody ConsumableDto consumableDto) {
        return new Response<>("true", "소모품 조회 완료",
                consumableService.getConsumable(consumableDto.getCarId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/consumable/reset")
    public Response<?> updateConsumable(@RequestBody AddConsumableDto addConsumableDto) {
        return new Response<>("true", "소모품 초기화 완료",
                consumableService.resetConsumable(addConsumableDto.getCarId(), addConsumableDto.getConsumableType()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/consumable/addMileage")
    public Response<?> addMileage(@RequestBody AddConsumableDto addConsumableDto) {
        return new Response<>("true", "소모품 주행거리 추가 완료",
                consumableService.addMileage(addConsumableDto.getCarId(), addConsumableDto.getMileage()));
    }
}
