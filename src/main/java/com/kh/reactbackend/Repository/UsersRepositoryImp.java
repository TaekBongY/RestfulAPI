package com.kh.reactbackend.Repository;

import com.kh.reactbackend.Dto.UsersDto;
import com.kh.reactbackend.Entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class UsersRepositoryImp implements UsersRepository {

    @PersistenceContext
    private EntityManager em;

    //모든 유저 조회
    @Override
    public List<Users> findAll() {
        return em.createQuery("select m from Users m", Users.class).getResultList();
    }
    //유저 추가
    @Override
    public void addUser(Users user) {
        em.persist(user);
    }
    //특정 유저 조회
    @Override
    public Users findById(Long id) {
        return em.find(Users.class, id);
    }
    //특정 유저 삭제
    @Override
    public void deleteUser(Users user) {
        em.remove(user);
    }
    //유저 정보 일부 수정
    @Override
    public void saveUpdate(Users user) {
        em.merge(user);
    }


}
