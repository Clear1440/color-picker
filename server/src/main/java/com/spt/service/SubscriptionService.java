package com.spt.service;

import com.spt.atom.SubscriptionAtom;
import com.spt.entity.Subscription;
import java.util.List;

public interface SubscriptionService {
    List<SubscriptionAtom> fetchAll();
    SubscriptionAtom createSubscription(SubscriptionAtom subscription);
//    SubscriptionAtom updateSubscription(Subscription subscriptionToEdit, SubscriptionAtom subscriptionUpdates);
    SubscriptionAtom deleteSubscription(Subscription subscription);
}
