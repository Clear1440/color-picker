package com.spt.repository;

import com.spt.entity.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer> {
    @Query(nativeQuery = true,
            value="SELECT * from subscriptions " +
                    "WHERE date_deleted IS NULL " +
                    "ORDER BY user_id, web_theme_id "
    )
    List<Subscription> fetchAll();
}
