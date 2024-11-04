package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.DashboardDto;
import capstone1.Backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DashboardController {
    private final DashboardService dashboardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/dashboard/update")
    public Response<?> updateDashboard(@RequestBody DashboardDto dashboardDto) {
        return new Response<>("true", "대시보드 정보 업데이트 완료", dashboardService.updateDashboard(dashboardDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/dashboard/view")
    public Response<?> getDashboard(@RequestBody DashboardDto dashboardDto) {
        return new Response<>("true", "대시보드 정보 조회 완료", dashboardService.getDashboard(dashboardDto.getUserId()));
    }
}
