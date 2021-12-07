package com.spt.entity;

import com.spt.atom.WebThemeAtom;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "web_themes")
public class WebTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "web_theme_id", unique = true, nullable = false)
    private int webThemeId;

    @Column(length = 50, name = "associated_url")
    private String associatedUrl;

    @Column(length = 50,  name = "theme")
    private String theme;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", insertable = false)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated", insertable = false)
    private Date dateUpdated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_deleted")
    private Date dateDeleted;

    public WebThemeAtom toAtom(){
        WebThemeAtom webThemeAtom= new WebThemeAtom();
        BeanUtils.copyProperties(this, webThemeAtom);
        return webThemeAtom;
    }
}