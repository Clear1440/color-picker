package com.spt.atom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionAtom {
    private int subscriptionId;
    private int userId;
    private int webThemeId;
}
