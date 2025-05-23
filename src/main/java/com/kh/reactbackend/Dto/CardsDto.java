package com.kh.reactbackend.Dto;

import com.kh.reactbackend.Entity.Cards;
import com.kh.reactbackend.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardsDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String img;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request{
        private Long userId;
        private String title;
        private String content;
        private String img;

    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long id;
        private Long userId;
        private String userName;
        private String title;
        private String content;
        private String img;

        public static CardsDto.Response fromCard(Cards card) {
            return Response.builder()
                    .id(card.getId())
                    .userId(card.getUser().getId())
                    .userName(card.getUser().getName())
                    .title(card.getTitle())
                    .content(card.getContent())
                    .img(card.getImg())
                    .build();
        }


    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateCard {
        private String title;
        private String content;
        private String img;
    }
}
