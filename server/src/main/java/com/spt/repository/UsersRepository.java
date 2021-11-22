package com.spt.repository;

import com.spt.atom.UsersAppThemeProjection;
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

    @Query(nativeQuery = true,
            value = "SELECT usr.firstname, usr.lastname, apt.primary_color, apt.secondary_color FROM users usr " +
                    "LEFT JOIN user_prefences up ON up.user_id = usr.user_id " +
                    "LEFT JOIN app_themes apt ON apt.app_theme_id = up.app_theme_id " +
                    "WHERE usr.user_id = :id"
    )
    UsersAppThemeProjection fetchColorPaletteById(int id);

}
