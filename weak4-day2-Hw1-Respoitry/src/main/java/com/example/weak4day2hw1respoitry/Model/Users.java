package com.example.weak4day2hw1respoitry.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.apache.naming.factory.SendMailFactory;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Users {
   @Id
    private Integer id;
   @NotEmpty(message = "the name cannot be null")
   @Column(columnDefinition = "varchar(20) not null")
   private String name;
   @NotEmpty(message = "the username cannot be null")
   @Column(columnDefinition = "varchar(20) not null ")
   @Max(4)
   private String username;
   @NotEmpty(message = "the password cannot be null")
   @Column(columnDefinition = "varchar(20) not null  ")
   private  Integer password;
   @NotNull(message = "the password cannot be null")
   @Column(columnDefinition = "varchar(20) not null check (category ='user' or 'admin')  not null ")
   private String role;
    @NotNull(message = "the emial cannot be null")
    @Email
    @Column(columnDefinition = "varchar(20) not null")
   private String email;
    @NotNull(message = "the password cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
   private  Integer   age;
}
