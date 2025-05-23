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
    //모든 유저 조회
    @GetMapping
    public ResponseEntity<List<UsersDto.Response>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAllM());
    }
    //유저 추가
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UsersDto.Requset addUser) {
        usersService.addUser(addUser);
        return ResponseEntity.ok("회원 등록 성공");
    }
    //특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UsersDto.Response> getUser(@PathVariable Long id) {
        UsersDto.Response user = usersService.findById(id);
        return ResponseEntity.ok(user);
    }
    //특정 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    //유저 정보 일부 수정
    @PatchMapping("/{id}")
    public ResponseEntity<UsersDto.Response> updateUser(
            @PathVariable Long id,
            @RequestBody UsersDto.UpdateUser updateDto) {
        UsersDto.Response updateUser = usersService.updatePartUser(id, updateDto);
        return ResponseEntity.ok(updateUser);
    }
}
