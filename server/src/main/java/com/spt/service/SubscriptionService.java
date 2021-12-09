package com.spt.service;

import com.spt.atom.SubscriptionAtom;
import com.spt.entity.Subscription;
import java.util.List;

public interface SubscriptionService {
    List<SubscriptionAtom> fetchAll();
    SubscriptionAtom fetchSubscription(int id);
    SubscriptionAtom createSubscription(SubscriptionAtom subscription);
    SubscriptionAtom updateSubscription(SubscriptionAtom subscriptionUpdates, Subscription subscriptionToEdit);
    SubscriptionAtom deleteSubscription(Subscription subscription);
}
