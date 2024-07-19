package com.ssafy.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafy.back.dto.response.ResponseDto;
import com.ssafy.back.service.AuthService;
import com.ssafy.back.common.CertificationNumber;
import com.ssafy.back.dto.request.auth.CheckCertificationRequestDto;
import com.ssafy.back.dto.request.auth.EmailCertificationRequestDto;
import com.ssafy.back.dto.request.auth.IdCheckRequestDto;
import com.ssafy.back.dto.request.auth.SignUpRequestDto;
import com.ssafy.back.dto.response.auth.CheckCertificationResponseDto;
import com.ssafy.back.dto.response.auth.EmailCertificationResponseDto;
import com.ssafy.back.dto.response.auth.IdCheckResponseDto;
import com.ssafy.back.dto.response.auth.SignUpResponseDto;
import com.ssafy.back.entity.CertificationEntity;
import com.ssafy.back.provider.EmailProvider;
import com.ssafy.back.repository.CertificationRepository;
import com.ssafy.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;

    private final EmailProvider emailProvider;

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

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        try{

            String userId = dto.getId();

            boolean isExistId = userRepository.existsByUserId(userId);
            if(isExistId) return SignUpResponseDto.duplicateId();

            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();
            
            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {
        try{
            
            String userId = dto.getId();
            String email = dto.getEmail();

            boolean isExistId = userRepository.existsByUserId(userId);
            if(isExistId) return EmailCertificationResponseDto.duplicateId();

            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccessed = emailProvider.sendCertificationMail(email, certificationNumber);
            if(!isSuccessed) return EmailCertificationResponseDto.mailSendFail();

            CertificationEntity certificationEntity  = new CertificationEntity(userId, email, certificationNumber);
            certificationRepository.save(certificationEntity);

        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return EmailCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto) {
        
        try{

            String userId = dto.getId();
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();

            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);
            if(certificationEntity==null) return CheckCertificationResponseDto.certificatonFail();

            boolean isMatched = certificationEntity.getEmail().equals(email) && certificationEntity.getCertificationNumber().equals(certificationEntity);
            if(!isMatched) return CheckCertificationResponseDto.certificatonFail();


        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return CheckCertificationResponseDto.success();
    }
    
}
