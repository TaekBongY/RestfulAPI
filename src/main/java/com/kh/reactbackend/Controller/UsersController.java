package com.kh.reactbackend.Controller;

import com.kh.reactbackend.Dto.UsersDto;
import com.kh.reactbackend.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDto.Response>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAllM());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UsersDto.Requset addUser) {
        usersService.addUser(addUser);
        return ResponseEntity.ok("회원 등록 성공");
    }


}
