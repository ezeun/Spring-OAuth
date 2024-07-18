package com.ssafy.back.service;

import org.springframework.http.ResponseEntity;

import com.ssafy.back.dto.request.auth.IdCheckRequestDto;
import com.ssafy.back.dto.response.auth.IdCheckResponseDto;;

public interface AuthService {
    
    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
}
