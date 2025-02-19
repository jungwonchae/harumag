package com.example.harumag.dto;

import com.example.harumag.domain.CapsI;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CapsIDto {

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateReqDto{
        @Schema(description = "professor name", example = "김세진")
        @NotNull
        private String prof;

        @Schema(description = "logo", example = "")
        private String logo;

        @Schema(description = "member", example = "팀원명")
        @NotNull
        private String member;

        @Schema(description = "semester", example = "2024 가을")
        @NotNull
        private String semester;

        @Schema(description = "name", example = "서비스명")
        @NotNull
        private String name;

        public CapsI toEntity(){
            return CapsI.of(prof, logo, member, semester, name);
        }
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateResDto{
        private String id;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateReqDto{
        @Schema(description = "id", example = "")
        private String id;
        @Schema(description = "professor name", example = "")
        private String prof;
        @Schema(description = "logo", example = "")
        private String logo;
        @Schema(description = "member", example = "")
        private String member;
        @Schema(description = "semester", example = "")
        private String semester;
        @Schema(description = "name", example = "")
        private String name;

        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description = "process", example="")
        private String process;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailReqDto{
        @Schema(description = "id", example="")
        @NotNull
        @NotEmpty
        private String id;
    }

    @Schema
    @Getter
    @Setter
    public static class DetailResDto{
        @Schema(description = "id", example="")
        private String id;
        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description = "process", example="")
        private String process;
        @Schema(description = "createdAt", example="")
        private String createdAt;
        @Schema(description = "modifiedAt", example="")
        private String modifiedAt;

        @Schema(description = "professor name", example = "")
        private String prof;
        @Schema(description = "logo", example = "")
        private String logo;
        @Schema(description = "member", example = "")
        private String member;
        @Schema(description = "semester", example = "")
        private String semester;
        @Schema(description = "name", example = "")
        private String name;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListReqDto{
        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description = "process", example="")
        private String process;
        @Schema(description = "sdate", example="")
        private String sdate;
        @Schema(description = "fdate", example="")
        private String fdate;

        @Schema(description = "professor name", example = "")
        private String prof;
        @Schema(description = "logo", example = "")
        private String logo;
        @Schema(description = "member", example = "")
        private String member;
        @Schema(description = "semester", example = "")
        private String semester;
        @Schema(description = "name", example = "")
        private String name;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListReqDto{
        @Schema(description = "callpage", example="")
        private Integer callpage;
        @Schema(description = "perpage", example="")
        private Integer perpage;
        @Schema(description = "orderby", example="")
        private String orderby;
        @Schema(description = "orderway", example="")
        private String orderway;

        @Schema(description = "listsize", example="")
        private Integer listsize;
        @Schema(description = "pagesize", example="")
        private Integer pagesize;

        @Schema(description = "list", example="")
        private Object list;

        @Schema(description = "professor name", example = "")
        private String prof;
        @Schema(description = "logo", example = "")
        private String logo;
        @Schema(description = "member", example = "")
        private String member;
        @Schema(description = "semester", example = "")
        private String semester;
        @Schema(description = "name", example = "")
        private String name;

        @Schema(description = "offset", example="")
        private Integer offset;

        public int[] init(int listsize){
            if(orderby == null || orderby.isEmpty()){
                orderby = "created_at";
            }
            if(orderway == null || orderway.isEmpty()){
                orderway = "desc";
            }
            if(perpage == null || perpage < 1){
                //한번에 조회할 글 갯수
                perpage = 10;
            }
            if(callpage == null){
                //호출하는 페이지
                callpage = 1;
            }
            if(callpage < 1){
                callpage = 1;
            }

            int pagesize = listsize / perpage;
            if(listsize % perpage > 0){
                pagesize++;
            }
            if(callpage > pagesize){
                callpage = pagesize;
            }
            offset = (callpage - 1) * perpage;
            int[] res = {listsize, pagesize};

            return res;
        }

        public DefaultDto.PagedListResDto afterBuild(int[] resSize, Object list){
            return DefaultDto.PagedListResDto.builder()
                    .callpage(callpage)
                    .perpage(perpage)
                    .orderby(orderby)
                    .orderway(orderway)
                    .listsize(resSize[0])
                    .pagesize(resSize[1])
                    .list(list)
                    .build();
        }
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ScrollListReqDto{
        @Schema(description = "cursor", example="")
        private String cursor;
        @Schema(description = "perpage", example="")
        private Integer perpage;
        @Schema(description = "orderby", example="")
        private String orderby;
        @Schema(description = "orderway", example="")
        private String orderway;

        @Schema(description = "deleted", example="")
        private String deleted;
        @Schema(description = "process", example="")
        private String process;
        @Schema(description = "sdate", example="")
        private String sdate;
        @Schema(description = "fdate", example="")
        private String fdate;

        public void init(){
            if(orderby == null || orderby.isEmpty()){
                orderby = "created_at";
            }
            if(orderway == null || orderway.isEmpty()) {
                orderway = "desc";
            }
            if(perpage == null || perpage < 1){
                //한번에 조회할 글 갯수
                perpage = 10;
            }
        }

        @Schema(description = "professor name", example = "")
        private String prof;
        @Schema(description = "logo", example = "")
        private String logo;
        @Schema(description = "member", example = "")
        private String member;
        @Schema(description = "semester", example = "")
        private String semester;
        @Schema(description = "name", example = "")
        private String name;
    }


}
