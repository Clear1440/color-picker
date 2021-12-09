package com.spt.repository;

import com.spt.entity.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubscriptionRepository {
    @Query(nativeQuery = true,
            value="SELECT * from subscriptions" +
                    "WHERE date_deleted IS NULL"
    )
    List<Subscription> fetchAll();

    @Query(nativeQuery = true,
            value="SELECT * from subscriptions" +
                    "WHERE subcription_id = :id"
    )
    Subscription findById(int id);
}
