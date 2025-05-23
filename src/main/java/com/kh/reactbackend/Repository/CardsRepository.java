package com.kh.reactbackend.Repository;


import com.kh.reactbackend.Dto.CardsDto;
import com.kh.reactbackend.Entity.Cards;

import java.util.List;

public interface CardsRepository{
    List<Cards> findAll();

    void addCard(Cards card);

    Cards findByCard(Long id);

    void deleteCard(Cards card);

    void saveUpdate(Cards card);
}
