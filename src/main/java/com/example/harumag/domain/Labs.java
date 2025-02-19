package com.example.harumag.domain;

import com.example.harumag.dto.LabsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(indexes = {
        @Index(columnList = "deleted")
        ,@Index(columnList = "process")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
})
@Entity
public class Labs extends AuditingFields {
    @Setter @Column(nullable = false) private String prof;
    @Setter @Column(nullable = false) private String logo;
    @Setter @Column(nullable = false) private String cate;
    @Setter @Column(nullable = false) private String name;
    @Setter @Column(nullable = false) private String intro;

    protected Labs() {}
    private Labs(String prof, String logo, String cate, String name, String intro) {
        this.prof = prof;
        this.logo = logo;
        this.cate = cate;
        this.name = name;
        this.intro = intro;
    }
    public static Labs of(String prof, String logo, String cate, String name, String intro) {
        return new Labs(prof, logo, cate, name, intro);
    }
    public LabsDto.CreateResDto toCreateResDto() {
        return LabsDto.CreateResDto.builder().id(this.getId()).build();
    }
}
