package com.spt.atom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebThemeAtom {
    private int webThemeId;
    private String associatedUrl;
    private String theme;
}
