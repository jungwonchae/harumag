package com.example.harumag.service.impl;

import com.example.harumag.domain.Labs;
import com.example.harumag.dto.DefaultDto;
import com.example.harumag.dto.LabsDto;
import com.example.harumag.mapper.LabsMapper;
import com.example.harumag.repository.LabsRepository;
import com.example.harumag.service.LabsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabsServiceImpl implements LabsService {

    // 로그를 찍기 위함
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LabsRepository labsRepository;
    private final LabsMapper labsMapper;

    public LabsServiceImpl(
            LabsRepository labsRepository
            , LabsMapper labsMapper
    ) {
        this.labsRepository = labsRepository;
        this.labsMapper = labsMapper;
    }

    @Override
    public LabsDto.CreateResDto create(LabsDto.CreateReqDto param) {
        LabsDto.CreateResDto createResDto = labsRepository.save(param.toEntity()).toCreateResDto();
        return createResDto;
    }

    @Override
    public LabsDto.CreateResDto update(LabsDto.UpdateReqDto param) {
        Labs labs = labsRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getDeleted()!=null){
            labs.setDeleted(param.getDeleted());
        }
        if(param.getProcess()!=null){
            labs.setProcess(param.getProcess());
        }
        if(param.getProf()!=null){
            labs.setProf(param.getProf());
        }
        if(param.getLogo()!=null){
            labs.setLogo(param.getLogo());
        }
        if(param.getCate()!=null){
            labs.setCate(param.getCate());
        }
        if(param.getName()!=null){
            labs.setName(param.getName());
        }
        if(param.getIntro()!=null){
            labs.setIntro(param.getIntro());
        }
        labsRepository.save(labs);
        return labs.toCreateResDto();
    }

    @Override
    public LabsDto.CreateResDto delete(DefaultDto.DeleteReqDto param) {
        LabsDto.UpdateReqDto newParam = LabsDto.UpdateReqDto.builder().id(param.getId()).deleted("Y").build();
        return update(newParam);
    }

    @Override
    public LabsDto.CreateResDto deletes(DefaultDto.DeletesReqDto param) {
        int cnt = 0;
        for(String id : param.getIds()) {
            LabsDto.UpdateReqDto newParam = LabsDto.UpdateReqDto.builder().id(id).deleted("Y").build();
            LabsDto.CreateResDto result = update(newParam);
            if(!(result.getId()).isEmpty()){
                cnt++;
            }
        }

        return LabsDto.CreateResDto.builder().id(cnt + "").build();
    }

    @Override
    public LabsDto.DetailResDto detail(LabsDto.DetailReqDto param) {
        LabsDto.DetailResDto selectResDto = labsMapper.detail(param);
        logger.debug("조회할 ID: {}", selectResDto);
        if(selectResDto==null){ // 조회할 데이터가 없는 경우 예외처리
            throw new RuntimeException("no data");
        }
        return selectResDto;
    }

    @Override
    public List<LabsDto.DetailResDto> list(LabsDto.ListReqDto param) {
        return detailList(labsMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(LabsDto.PagedListReqDto param) {
        int[] returnSize = param.init(labsMapper.pagedListCount(param));
        return param.afterBuild(returnSize, detailList(labsMapper.pagedList(param)));
    }

    @Override
    public List<LabsDto.DetailResDto> scrollList(LabsDto.ScrollListReqDto param) {
        param.init();
        return detailList(labsMapper.scrollList(param));
    }

    /**/

    public List<LabsDto.DetailResDto> detailList(List<LabsDto.DetailResDto> list){
        List<LabsDto.DetailResDto> newList = new ArrayList<>();
        for(LabsDto.DetailResDto each : list){
            newList.add(detail(LabsDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
