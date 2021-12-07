package com.spt.repository;

import com.spt.entity.WebTheme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebThemeRepository extends CrudRepository<WebTheme,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM web_themes " +
                    "WHERE associated_url LIKE :url")
    List<WebTheme> fetchListByAssociatedUrl(String url);

    @Query(nativeQuery = true,
            value = "SELECT * FROM web_themes " +
                    "WHERE date_deleted IS NULL")
    List<WebTheme> retrieveAll();
}
