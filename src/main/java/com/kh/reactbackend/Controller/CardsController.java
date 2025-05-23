package com.kh.reactbackend.Controller;

import com.kh.reactbackend.Dto.CardsDto;
import com.kh.reactbackend.Entity.Cards;
import com.kh.reactbackend.Service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")
public class CardsController {
    @Autowired
    private CardsService cardsService;
    //모든 카드 조회
    @GetMapping
    public ResponseEntity<List<CardsDto.Response>> getCards() {
        return ResponseEntity.ok(cardsService.findAllC());
    }
    //카드 추가
    @PostMapping
    public ResponseEntity<String> createCard(@RequestBody CardsDto.Request addCard) {
        cardsService.addCard(addCard);
        return ResponseEntity.ok("추가 성공");
    }
    //특정 카드 조회
    @GetMapping("/{id}")
    public ResponseEntity<CardsDto.Response> getCard(@PathVariable Long CardId) {
        CardsDto.Response card = cardsService.findByCard(CardId);
        return ResponseEntity.ok(card);
    }
    //특정 카드 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable Long id) {
        cardsService.deleteCard(id);
        return ResponseEntity.ok().build();
    }

    //카드 정보 일부 수정
    @PatchMapping("/{id}")
    public ResponseEntity<CardsDto.Response> updateCard(
            @PathVariable Long id,
            @RequestBody CardsDto.UpdateCard updateCard) {
        return ResponseEntity.ok(cardsService.updatePartCard(id, updateCard));
    }
}
