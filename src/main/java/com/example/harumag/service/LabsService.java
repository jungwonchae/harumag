package com.example.harumag.service;

import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.LabsDto;

import java.util.List;

public interface LabsService {
    LabsDto.CreateResDto create(LabsDto.CreateReqDto param);
    LabsDto.CreateResDto update(LabsDto.UpdateReqDto param);
    LabsDto.CreateResDto delete(DefaultDto.DeleteReqDto param);
    LabsDto.CreateResDto deletes(DefaultDto.DeletesReqDto param);
    LabsDto.DetailResDto detail(LabsDto.DetailReqDto param);
    List<LabsDto.DetailResDto> list(LabsDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(LabsDto.PagedListReqDto param);
    List<LabsDto.DetailResDto> scrollList(LabsDto.ScrollListReqDto param);

}
