package com.spt.atom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private Date dateUpdated;
}
