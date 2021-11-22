package com.spt.repository;

import com.spt.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM users")
    List<User> findAllUsers();

    @Query(nativeQuery = true,
            value="SELECT * FROM users " +
                    "WHERE user_id = :id "
    )
    User findById(int id);

    @Query(nativeQuery = true,
            value="SELECT * FROM users " +
                    "WHERE IF(1 = :isActive, date_deleted IS NULL, date_deleted IS NOT NULL)"
    )
    List<User> fetchUsersByActiveStatus(boolean isActive);

    @Query(nativeQuery = true,
            value="SELECT * FROM users " +
                    "WHERE username LIKE :domain "
    )
    List<User> fetchUsersByUsernameDomain(String domain);


}
