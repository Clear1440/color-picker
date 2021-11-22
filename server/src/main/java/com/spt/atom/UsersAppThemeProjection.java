package com.spt.atom;


import org.springframework.beans.factory.annotation.Value;

public interface UsersAppThemeProjection {
    @Value("#{target.firstname} #{target.lastname}")
    String getFullName();

    @Value("#{target.primary_color}")
    String getPrimaryColor();
    @Value("#{target.secondary_color}")
    String getSecondaryColor();
}