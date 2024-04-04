package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserEntity signup(UserDto userDto) {
        UserEntity user = UserDto.dtoToEntity(userDto);
        UserEntity savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public UserEntity read(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }

    @Override
    @Transactional
    public UserEntity update(Long id, UserDto userDto) {
        Optional<UserEntity> findUser = userRepository.findById(id);
        findUser.ifPresent(u-> {
            u.setUid(userDto.getUid());
            u.setPassword(userDto.getPassword());
        });
        userRepository.save(findUser.get());
        return findUser.get();
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        Optional<UserEntity> findId = userRepository.findById(id);
        logger.info(findId.get().getUid());
        if(findId.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
