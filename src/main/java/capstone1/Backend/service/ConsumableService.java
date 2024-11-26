package capstone1.Backend.service;

import capstone1.Backend.dto.AddConsumableDto;
import capstone1.Backend.entity.Consumable;
import capstone1.Backend.repository.ConsumableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ConsumableService {
    private final ConsumableRepository consumableRepository;

    private Consumable getExistingEntity(String carId) {
        Consumable consumable = new Consumable();
        Consumable existingConsumable = consumableRepository.findByCarId(carId);
        if (existingConsumable == null) {
            return new Consumable();
        }
        consumable.setMileage(existingConsumable.getMileage());
        consumable.setEngineOilMileage(existingConsumable.getEngineOilMileage());
        consumable.setEngineOilLast(existingConsumable.getEngineOilLast());
        consumable.setMissionOilMileage(existingConsumable.getMissionOilMileage());
        consumable.setMissionOilLast(existingConsumable.getMissionOilLast());
        consumable.setBrakeMileage(existingConsumable.getBrakeMileage());
        consumable.setBrakeLast(existingConsumable.getBrakeLast());
        consumable.setClutchMileage(existingConsumable.getClutchMileage());
        consumable.setClutchLast(existingConsumable.getClutchLast());
        consumable.setSteeringMileage(existingConsumable.getSteeringMileage());
        consumable.setSteeringLast(existingConsumable.getSteeringLast());
        consumable.setCoolantMileage(existingConsumable.getCoolantMileage());
        consumable.setCoolantLast(existingConsumable.getCoolantLast());
        consumable.setFuelFilterMileage(existingConsumable.getFuelFilterMileage());
        consumable.setFuelFilterLast(existingConsumable.getFuelFilterLast());
        consumable.setHeaterFilterMileage(existingConsumable.getHeaterFilterMileage());
        consumable.setHeaterFilterLast(existingConsumable.getHeaterFilterLast());
        consumable.setConditionerFilterMileage(existingConsumable.getConditionerFilterMileage());
        consumable.setConditionerFilterLast(existingConsumable.getConditionerFilterLast());
        consumable.setBrakeLiningMileage(existingConsumable.getBrakeLiningMileage());
        consumable.setBrakeLiningLast(existingConsumable.getBrakeLiningLast());
        consumable.setBrakePadFrontMileage(existingConsumable.getBrakePadFrontMileage());
        consumable.setBrakePadFrontLast(existingConsumable.getBrakePadFrontLast());
        consumable.setBrakePadBackMileage(existingConsumable.getBrakePadBackMileage());
        consumable.setBrakePadBackLast(existingConsumable.getBrakePadBackLast());
        consumable.setWheelAlignmentMileage(existingConsumable.getWheelAlignmentMileage());
        consumable.setWheelAlignmentLast(existingConsumable.getWheelAlignmentLast());
        consumable.setIgnitionPlugMileage(existingConsumable.getIgnitionPlugMileage());
        consumable.setIgnitionPlugLast(existingConsumable.getIgnitionPlugLast());
        consumable.setBatteryMileage(existingConsumable.getBatteryMileage());
        consumable.setBatteryLast(existingConsumable.getBatteryLast());
        consumable.setOuterBeltMileage(existingConsumable.getOuterBeltMileage());
        consumable.setOuterBeltLast(existingConsumable.getOuterBeltLast());
        consumable.setTimingBeltMileage(existingConsumable.getTimingBeltMileage());
        consumable.setTimingBeltLast(existingConsumable.getTimingBeltLast());
        return existingConsumable;
    }

    public Consumable addConsumable(AddConsumableDto addConsumableDto) {
        if (addConsumableDto == null) {
            throw new IllegalArgumentException("AddConsumableDto cannot be null");
        }

        String consumableType = addConsumableDto.getConsumableType();

        if (consumableType == null) {
            throw new IllegalArgumentException("Consumable type cannot be null");
        }

        Consumable consumable = getExistingEntity(addConsumableDto.getCarId());
        consumable.setCarId(addConsumableDto.getCarId());
        double mileage = addConsumableDto.getMileage();
        Integer lastChangedMonth = addConsumableDto.getLastChanged();
        LocalDate lastChanged = null;
        if (lastChangedMonth != null) lastChanged = LocalDate.now().minusMonths(lastChangedMonth);
        LocalDate today = LocalDate.now();


        switch (consumableType) {
            // 6개월 단위로 입력받을 예정. mileage = 누적 주행거리
            case "engineOil" -> {
                // 3개월~6개월, 5,000km
                if (lastChanged == null) {
                    consumable.setEngineOilMileage(mileage);
                    consumable.setEngineOilLast(null);
                } else {
                    if (today.isAfter(lastChanged.plusMonths(6))) {
                        consumable.setEngineOilMileage(mileage);
                        consumable.setEngineOilLast(lastChanged);
                    }
                    else {
                        // 6개월이 지나지 않았을 경우 남은 기간의 비율대로 mileage 설정
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(6).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 5000 * ratio;
                        consumable.setEngineOilMileage(newMileage);
                        consumable.setEngineOilLast(lastChanged);
                    }
                }
            }
            case "missionOil" -> {
                // 2년, 40,000km
                if (lastChanged == null) {
                    consumable.setMissionOilMileage(mileage);
                    consumable.setMissionOilLast(null);
                } else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setMissionOilMileage(mileage);
                        consumable.setMissionOilLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 40000 * ratio;
                        consumable.setMissionOilMileage(newMileage);
                        consumable.setMissionOilLast(lastChanged);
                    }
                }
            }
            case "brake" -> {
                // 2년, 20,000 ~ 30,000km
                if (lastChanged == null) {
                    consumable.setBrakeMileage(mileage);
                    consumable.setBrakeLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setBrakeMileage(mileage);
                        consumable.setBrakeLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 25000 * ratio;
                        consumable.setBrakeMileage(newMileage);
                        consumable.setBrakeLast(lastChanged);
                    }
                }
            }
            case "clutch" -> {
                // 2년, 40,000km
                if (lastChanged == null) {
                    consumable.setClutchMileage(mileage);
                    consumable.setClutchLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setClutchMileage(mileage);
                        consumable.setClutchLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 40000 * ratio;
                        consumable.setClutchMileage(newMileage);
                        consumable.setClutchLast(lastChanged);
                    }
                }
            }
            case "steering" -> {
                // 2년, 50,000 ~ 60,000km
                if (lastChanged == null) {
                    consumable.setSteeringMileage(mileage);
                    consumable.setSteeringLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setSteeringMileage(mileage);
                        consumable.setSteeringLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 55000 * ratio;
                        consumable.setSteeringMileage(newMileage);
                        consumable.setSteeringLast(lastChanged);
                    }
                }
            }
            case "coolant" -> {
                // 2년, 40,000 ~ 50,000km
                if (lastChanged == null) {
                    consumable.setCoolantMileage(mileage);
                    consumable.setCoolantLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setCoolantMileage(mileage);
                        consumable.setCoolantLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 45000 * ratio;
                        consumable.setCoolantMileage(newMileage);
                        consumable.setCoolantLast(lastChanged);
                    }
                }
            }
            case "fuelFilter" -> {
                // 3년, 40,000km
                if (lastChanged == null) {
                    consumable.setFuelFilterMileage(mileage);
                    consumable.setFuelFilterLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(36))) {
                        consumable.setFuelFilterMileage(mileage);
                        consumable.setFuelFilterLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(36).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 40000 * ratio;
                        consumable.setFuelFilterMileage(newMileage);
                        consumable.setFuelFilterLast(lastChanged);
                    }
                }
            }
            case "heaterFilter" -> {
                // 6개월, 12,000km
                if (lastChanged == null) {
                    consumable.setHeaterFilterMileage(mileage);
                    consumable.setHeaterFilterLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(6))) {
                        consumable.setHeaterFilterMileage(mileage);
                        consumable.setHeaterFilterLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(6).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 12000 * ratio;
                        consumable.setHeaterFilterMileage(newMileage);
                        consumable.setHeaterFilterLast(lastChanged);
                    }
                }
            }
            case "conditionerFilter" -> {
                // 6개월, 15,000 ~ 20,000km
                if (lastChanged == null) {
                    consumable.setConditionerFilterMileage(mileage);
                    consumable.setConditionerFilterLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(6))) {
                        consumable.setConditionerFilterMileage(mileage);
                        consumable.setConditionerFilterLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(6).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 17500 * ratio;
                        consumable.setConditionerFilterMileage(newMileage);
                        consumable.setConditionerFilterLast(lastChanged);
                    }
                }
            }
            case "brakeLining" -> {
                // 2년, 30,000 ~ 40,000km
                if (lastChanged == null) {
                    consumable.setBrakeLiningMileage(mileage);
                    consumable.setBrakeLiningLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setBrakeLiningMileage(mileage);
                        consumable.setBrakeLiningLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 35000 * ratio;
                        consumable.setBrakeLiningMileage(newMileage);
                        consumable.setBrakeLiningLast(lastChanged);
                    }
                }
            }
            case "brakePadFront" -> {
                // 2년, 20,000 ~ 30,000km
                if (lastChanged == null) {
                    consumable.setBrakePadFrontMileage(mileage);
                    consumable.setBrakePadFrontLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setBrakePadFrontMileage(mileage);
                        consumable.setBrakePadFrontLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 25000 * ratio;
                        consumable.setBrakePadFrontMileage(newMileage);
                        consumable.setBrakePadFrontLast(lastChanged);
                    }
                }
            }
            case "brakePadBack" -> {
                // 2년, 40,000 ~ 50,000km
                if (lastChanged == null) {
                    consumable.setBrakePadBackMileage(mileage);
                    consumable.setBrakePadBackLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setBrakePadBackMileage(mileage);
                        consumable.setBrakePadBackLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 45000 * ratio;
                        consumable.setBrakePadBackMileage(newMileage);
                        consumable.setBrakePadBackLast(lastChanged);
                    }
                }
            }
            case "wheelAlignment" -> {
                // 1년, 20,000km
                if (lastChanged == null) {
                    consumable.setWheelAlignmentMileage(mileage);
                    consumable.setWheelAlignmentLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(12))) {
                        consumable.setWheelAlignmentMileage(mileage);
                        consumable.setWheelAlignmentLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(12).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 20000 * ratio;
                        consumable.setWheelAlignmentMileage(newMileage);
                        consumable.setWheelAlignmentLast(lastChanged);
                    }
                }
            }
            case "ignitionPlug" -> {
                // 2년, 40,000 ~ 50,000km
                if (lastChanged == null) {
                    consumable.setIgnitionPlugMileage(mileage);
                    consumable.setIgnitionPlugLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setIgnitionPlugMileage(mileage);
                        consumable.setIgnitionPlugLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 45000 * ratio;
                        consumable.setIgnitionPlugMileage(newMileage);
                        consumable.setIgnitionPlugLast(lastChanged);
                    }
                }
            }
            case "battery" -> {
                // 2년, 40,000 ~ 60,000km
                if (lastChanged == null) {
                    consumable.setBatteryMileage(mileage);
                    consumable.setBatteryLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setBatteryMileage(mileage);
                        consumable.setBatteryLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 50000 * ratio;
                        consumable.setBatteryMileage(newMileage);
                        consumable.setBatteryLast(lastChanged);
                    }
                }
            }
            case "outerBelt" -> {
                // 2년, 30,000 ~ 40,000km
                if (lastChanged == null) {
                    consumable.setOuterBeltMileage(mileage);
                    consumable.setOuterBeltLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setOuterBeltMileage(mileage);
                        consumable.setOuterBeltLast(lastChanged);
                    }
                    else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 35000 * ratio;
                        consumable.setOuterBeltMileage(newMileage);
                        consumable.setOuterBeltLast(lastChanged);
                    }
                }
            }
            case "timingBelt" -> {
                // 2년마다 육안점검, 80,000 ~ 100,000km
                if (lastChanged == null) {
                    consumable.setTimingBeltMileage(mileage);
                    consumable.setTimingBeltLast(null);
                }
                else {
                    if (today.isAfter(lastChanged.plusMonths(24))) {
                        consumable.setTimingBeltMileage(mileage);
                        consumable.setTimingBeltLast(lastChanged);
                    } else {
                        double ratio = (double) (today.toEpochDay() - lastChanged.toEpochDay())
                                / (double) (lastChanged.plusMonths(24).toEpochDay() - lastChanged.toEpochDay());
                        double newMileage = 90000 * ratio;
                        consumable.setTimingBeltMileage(newMileage);
                        consumable.setTimingBeltLast(lastChanged);
                    }
                }
            }
            default -> {
                throw new IllegalArgumentException("Invalid consumable type");
            }
        }
        return consumableRepository.save(consumable);
    }

    public Consumable getConsumable(String carId) {
        return consumableRepository.findByCarId(carId);
    }

    public Consumable resetConsumable(String carId, String consumableType) {
        Consumable consumable = getExistingEntity(carId);
        consumable.setCarId(carId);
        LocalDate lastChanged = LocalDate.now();

        switch (consumableType) {
            case "engineOil" -> {
                consumable.setEngineOilMileage(0);
                consumable.setEngineOilLast(lastChanged);
            }
            case "missionOil" -> {
                consumable.setMissionOilMileage(0);
                consumable.setMissionOilLast(lastChanged);
            }
            case "brake" -> {
                consumable.setBrakeMileage(0);
                consumable.setBrakeLast(lastChanged);
            }
            case "clutch" -> {
                consumable.setClutchMileage(0);
                consumable.setClutchLast(lastChanged);
            }
            case "steering" -> {
                consumable.setSteeringMileage(0);
                consumable.setSteeringLast(lastChanged);
            }
            case "coolant" -> {
                consumable.setCoolantMileage(0);
                consumable.setCoolantLast(lastChanged);
            }
            case "fuelFilter" -> {
                consumable.setFuelFilterMileage(0);
                consumable.setFuelFilterLast(lastChanged);
            }
            case "heaterFilter" -> {
                consumable.setHeaterFilterMileage(0);
                consumable.setHeaterFilterLast(lastChanged);
            }
            case "conditionerFilter" -> {
                consumable.setConditionerFilterMileage(0);
                consumable.setConditionerFilterLast(lastChanged);
            }
            case "brakeLining" -> {
                consumable.setBrakeLiningMileage(0);
                consumable.setBrakeLiningLast(lastChanged);
            }
            case "brakePadFront" -> {
                consumable.setBrakePadFrontMileage(0);
                consumable.setBrakePadFrontLast(lastChanged);
            }
            case "brakePadBack" -> {
                consumable.setBrakePadBackMileage(0);
                consumable.setBrakePadBackLast(lastChanged);
            }
            case "wheelAlignment" -> {
                consumable.setWheelAlignmentMileage(0);
                consumable.setWheelAlignmentLast(lastChanged);
            }
            case "ignitionPlug" -> {
                consumable.setIgnitionPlugMileage(0);
                consumable.setIgnitionPlugLast(lastChanged);
            }
            case "battery" -> {
                consumable.setBatteryMileage(0);
                consumable.setBatteryLast(lastChanged);
            }
            case "outerBelt" -> {
                consumable.setOuterBeltMileage(0);
                consumable.setOuterBeltLast(lastChanged);
            }
            case "timingBelt" -> {
                consumable.setTimingBeltMileage(0);
                consumable.setTimingBeltLast(lastChanged);
            }
        }
        return consumableRepository.save(consumable);
    }

    public Consumable addMileage(String carId, double mileage) {
        Consumable consumable = getExistingEntity(carId);
        consumable.setCarId(carId);
        consumable.setEngineOilMileage(consumable.getMileage() + mileage);
        consumable.setMissionOilMileage(consumable.getMileage() + mileage);
        consumable.setBrakeMileage(consumable.getMileage() + mileage);
        consumable.setClutchMileage(consumable.getMileage() + mileage);
        consumable.setSteeringMileage(consumable.getMileage() + mileage);
        consumable.setCoolantMileage(consumable.getMileage() + mileage);
        consumable.setFuelFilterMileage(consumable.getMileage() + mileage);
        consumable.setHeaterFilterMileage(consumable.getMileage() + mileage);
        consumable.setConditionerFilterMileage(consumable.getMileage() + mileage);
        consumable.setBrakeLiningMileage(consumable.getMileage() + mileage);
        consumable.setBrakePadFrontMileage(consumable.getMileage() + mileage);
        consumable.setBrakePadBackMileage(consumable.getMileage() + mileage);
        consumable.setWheelAlignmentMileage(consumable.getMileage() + mileage);
        consumable.setIgnitionPlugMileage(consumable.getMileage() + mileage);
        consumable.setBatteryMileage(consumable.getMileage() + mileage);
        consumable.setOuterBeltMileage(consumable.getMileage() + mileage);
        consumable.setTimingBeltMileage(consumable.getMileage() + mileage);
        return consumableRepository.save(consumable);
    }
}
