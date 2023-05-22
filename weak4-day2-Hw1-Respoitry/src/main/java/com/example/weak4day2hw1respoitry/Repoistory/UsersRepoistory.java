package com.example.weak4day2hw1respoitry.Repoistory;

import com.example.weak4day2hw1respoitry.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepoistory extends JpaRepository<Users,Integer> {
}
