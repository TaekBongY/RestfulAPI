package com.kh.reactbackend.Service;

import com.kh.reactbackend.Dto.UsersDto;

import java.util.List;

public interface UsersService {
    List<UsersDto.Response> findAllM();

    void addUser(UsersDto.Request addUser);

    UsersDto.Response findById(Long id);

    void deleteUser(Long id);

    UsersDto.Response updatePartUser(Long id, UsersDto.UpdateUser updateDto);
}
