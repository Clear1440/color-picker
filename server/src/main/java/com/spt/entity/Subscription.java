package com.spt.entity;

import com.spt.atom.SubscriptionAtom;
import com.spt.atom.UserAtom;
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
    @Column(name="subscriptionid", unique = true, nullable = false)
    private int subcriptionId;

    @Column(length=10, name="userid")
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
