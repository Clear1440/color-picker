package com.spt.service.impl;


import com.spt.atom.SubscriptionAtom;
import com.spt.entity.Subscription;
import com.spt.repository.SubscriptionRepository;
import com.spt.service.SubscriptionService;
import org.springframework.stereotype.Service;

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
    public SubscriptionAtom fetchSubscription(int id) {
        return subscriptionRepository.findById(id).toAtom();
    }

    @Override
    public SubscriptionAtom createSubscription(SubscriptionAtom subscriptionAtom) {
        Subscription subscription = new Subscription();
        return
    }

    @Override
    public SubscriptionAtom updateSubscription(SubscriptionAtom subscriptionUpdates, Subscription subscriptionToEdit) {
        return null;
    }

    @Override
    public SubscriptionAtom deleteSubscription(Subscription subscription) {
        return null;
    }

}
