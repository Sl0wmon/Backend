package capstone1.Backend.repository;

import capstone1.Backend.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Dashboard, String> {
}
