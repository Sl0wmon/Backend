package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.SUARecordBySecDto;
import capstone1.Backend.dto.SUARecordDto;
import capstone1.Backend.service.SUARecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SUARecordController {
    private final SUARecordService suaRecordService;

    // 연결 테스트용
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/test")
    public String test() {
        return "Hello, World!";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/SUARecord/add")
    public Response<?> addSUARecord(@RequestBody SUARecordDto suaRecordDto) {
        return new Response<>("true", "급발진 기록 추가 완료",
                suaRecordService.addSUARecord(suaRecordDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/SUARecord/quit")
    public Response<?> quitSUARecord(@RequestBody SUARecordDto suaRecordDto) {
        return new Response<>("true", "급발진 기록 종료 완료",
                suaRecordService.quitSUARecord(suaRecordDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/SUARecord/list")
    public Response<?> getSUARecordsByUserId(@RequestBody SUARecordDto suaRecordDto) {
        return new Response<>("true", "유저의 급발진 기록 조회 완료",
                suaRecordService.getSUARecordsByUserId(suaRecordDto.getUserId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/SUARecord/timestamp/add")
    public Response<?> addTimestamp(@RequestBody SUARecordBySecDto suaRecordBySecDto) {
        return new Response<>("true", "해당 SUAId에 급발진 기록 추가 완료",
                suaRecordService.addTimestamp(suaRecordBySecDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/SUARecord/timestamp/list")
    public Response<?> getSUARecordsBySUAId(@RequestBody SUARecordBySecDto suaRecordBySecDto) {
        return new Response<>("true", "해당 SUAId의 급발진 기록 조회 완료",
                suaRecordService.getSUARecordsBySecBySUAId(suaRecordBySecDto.getSUAId()));
    }
}
