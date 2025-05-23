package com.kh.reactbackend.Service;

import com.kh.reactbackend.Dto.CardsDto;

import java.util.List;

public interface CardsService {
    List<CardsDto.Response> findAllC();

    void addCard(CardsDto.Request addCard);

    CardsDto.Response findByCard(Long Cardid);

    void deleteCard(Long id);

    CardsDto.Response updatePartCard(Long id, CardsDto.UpdateCard updateCard);
}
