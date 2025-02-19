package com.example.harumag.mapper;

import com.example.harumag.dto.LabsDto;

import java.util.List;

public interface LabsMapper {
    LabsDto.DetailResDto detail(LabsDto.DetailReqDto param);
    List<LabsDto.DetailResDto> list(LabsDto.ListReqDto param);

    List<LabsDto.DetailResDto> scrollList(LabsDto.ScrollListReqDto param);
    List<LabsDto.DetailResDto> pagedList(LabsDto.PagedListReqDto param);
    int pagedListCount (LabsDto.PagedListReqDto param);
}
