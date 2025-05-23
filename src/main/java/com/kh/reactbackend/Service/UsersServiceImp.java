package com.kh.reactbackend.Service;

import com.kh.reactbackend.Dto.UsersDto;
import com.kh.reactbackend.Entity.Users;
import com.kh.reactbackend.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImp implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<UsersDto.Response> findAllM() {
        return usersRepository.findAll().stream()
                .map(UsersDto.Response::fromUser)
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(UsersDto.Requset addUser) {
        Users user = addUser.toUser();
        usersRepository.addUser(user);
    }
}
