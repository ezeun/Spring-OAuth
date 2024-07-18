package com.ssafy.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafy.back.dto.response.ResponseDto;
import com.ssafy.back.service.AuthService;

import com.ssafy.back.dto.request.auth.IdCheckRequestDto;
import com.ssafy.back.dto.response.auth.IdCheckResponseDto;
import com.ssafy.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final UserRepository userRepository;

    @Override 
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {
        
        try{

            String userId = dto.getId();
            boolean isExistId = userRepository.existsByUserId(userId);
            if(isExistId) return IdCheckResponseDto.duplicateId();

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return IdCheckResponseDto.success();
    }
    
}
