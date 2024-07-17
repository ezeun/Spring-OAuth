package com.ssafy.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="certification")
@Table(name="certification")
public class CertificationEntity {

    @Id
    private String userId;
    private String email;
    private String certificationNumber; // Number이지만 맨앞에 0이 올 수 있으므로 String으로 관리함
}
