package com.spt.entity;

import com.spt.atom.UserAtom;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int userid;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 50)
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", insertable = false)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated", insertable = false)
    private Date dateUpdated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_deleted")
    private Date dateDeleted;

    public UserAtom toAtom(){
        UserAtom userAtom = new UserAtom();
        BeanUtils.copyProperties(this, userAtom);
        return userAtom;
    }
}
