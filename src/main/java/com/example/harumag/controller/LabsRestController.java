package com.example.harumag.controller;

import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.LabsDto;
import com.example.harumag.service.LabsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "랩실 API 안내",
        description = "랩실 관련 기능 정의한 RestController.")
@RequestMapping("/api/labs")
@RestController
public class LabsRestController {

    // 로그를 찍기 위함
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LabsService labsService;

    public LabsRestController(LabsService labsService) {
        this.labsService = labsService;
    }

    @Operation(summary = "랩실 생성",
            description = "랩실 생성 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @PostMapping("")
    public ResponseEntity<LabsDto.CreateResDto> create(@Valid @RequestBody LabsDto.CreateReqDto param, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(labsService.create(param));
    }

    @Operation(summary = "랩실 수정",
            description = "랩실 수정 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @PutMapping("")
    public ResponseEntity<LabsDto.CreateResDto> update(@Valid @RequestBody LabsDto.UpdateReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.update(param));
    }

    @Operation(summary = "랩실 삭제",
            description = "랩실 삭제 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @DeleteMapping("")
    public ResponseEntity<LabsDto.CreateResDto> delete(@Valid @RequestBody DefaultDto.DeleteReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.delete(param));
    }

    @Operation(summary = "랩실 여러개 삭제",
            description = "랩실 여러개 삭제 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @DeleteMapping("/list")
    public ResponseEntity<LabsDto.CreateResDto> deletes(@Valid @RequestBody DefaultDto.DeletesReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.deletes(param));
    }

    @Operation(summary = "랩실 상세 조회",
            description = "랩실 상세 조회 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("")
    public ResponseEntity<LabsDto.DetailResDto> detail(@Valid LabsDto.DetailReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.detail(param));
    }

    @Operation(summary = "랩실 목록 전체 조회",
            description = "랩실 목록 전체 조회 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/list")
    public ResponseEntity<List<LabsDto.DetailResDto>> list(@Valid LabsDto.ListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.list(param));
    }

    @Operation(summary = "랩실 목록 페이지 조회",
            description = "랩실 목록 페이지 조회 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/plist")
    public ResponseEntity<DefaultDto.PagedListResDto> plist(@Valid LabsDto.PagedListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.pagedList(param));
    }

    @Operation(summary = "랩실 목록 스크롤 조회",
            description = "랩실 목록 스크롤 조회 컨트롤러 <br />"
                    + "@param LabsDto.CreateReqDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<LabsDto.CreateResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/mlist")
    public ResponseEntity<List<LabsDto.DetailResDto>> mlist(@Valid LabsDto.ScrollListReqDto param) {
        return ResponseEntity.status(HttpStatus.OK).body(labsService.scrollList(param));
    }
}
