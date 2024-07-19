package com.ssafy.back.service;

import org.springframework.http.ResponseEntity;

import com.ssafy.back.dto.request.auth.EmailCertificationRequestDto;
import com.ssafy.back.dto.request.auth.IdCheckRequestDto;
import com.ssafy.back.dto.request.auth.SignUpRequestDto;
import com.ssafy.back.dto.response.auth.SignUpResponseDto;
import com.ssafy.back.dto.response.auth.IdCheckResponseDto;
import com.ssafy.back.dto.response.auth.EmailCertificationResponseDto;

public interface AuthService {
    
    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);

    ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto);
}
