package com.spt.service.impl;


import com.spt.atom.SubscriptionAtom;
import com.spt.entity.Subscription;
import com.spt.repository.SubscriptionRepository;
import com.spt.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    public final SubscriptionRepository subscriptionRepository;
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository){this.subscriptionRepository = subscriptionRepository;}

    @Override
    public List<SubscriptionAtom> fetchAll() {
        return subscriptionRepository.fetchAll().stream()
                .map(Subscription::toAtom)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionAtom createSubscription(SubscriptionAtom subscriptionAtom) {
        Subscription subscription = new Subscription();
        return mergeAndSave(subscription, subscriptionAtom);
    }

//    @Override
//    public SubscriptionAtom updateSubscription(Subscription subscriptionToEdit, SubscriptionAtom subscriptionUpdates) {
//        return mergeAndSave(subscriptionToEdit, subscriptionUpdates);
//    }

    @Override
    public SubscriptionAtom deleteSubscription(Subscription subscription) {
        subscription.setDateDeleted(new Date());
        return subscriptionRepository.save(subscription).toAtom();
    }

    public SubscriptionAtom mergeAndSave(Subscription subscriptionToEdit, SubscriptionAtom subscriptionUpdates){
        subscriptionToEdit.setUserId(subscriptionUpdates.getUserId());
        subscriptionToEdit.setWebThemeId(subscriptionUpdates.getWebThemeId());
        return subscriptionRepository.save(subscriptionToEdit).toAtom();
    }

}
