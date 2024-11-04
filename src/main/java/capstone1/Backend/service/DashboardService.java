package capstone1.Backend.service;

import capstone1.Backend.dto.DashboardDto;
import capstone1.Backend.entity.Dashboard;
import capstone1.Backend.repository.DashboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public Dashboard updateDashboard(DashboardDto dashboardDto) {
        Dashboard dashboard = new Dashboard();
        dashboard.setUserId(dashboardDto.getUserId());
        dashboard.setId(dashboardDto.getId());
        dashboard.setSpeed(dashboardDto.getSpeed());
        dashboard.setRpm(dashboardDto.getRpm());
        dashboard.setCoolantTemperature(dashboardDto.getCoolantTemperature());
        dashboard.setIntakeTemperature(dashboardDto.getIntakeTemperature());
        dashboard.setEngineLoad(dashboardDto.getEngineLoad());
        dashboard.setIntakePressure(dashboardDto.getIntakePressure());
        dashboard.setMileage(dashboardDto.getMileage());
        dashboard.setDrivingTime(dashboardDto.getDrivingTime());
        dashboard.setAverageSpeed(dashboardDto.getAverageSpeed());
        dashboard.setIdleTime(dashboardDto.getIdleTime());
        dashboard.setInstantaneousFuelEfficiency(dashboardDto.getInstantaneousFuelEfficiency());
        dashboard.setInstantaneousConsumption(dashboardDto.getInstantaneousConsumption());
        return dashboardRepository.save(dashboard);
    }

    public Dashboard getDashboard(String userId) {
        return dashboardRepository.findById(userId).orElse(null);
    }
}
