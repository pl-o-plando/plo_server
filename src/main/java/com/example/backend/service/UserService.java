package com.example.backend.service;

import com.example.backend.dto.UserLoginDTO;
import com.example.backend.dto.UserSignUpDTO;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signUp(UserSignUpDTO userSignUpDTO) throws Exception {
        if(userRepository.findByEmail(userSignUpDTO.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        if(userRepository.findByUsername(userSignUpDTO.getUsername()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }

        if(!userSignUpDTO.getPassword().equals(userSignUpDTO.getRe_password())) {
            throw new Exception("비밀번호를 다시 확인해주세요.");
        }

        User createUser = User.builder()
                .userSignUpDTO(userSignUpDTO)
                .build();

        userRepository.save(createUser);

        return createUser;
    }

    public User login(UserLoginDTO userLoginDTO) throws Exception {
        Optional<User> loginUser = userRepository.findByEmailAndPassword(userLoginDTO.getEmail(), userLoginDTO.getPassword());

        if(loginUser.isPresent()) {
            return loginUser.get();
        } else {
            throw new Exception("아이디와 비밀번호를 확인해주세요.");
        }
    }
}