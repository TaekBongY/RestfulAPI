package com.kh.reactbackend.Repository;


import com.kh.reactbackend.Entity.Users;

import java.util.List;

public interface UsersRepository {
    List<Users> findAll();

    void addUser(Users user);

    Users findById(Long id);

    void deleteUser(Users user);

    void saveUpdate(Users user);
}
