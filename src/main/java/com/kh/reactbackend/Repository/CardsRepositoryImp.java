package com.kh.reactbackend.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CardsRepositoryImp  implements CardsRepository {
    @PersistenceContext
    private EntityManager em;
}
