package com.ssafy.back.service;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.ssafy.back.dto.request.auth.CheckCertificationRequestDto;
import com.ssafy.back.dto.request.auth.EmailCertificationRequestDto;
import com.ssafy.back.dto.request.auth.IdCheckRequestDto;
import com.ssafy.back.dto.request.auth.SignInRequestDto;
import com.ssafy.back.dto.request.auth.SignUpRequestDto;
import com.ssafy.back.dto.response.auth.SignUpResponseDto;
import com.ssafy.back.dto.response.auth.SignInResponseDto;
import com.ssafy.back.dto.response.auth.IdCheckResponseDto;
import com.ssafy.back.dto.response.auth.EmailCertificationResponseDto;
import com.ssafy.back.dto.response.auth.CheckCertificationResponseDto;

public interface AuthService {
    
    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn (SignInRequestDto dto);
}
