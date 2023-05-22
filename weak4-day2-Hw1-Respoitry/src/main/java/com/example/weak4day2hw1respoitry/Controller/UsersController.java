package com.example.weak4day2hw1respoitry.Controller;

import com.example.weak4day2hw1respoitry.Model.Users;
import com.example.weak4day2hw1respoitry.Services.UsersServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    public final UsersServices usersServices;

    @GetMapping("/get")
    public ResponseEntity<List<Users>>getUsers(){
        List<Users> usersList=usersServices.getUsers();
        return ResponseEntity.status(200).body(usersList);
    }
    @PostMapping("/add")
    public ResponseEntity addCoffe(@Valid @RequestBody Users users , Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        usersServices.addUsers(users);
        return ResponseEntity.status(200).body("add sucssufully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@Valid @RequestBody Users users, @PathVariable Integer id, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        boolean isUpdate = usersServices.updateUsers(id, users);
        if (isUpdate) {
            return ResponseEntity.status(200).body("update succssufoly");
        }        return ResponseEntity.status(400).body("wrong id ");

    }
}
