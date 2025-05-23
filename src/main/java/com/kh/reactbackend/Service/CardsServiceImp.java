package com.kh.reactbackend.Service;

import com.kh.reactbackend.Repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CardsServiceImp implements CardsService {

    private final CardsRepository cardsRepository;
}
