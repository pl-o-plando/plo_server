package com.example.backend.domain.users.service;

import com.example.backend.domain.users.dto.UserLoginDto;
import com.example.backend.domain.users.dto.UserSignUpDto;
import com.example.backend.domain.users.entity.User;
import com.example.backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signUp(UserSignUpDto userSignUpDto) throws Exception {
        if(userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if(userRepository.findByUsername(userSignUpDto.getUsername()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        if(!userSignUpDto.getPassword().equals(userSignUpDto.getRe_password())) {
            throw new Exception("비밀번호를 다시 확인해주세요.");
        }

        User createUser = User.builder()
                .userSignUpDto(userSignUpDto)
                .build();

        userRepository.save(createUser);

        return createUser;
    }

    public User login(UserLoginDto userLoginDto) throws Exception {
        Optional<User> loginUser = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if(loginUser.isPresent()) {
            return loginUser.get();
        } else {
            throw new Exception("아이디와 비밀번호를 확인해주세요.");
        }
    }
}