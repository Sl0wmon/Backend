package capstone1.Backend.controller;


import capstone1.Backend.config.Response;
import capstone1.Backend.dto.GuideDto;
import capstone1.Backend.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GuideController {
    private final GuideService guideService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/guide/search/code")
    public Response<?> getGuideByErrCode(@RequestBody GuideDto guideDto) {
        return new Response<>("true", "에러 코드로 가이드 검색 완료",
                guideService.getGuideByErrCode(guideDto.getErrCode(), guideDto.getCarType()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/guide/all")
    public Response<?> getAllGuideWithCarType(@RequestBody GuideDto guideDto) {
        return new Response<>("true", "차량 타입을 고려한 범용적 가이드 가져오기 완료",
                guideService.getAllGuideWithCarType(guideDto.getCarType()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/guide/detail")
    public Response<?> getGuideDetail(@RequestBody GuideDto guideDto) {
        return new Response<>("true", "가이드 상세 정보 가져오기 완료",
                guideService.getGuideDetail(guideDto.getErrId()));
    }
}