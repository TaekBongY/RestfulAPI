package com.kh.reactbackend.Repository;

import com.kh.reactbackend.Entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepositoryImp implements UsersRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Users> findAll() {
        return em.createQuery("select m from Users m", Users.class).getResultList();
    }

    @Override
    public void addUser(Users user) {
        em.persist(user);
    }
}
