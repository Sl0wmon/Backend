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
        return guideRepository.findAllByCarType(carType);
    }

    public Guide getGuideDetail(int errId) {
        return guideRepository.findByErrId(errId);
    }
}
