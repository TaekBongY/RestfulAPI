package com.kh.reactbackend.Repository;

import com.kh.reactbackend.Dto.CardsDto;
import com.kh.reactbackend.Entity.Cards;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsRepositoryImp  implements CardsRepository {
    @PersistenceContext
    private EntityManager em;
    //모든 카드 조회
    @Override
    public List<Cards> findAll() {
        return em.createQuery("select c from Cards c", Cards.class).getResultList();
    }
    //카드 추가
    @Override
    public void addCard(Cards card) {
        em.persist(card);
    }
    //특정 카드 조회
    @Override
    public Cards findByCard(Long id) {
        return em.find(Cards.class, id);
    }
    //특정 카드 삭제
    @Override
    public void deleteCard(Cards card) {
        em.remove(card);
    }
    //카드 정보 일부 수정
    @Override
    public void saveUpdate(Cards card) {
        em.merge(card);
    }


}
