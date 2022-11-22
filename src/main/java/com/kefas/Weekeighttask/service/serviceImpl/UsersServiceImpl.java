package com.kefas.Weekeighttask.service.serviceImpl;

import com.kefas.Weekeighttask.dto.UsersDto;
import com.kefas.Weekeighttask.entity.Users;
import com.kefas.Weekeighttask.exception.UsersAlreadyExistException;
import com.kefas.Weekeighttask.exception.UsersNotFoundException;
import com.kefas.Weekeighttask.repository.TaskRepository;
import com.kefas.Weekeighttask.repository.UsersRepository;
import com.kefas.Weekeighttask.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final TaskRepository taskRepository;

    @Override
    public String register(UsersDto usersDto) throws UsersAlreadyExistException {
        Users users = new Users();
        boolean existUser = usersRepository.findUsersByEmail(usersDto.getEmail()).isPresent();
        if(existUser){
            throw new UsersAlreadyExistException("User with "+usersDto.getEmail()+"Already Exist");
        }
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(users.getLastname());
        users.setEmail(usersDto.getEmail());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setPassword(usersDto.getPassword());
        usersRepository.save(users);
        return "Register Successfully";
    }

    @Override
    public String login(UsersDto usersDto) throws UsersNotFoundException {
        Users users = usersRepository.findByEmailAndPassword(usersDto.getEmail(), usersDto.getPassword());
        if(users == null){
            throw new UsersNotFoundException("Fill out the required fields");
        }
        if(!Objects.equals(users.getPassword(), usersDto.getPassword()) || !Objects.equals(users.getEmail(), usersDto.getEmail())){
            return "Invalid Email or Password";
        }
        return "Login Successfully";
    }
}
