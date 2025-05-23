package com.kh.reactbackend.Service;

import com.kh.reactbackend.Dto.CardsDto;
import com.kh.reactbackend.Entity.Cards;
import com.kh.reactbackend.Entity.Users;
import com.kh.reactbackend.Repository.CardsRepository;
import com.kh.reactbackend.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CardsServiceImp implements CardsService {

    private final CardsRepository cardsRepository;
    private final UsersRepository usersRepository;
    //모든 카드 조회
    @Override
    public List<CardsDto.Response> findAllC() {
        return cardsRepository.findAll().stream()
                .map(CardsDto.Response::fromCard)
                .collect(Collectors.toList());
    }
    //카드 추가
    @Override
    public void addCard(CardsDto.Request addCard) {
        Users user = usersRepository.findById(addCard.getUserId());

        Cards card = Cards.builder()
                .user(user)
                .title(addCard.getTitle())
                .content(addCard.getContent())
                .img(addCard.getImg())
                .build();

        cardsRepository.addCard(card);
    }
    //특정 카드 조회
    @Override
    public CardsDto.Response findByCard(Long CardId) {
        Cards card = cardsRepository.findByCard(CardId);

        if(card == null) {
            throw new RuntimeException("Card not found");
        }
        if(card.getUser() == null) {
            throw new RuntimeException("User not found");
        }
        if(!card.getUser().getId().equals(CardId)) { //CardId > requesterUserId
            throw new RuntimeException("User is not owned by this card");
        }

        return CardsDto.Response.fromCard(card);
    }
    //특정 카드 삭제
    @Override
    public void deleteCard(Long CardId) {
        Cards card = cardsRepository.findByCard(CardId);

        if(card == null) {
            throw new RuntimeException("Card not found");
        }

        if(!card.getUser().getId().equals(CardId)) { //CardId > requesterUserId
            throw new RuntimeException("User is not owned by this card");
        }
        cardsRepository.deleteCard(card);
    }
    //카드 정보 일부 수정
    @Override
    public CardsDto.Response updatePartCard(Long CardId, CardsDto.UpdateCard updateCard) {
        Cards card = cardsRepository.findByCard(CardId);

        if(card == null) {
            throw new RuntimeException("Card not found");
        }

        if(!card.getUser().getId().equals(CardId)) { //CardId > requesterUserId
            throw new RuntimeException("User is not owned by this card");
        }
        card.updatePartCard(
                updateCard.getTitle(),
                updateCard.getContent(),
                updateCard.getImg()
        );
        cardsRepository.saveUpdate(card);

        return CardsDto.Response.fromCard(card);
    }


}
