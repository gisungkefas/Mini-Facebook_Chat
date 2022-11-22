package com.kefas.Weekeighttask.service;

import com.kefas.Weekeighttask.dto.UsersDto;
import com.kefas.Weekeighttask.exception.UsersAlreadyExistException;
import com.kefas.Weekeighttask.exception.UsersNotFoundException;

public interface UsersService {

    String register(UsersDto usersDto) throws UsersAlreadyExistException;
    String login(UsersDto usersDto) throws UsersNotFoundException;

}
