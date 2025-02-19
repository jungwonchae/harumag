package com.example.harumag.domain;

import com.example.harumag.dto.CapsIDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
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
public class CapsI extends AuditingFields {
    @Setter @Column(nullable = false) private String prof;
    @Setter @Column(nullable = false) private String logo;
    @Setter @Column(nullable = false) private String member;
    @Setter @Column(nullable = false) private String semester;
    @Setter @Column(nullable = false) private String name;

    protected CapsI() {}
    private CapsI(String prof, String logo, String member, String semester, String name) {
        this.prof = prof;
        this.logo = logo;
        this.member = member;
        this.semester = semester;
        this.name = name;
    }
    public static CapsI of(String prof, String logo, String member, String semester, String name) {
        return new CapsI(prof, logo, member, semester, name);
    }
    public CapsIDto.CreateResDto toCreateResDto() {
        return CapsIDto.CreateResDto.builder().id(this.getId()).build();
    }
}
