package com.example.harumag.controller;

import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.CapsIDto;
import com.example.harumag.service.CapsIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "캡스톤 I API 안내",
        description = "캡스톤 I 관련 기능 정의한 RestController.")
@RequestMapping("/api/capsI")
@RestController
public class CapsIRestController {

    // 로그를 찍기 위함
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CapsIService capsIService;

    public CapsIRestController(CapsIService capsIService) {
        this.capsIService = capsIService;
    }

    @Operation(summary = "캡스톤 I 생성",
            description = "캡스톤 I 생성 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @PostMapping("")
    public ResponseEntity<CapsIDto.CreateResDto> create(@Valid @RequestBody CapsIDto.CreateReqDto param, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(capsIService.create(param));
    }

    @Operation(summary = "캡스톤 I 수정",
            description = "캡스톤 I 수정 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @PutMapping("")
    public ResponseEntity<CapsIDto.CreateResDto> update(@Valid @RequestBody CapsIDto.UpdateReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.update(param));
    }

    @Operation(summary = "캡스톤 I 삭제",
            description = "캡스톤 I 삭제 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @DeleteMapping("")
    public ResponseEntity<CapsIDto.CreateResDto> delete(@Valid @RequestBody DefaultDto.DeleteReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.delete(param));
    }

    @Operation(summary = "캡스톤 I 여러개 삭제",
            description = "캡스톤 I 여러개 삭제 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @DeleteMapping("/list")
    public ResponseEntity<CapsIDto.CreateResDto> deletes(@Valid @RequestBody DefaultDto.DeletesReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.deletes(param));
    }

    @Operation(summary = "캡스톤 I 상세 조회",
            description = "캡스톤 I 상세 조회 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("")
    public ResponseEntity<CapsIDto.DetailResDto> detail(@Valid CapsIDto.DetailReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.detail(param));
    }

    @Operation(summary = "캡스톤 I 목록 전체 조회",
            description = "캡스톤 I 목록 전체 조회 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/list")
    public ResponseEntity<List<CapsIDto.DetailResDto>> list(@Valid CapsIDto.ListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.list(param));
    }

    @Operation(summary = "캡스톤 I 목록 페이지 조회",
            description = "캡스톤 I 목록 페이지 조회 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/plist")
    public ResponseEntity<DefaultDto.PagedListResDto> plist(@Valid CapsIDto.PagedListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.pagedList(param));
    }

    @Operation(summary = "캡스톤 I 목록 스크롤 조회",
            description = "캡스톤 I 목록 스크롤 조회 컨트롤러 <br />"
                    + "@param CapsIDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<CapsIDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/mlist")
    public ResponseEntity<List<CapsIDto.DetailResDto>> mlist(@Valid CapsIDto.ScrollListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(capsIService.scrollList(param));
    }
}
