package capstone1.Backend.service;

import capstone1.Backend.dto.NotificationDto;
import capstone1.Backend.entity.Notification;
import capstone1.Backend.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void addNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setUserId("NOTIFICATION" + System.currentTimeMillis());
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
}
