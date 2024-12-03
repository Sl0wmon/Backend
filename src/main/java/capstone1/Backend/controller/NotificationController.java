package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.NotificationDto;
import capstone1.Backend.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController {
    private final NotificationService notificationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/notification/add")
    public Response<?> addNotification(@RequestBody NotificationDto notificationDto) {
        notificationService.addNotification(notificationDto);
        return new Response<>("true", "알림 등록 완료", null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/notification/delete")
    public Response<?> deleteNotification(@RequestBody NotificationDto notificationDto) {
        // 유저의 아이디에 해당하는 알림 전체 삭제
        if (notificationService.deleteNotification(notificationDto.getUserId())) {
            return new Response<>("true", "알림 삭제 완료", null);
        }
        return new Response<>("false", "알림 삭제 실패", null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/notification/update")
    public Response<?> updateNotification(@RequestBody NotificationDto notificationDto) {
        notificationService.updateNotification(notificationDto);
        return new Response<>("true", "알림 업데이트 완료", null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/notification/view")
    public Response<?> getNotificationByUserId(@RequestBody NotificationDto notificationDto) {
        return new Response<>("true", "사용자 알림 정보 조회 완료",
                notificationService.getNotificationByUserId(notificationDto.getUserId()));
    }

    @Scheduled(cron="0 0 0 * * *")
    public void pushNotification() {
        notificationService.addConsumableNotification();
    }
}
