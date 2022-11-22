package com.kefas.Weekeighttask.controllers;

import com.kefas.Weekeighttask.dto.UsersDto;
import com.kefas.Weekeighttask.entity.Users;
import com.kefas.Weekeighttask.exception.UsersAlreadyExistException;
import com.kefas.Weekeighttask.exception.UsersNotFoundException;
import com.kefas.Weekeighttask.service.serviceImpl.UsersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class UsersController {

    private final UsersServiceImpl usersService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsersDto usersDto) throws UsersAlreadyExistException {
        return new ResponseEntity<>(usersService.register(usersDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsersDto usersDto) throws UsersNotFoundException {
        return new ResponseEntity<>(usersService.login(usersDto), HttpStatus.ACCEPTED);
    }

}
