package capstone1.Backend.service;

import capstone1.Backend.entity.Guide;
import capstone1.Backend.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    public List<Guide> getGuideByErrCode(String errCode, String carType) {
        return guideRepository.findByErrCode(errCode, carType);
    }

    public List<Guide> getAllGuideWithCarType(String carType) {
        // TODO: carType, All에 맞는 쿼리문 작성 및 출력
        return guideRepository.findAllByCarType(carType);
    }

    public Guide getGuideDetail(int errId) {
        return guideRepository.findByErrId(errId);
    }
}
