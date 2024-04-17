package com.example.Spring_Practice.Repository;

import com.example.Spring_Practice.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // UID와 닉네임으로 중복 사용자 존재 여부 확인
    boolean existsByUidOrNickname(String uid, String nickname);

    // 로그인을 위해 UID와 비밀번호로 사용자 조회
    Optional<UserEntity> findByUidAndPassword(String uid, String password);
}
