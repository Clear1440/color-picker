package com.spt.repository;

import com.spt.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class UsersRepository implements CrudRepository<User, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM users")
    public List<User> findAllUsers() {
        return null;
    }
}
