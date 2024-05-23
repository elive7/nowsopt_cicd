package org.sopt.kakaopay.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.kakaopay.common.dto.SuccessMessage;
import org.sopt.kakaopay.common.dto.SuccessStatusResponse;
import org.sopt.kakaopay.service.HistoryService;
import org.sopt.kakaopay.service.dto.HistoryFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/history")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<SuccessStatusResponse<List<HistoryFindDto>>> getHistories(
            @RequestHeader("memberId") Long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SuccessMessage.HISTORY_FIND_SUCCESS,
                        historyService.getHistories(memberId)));
    }
}
