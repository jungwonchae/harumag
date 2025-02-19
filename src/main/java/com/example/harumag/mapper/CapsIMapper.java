package com.example.harumag.mapper;

import com.example.harumag.dto.CapsIDto;

import java.util.List;

public interface CapsIMapper {
    CapsIDto.DetailResDto detail(CapsIDto.DetailReqDto param);
    List<CapsIDto.DetailResDto> list(CapsIDto.ListReqDto param);

    List<CapsIDto.DetailResDto> scrollList(CapsIDto.ScrollListReqDto param);
    List<CapsIDto.DetailResDto> pagedList(CapsIDto.PagedListReqDto param);
    int pagedListCount (CapsIDto.PagedListReqDto param);
}
