package com.example.weak4day2hw1respoitry.Services;

import com.example.weak4day2hw1respoitry.Model.Users;
import com.example.weak4day2hw1respoitry.Repoistory.UsersRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServices {
    private  final UsersRepoistory usersRepoistory;
    public List<Users> getUsers(){
        return usersRepoistory.findAll();
    }
public void addUsers(Users users){
        usersRepoistory.save(users);
}
public boolean updateUsers(Integer id,Users users){
        Users oldUsers=usersRepoistory.getById(id);
        if(oldUsers==null){
            return  false;
        }
        oldUsers.setName(users.getName());
        oldUsers.setAge(users.getAge());
        oldUsers.setUsername(users.getUsername());
        oldUsers.setEmail(users.getEmail());
        oldUsers.setPassword(users.getPassword());
        oldUsers.setRole(users.getRole());
        return true;
}
public boolean deleteUsers(Integer id){
        Users oldusers=usersRepoistory.getById(id);
    if(oldusers==null){
        return  false;
    }
        usersRepoistory.delete(oldusers);
    return true;
}

}
