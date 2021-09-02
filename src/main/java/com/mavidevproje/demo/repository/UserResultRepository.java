package com.mavidevproje.demo.repository;

import com.mavidevproje.demo.entity.UserResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResultRepository extends JpaRepository<UserResult, Long> {
    List<UserResult> findAllByUser_Id(Long id);
}
