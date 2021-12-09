package com.spt.entity;

import com.spt.atom.SubscriptionAtom;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name="subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subscription_id", unique = true, nullable = false)
    private int subscriptionId;

    @Column(length=10, name="user_id")
    private int userId;

    @Column(length=10, name="web_theme_id")
    private int webThemeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_created", insertable = false)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_updated", insertable = false)
    private Date dateUpdated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_deleted")
    private Date dateDeleted;

    public SubscriptionAtom toAtom(){
        SubscriptionAtom subscriptionAtom = new SubscriptionAtom();
        BeanUtils.copyProperties(this,subscriptionAtom);
        return subscriptionAtom;
    }
}
