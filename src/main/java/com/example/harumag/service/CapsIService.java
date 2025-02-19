package com.example.harumag.service;

import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.CapsIDto;

import java.util.List;

public interface CapsIService {
    CapsIDto.CreateResDto create(CapsIDto.CreateReqDto param);
    CapsIDto.CreateResDto update(CapsIDto.UpdateReqDto param);
    CapsIDto.CreateResDto delete(DefaultDto.DeleteReqDto param);
    CapsIDto.CreateResDto deletes(DefaultDto.DeletesReqDto param);
    CapsIDto.DetailResDto detail(CapsIDto.DetailReqDto param);
    List<CapsIDto.DetailResDto> list(CapsIDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(CapsIDto.PagedListReqDto param);
    List<CapsIDto.DetailResDto> scrollList(CapsIDto.ScrollListReqDto param);

}
