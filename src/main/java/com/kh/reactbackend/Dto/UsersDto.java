package com.kh.reactbackend.Dto;

import com.kh.reactbackend.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
    private Long id;
    private String username;
    private String email;
    private String name;
    private int age;
    private Boolean isOnline;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request{
        private String name;
        private String email;
        private String password;
        private int age;
        private Boolean isOnline;

        public Users toUser(){
            return Users.builder()
                    .name(this.name)
                    .email(this.email)
                    .password(this.password)
                    .age(this.age)
                    .isOnline(this.isOnline)
                    .build();
        }
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long id;
        private String email;
        private String name;
        private int age;
        private Boolean isOnline;

        public static Response fromUser(Users user) {
            return Response.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .age(user.getAge())
                    .isOnline(user.getIsOnline())
                    .build();
        }


    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateUser{
        private String email;
        private Integer age;
        private Boolean isOnline;
    }
}

