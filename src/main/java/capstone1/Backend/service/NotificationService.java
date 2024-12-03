package capstone1.Backend.service;

import capstone1.Backend.dto.NotificationDto;
import capstone1.Backend.entity.Car;
import capstone1.Backend.entity.Consumable;
import capstone1.Backend.entity.Notification;
import capstone1.Backend.repository.CarRepository;
import capstone1.Backend.repository.ConsumableRepository;
import capstone1.Backend.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final ConsumableRepository consumableRepository;
    private final CarRepository carRepository;

    public void addNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
        notification.setUserId(notificationDto.getUserId());
        notification.setNotificationTime(notificationDto.getNotificationTime());
        notification.setCode(notificationDto.getCode());
        notification.setTitle(notificationDto.getTitle());
        notification.setContent(notificationDto.getContent());
        notificationRepository.save(notification);
    }

    public boolean deleteNotification(String userId) {
        List<Notification> notifications = notificationRepository.findAllByUserId(userId);
        if (!notifications.isEmpty()) {
            for (Notification notification : notifications) {
                notificationRepository.delete(notification);
            }
            return true;
        }
        return false;
    }

    public void updateNotification(NotificationDto notificationDto) {
        Notification notification = notificationRepository.findById(notificationDto.getNotificationId()).orElse(null);
        Objects.requireNonNull(notification).setUserId(notificationDto.getUserId());
        notification.setNotificationTime(notificationDto.getNotificationTime());
        notification.setCode(notificationDto.getCode());
        notification.setTitle(notificationDto.getTitle());
        notification.setContent(notificationDto.getContent());
        notificationRepository.save(notification);
    }

    public List<Notification> getNotificationByUserId(String userId) {
        return notificationRepository.findAllByUserId(userId);
    }

    public void addConsumableNotification() {
        String title = "소모품 교체 알림";
        String content = "을(를) 교체해주세요.";
        String code = "";
        List<Consumable> consumables = consumableRepository.findAll();
        Notification notification = new Notification();

        for (Consumable consumable : consumables) {
            String user = carRepository.findByCarId(consumable.getCarId()).get(0).getUserId();
            if (consumable.getEngineOilMileage() >= 5000) {
                String notificationContent = "엔진오일" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getMissionOilMileage() >= 40000) {
                String notificationContent = "미션오일" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getBrakeMileage() >= 25000) {
                String notificationContent = "브레이크" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getClutchMileage() >= 40000) {
                String notificationContent = "클러치" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getSteeringMileage() >= 55000) {
                String notificationContent = "스티어링" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getCoolantMileage() >= 45000) {
                String notificationContent = "냉각수" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getFuelFilterMileage() >= 40000) {
                String notificationContent = "연료 필터" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getHeaterFilterMileage() >= 12000) {
                String notificationContent = "히터 필터" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getConditionerFilterMileage() >= 17500) {
                String notificationContent = "에어컨 필터" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getBrakeLiningMileage() >= 35000) {
                String notificationContent = "브레이크 라이닝" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getBrakePadFrontMileage() >= 25000) {
                String notificationContent = "브레이크 패드(앞)" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getBrakePadBackMileage() >= 45000) {
                String notificationContent = "브레이크 패드(뒤)" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getWheelAlignmentMileage() >= 20000) {
                String notificationContent = "휠 얼라인먼트" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getIgnitionPlugMileage() >= 45000) {
                String notificationContent = "점화 플러그" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }

            if (consumable.getBatteryMileage() >= 50000) {
                String notificationContent = "배터리" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }
            if (consumable.getOuterBeltMileage() >= 35000) {
                String notificationContent = "외부 벨트" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }
            if (consumable.getTimingBeltMileage() >= 90000) {
                String notificationContent = "타이밍 벨트" + content;
                notification.setNotificationId("NOTIFICATION" + System.currentTimeMillis());
                notification.setUserId(user);
                notification.setNotificationTime(LocalDateTime.now());
                notification.setCode(code);
                notification.setTitle(title);
                notification.setContent(notificationContent);
                notificationRepository.save(notification);
            }
        }
    }

}
