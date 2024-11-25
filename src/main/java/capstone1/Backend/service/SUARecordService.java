package capstone1.Backend.service;

import capstone1.Backend.dto.SUARecordBySecDto;
import capstone1.Backend.dto.SUARecordDto;
import capstone1.Backend.entity.SUARecord;
import capstone1.Backend.entity.SUARecordBySec;
import capstone1.Backend.repository.SUARecordBySecRepository;
import capstone1.Backend.repository.SUARecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SUARecordService {
    private final SUARecordRepository suaRecordRepository;
    private final SUARecordBySecRepository suaRecordBySecRepository;
    public SUARecord addSUARecord(SUARecordDto suaRecordDto) {
        SUARecord suaRecord = new SUARecord();
        suaRecord.setSUAId("SUA" + System.currentTimeMillis());
        suaRecord.setUserId(suaRecordDto.getUserId());
        suaRecord.setSUAOnTime(suaRecordDto.getSUAOnTime());
        suaRecord.setSUAOffTime(suaRecordDto.getSUAOffTime());
        return suaRecordRepository.save(suaRecord);
    }

    public List<SUARecord> getSUARecordsByUserId(String userId) {
        return suaRecordRepository.findByUserId(userId);
    }

    public SUARecordBySec addTimestamp(SUARecordBySecDto suaRecordBySecDto) {
        SUARecordBySec suaRecordBySec = new SUARecordBySec();
        suaRecordBySec.setTimestamp(suaRecordBySecDto.getTimestamp());
        suaRecordBySec.setSUAId(suaRecordBySecDto.getSUAId());
        suaRecordBySec.setAccPressure(suaRecordBySecDto.getAccPressure());
        suaRecordBySec.setBrakePressure(suaRecordBySecDto.getBrakePressure());
        suaRecordBySec.setSpeed(suaRecordBySecDto.getSpeed());
        suaRecordBySec.setRpm(suaRecordBySecDto.getRpm());
        suaRecordBySec.setCoolantTemperature(suaRecordBySecDto.getCoolantTemperature());
        suaRecordBySec.setIntakeTemperature(suaRecordBySecDto.getIntakeTemperature());
        suaRecordBySec.setIntakePressure(suaRecordBySecDto.getIntakePressure());
        suaRecordBySec.setEngineLoad(suaRecordBySecDto.getEngineLoad());
        suaRecordBySec.setMileage(suaRecordBySecDto.getMileage());
        suaRecordBySec.setDrivingTime(suaRecordBySecDto.getDrivingTime());
        suaRecordBySec.setAverageSpeed(suaRecordBySecDto.getAverageSpeed());
        suaRecordBySec.setIdleTime(suaRecordBySecDto.getIdleTime());
        suaRecordBySec.setInstantaneousFuelEfficiency(suaRecordBySecDto.getInstantaneousFuelEfficiency());
        suaRecordBySec.setInstantaneousConsumption(suaRecordBySecDto.getInstantaneousConsumption());
        return suaRecordBySecRepository.save(suaRecordBySec);
    }

    public List<SUARecordBySec> getSUARecordsBySecBySUAId(String SUAId) {
        return suaRecordBySecRepository.findBySUAId(SUAId);
    }
}
