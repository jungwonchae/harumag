package com.example.harumag.service.impl;

import com.example.harumag.domain.CapsI;
import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.CapsIDto;
import com.example.harumag.mapper.CapsIMapper;
import com.example.harumag.repository.CapsIRepository;
import com.example.harumag.service.CapsIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapsIServiceImpl implements CapsIService {

    // 로그를 찍기 위함
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CapsIRepository capsIRepository;
    private final CapsIMapper capsIMapper;

    public CapsIServiceImpl(
            CapsIRepository capsIRepository
            , CapsIMapper capsIMapper
    ) {
        this.capsIRepository = capsIRepository;
        this.capsIMapper = capsIMapper;
    }

    @Override
    public CapsIDto.CreateResDto create(CapsIDto.CreateReqDto param) {
        CapsIDto.CreateResDto createResDto = capsIRepository.save(param.toEntity()).toCreateResDto();
        return createResDto;
    }

    @Override
    public CapsIDto.CreateResDto update(CapsIDto.UpdateReqDto param) {
        CapsI capsI = capsIRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getDeleted()!=null){
            capsI.setDeleted(param.getDeleted());
        }
        if(param.getProcess()!=null){
            capsI.setProcess(param.getProcess());
        }
        if(param.getProf()!=null){
            capsI.setProf(param.getProf());
        }
        if(param.getLogo()!=null){
            capsI.setLogo(param.getLogo());
        }
        if(param.getMember()!=null){
            capsI.setMember(param.getMember());
        }
        if(param.getSemester()!=null){
            capsI.setSemester(param.getSemester());
        }
        if(param.getName()!=null){
            capsI.setName(param.getName());
        }
        capsIRepository.save(capsI);
        return capsI.toCreateResDto();
    }

    @Override
    public CapsIDto.CreateResDto delete(DefaultDto.DeleteReqDto param) {
        CapsIDto.UpdateReqDto newParam = CapsIDto.UpdateReqDto.builder().id(param.getId()).deleted("Y").build();
        return update(newParam);
    }

    @Override
    public CapsIDto.CreateResDto deletes(DefaultDto.DeletesReqDto param) {
        int cnt = 0;
        for(String id : param.getIds()) {
            CapsIDto.UpdateReqDto newParam = CapsIDto.UpdateReqDto.builder().id(id).deleted("Y").build();
            CapsIDto.CreateResDto result = update(newParam);
            if(!(result.getId()).isEmpty()){
                cnt++;
            }
        }

        return CapsIDto.CreateResDto.builder().id(cnt + "").build();
    }

    @Override
    public CapsIDto.DetailResDto detail(CapsIDto.DetailReqDto param) {
        CapsIDto.DetailResDto selectResDto = capsIMapper.detail(param);
        logger.debug("조회할 ID: {}", selectResDto);
        if(selectResDto==null){ // 조회할 데이터가 없는 경우 예외처리
            throw new RuntimeException("no data");
        }
        return selectResDto;
    }

    @Override
    public List<CapsIDto.DetailResDto> list(CapsIDto.ListReqDto param) {
        return detailList(capsIMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(CapsIDto.PagedListReqDto param) {
        int[] returnSize = param.init(capsIMapper.pagedListCount(param));
        return param.afterBuild(returnSize, detailList(capsIMapper.pagedList(param)));
    }

    @Override
    public List<CapsIDto.DetailResDto> scrollList(CapsIDto.ScrollListReqDto param) {
        param.init();
        return detailList(capsIMapper.scrollList(param));
    }

    /**/

    public List<CapsIDto.DetailResDto> detailList(List<CapsIDto.DetailResDto> list){
        List<CapsIDto.DetailResDto> newList = new ArrayList<>();
        for(CapsIDto.DetailResDto each : list){
            newList.add(detail(CapsIDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
