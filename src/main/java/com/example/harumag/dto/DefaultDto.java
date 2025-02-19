package com.example.harumag.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class DefaultDto {

    @Builder
    @Schema
    @Getter
    @Setter
    public static class FileResDto{
        private String url;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BaseDto {
        String empty; // 이게 없으면 빌더가 잘 안되어요 ㅠㅠ
        public BaseDto afterBuild(BaseDto param) {
            //param => reqDto 를 넣어주면!!
            BeanUtils.copyProperties(param, this);
            //this 인 서비스 디티오를 돌려줍니다! 안에 있는 모든 필드값 카피도 해줍니다!
            return this;
        }
    }

    /**/

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeleteReqDto extends BaseDto {
        @Schema(description = "id", example="")
        @NotNull
        @NotEmpty
        private String id;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeletesReqDto extends BaseDto {
        @Schema(description = "ids", example="")
        private List<String> ids;
    }

    @SuperBuilder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PagedListResDto{

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
    }


}
