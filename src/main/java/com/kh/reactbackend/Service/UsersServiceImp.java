package com.kh.reactbackend.Service;

import com.kh.reactbackend.Dto.UsersDto;
import com.kh.reactbackend.Entity.Users;
import com.kh.reactbackend.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImp implements UsersService {

    private final UsersRepository usersRepository;
    //모든 유저 조회
    @Override
    public List<UsersDto.Response> findAllM() {
        return usersRepository.findAll().stream()
                .map(UsersDto.Response::fromUser)
                .collect(Collectors.toList());
    }
    //유저 추가
    @Override
    public void addUser(UsersDto.Request addUser) {
        Users user = addUser.toUser();
        usersRepository.addUser(user);
    }
    //특정 유저 조회
    @Override
    public UsersDto.Response findById(Long id) {
        Users user = usersRepository.findById(id);
//                .orElseThrow(() - > new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return UsersDto.Response.fromUser(user);
    }
    //특정 유저 삭제
    @Override
    public void deleteUser(Long id) {
        Users user = usersRepository.findById(id);
        usersRepository.deleteUser(user);
    }
    //유저 정보 일부 수정
    @Override
    public UsersDto.Response updatePartUser(Long id, UsersDto.UpdateUser updateDto) {
        Users user = usersRepository.findById(id);

        user.updatePartUser(
                updateDto.getEmail(),
                updateDto.getAge(),
                updateDto.getIsOnline()
        );

        usersRepository.saveUpdate(user);

        return UsersDto.Response.fromUser(user);
    }





}
