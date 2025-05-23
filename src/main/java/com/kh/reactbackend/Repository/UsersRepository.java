package com.kh.reactbackend.Repository;


import com.kh.reactbackend.Entity.Users;

import java.util.Collection;
import java.util.List;

public interface UsersRepository {
    List<Users> findAll();

    void addUser(Users user);
}
