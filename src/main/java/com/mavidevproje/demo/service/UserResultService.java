package com.mavidevproje.demo.service;

import com.mavidevproje.demo.entity.UserResult;
import com.mavidevproje.demo.repository.UserResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserResultService {
    private final UserResultRepository userResultRepository;

    public UserResult saveResult(UserResult userResult) {
        return userResultRepository.save(userResult);
    }

    public List<UserResult> getAllByUserId(Long id){
        return userResultRepository.findAllByUser_Id(id);
    }
}
