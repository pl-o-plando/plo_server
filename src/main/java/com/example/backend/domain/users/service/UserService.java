package com.example.backend.domain.users.service;

import com.example.backend.domain.users.dto.UserSignUpDto;
import com.example.backend.domain.users.entity.User;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(UserSignUpDto userSignUpDto) throws Exception {
        if(userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if(userRepository.findByUsername(userSignUpDto.getUsername()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        if(!userSignUpDto.getPassword().equals(userSignUpDto.getRe_password())) {
            throw new Exception("비밀번호를 다시 확인해주세요.");
        }

        User user = User.builder()
                .userSignUpDto(userSignUpDto)
                .build();

        userRepository.save(user);
    }
}