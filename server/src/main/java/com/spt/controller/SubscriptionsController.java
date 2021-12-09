package com.spt.controller;

import com.spt.atom.SubscriptionAtom;
import com.spt.entity.Subscription;
import com.spt.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/v1/subscriptions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubscriptionsController {
    public final SubscriptionService subscriptionService;
    @Autowired
    public SubscriptionsController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<SubscriptionAtom>> fetchAllSubscriptions(){
        return new ResponseEntity<>(subscriptionService.fetchAll(), HttpStatus.OK);
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SubscriptionAtom> createSubscription(@RequestBody SubscriptionAtom subscriptionAtom){
        return new ResponseEntity<>(subscriptionService.createSubscription(subscriptionAtom), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubscriptionAtom> fetchSubscription(@ModelAttribute("id") Subscription subscription){
        return new ResponseEntity<>(subscription.toAtom(), HttpStatus.OK);
    }

//    @PatchMapping(value = "/{id}",
//                    consumes = MediaType.APPLICATION_JSON_VALUE,
//                    produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<SubscriptionAtom> updateSubscription(
//            @RequestBody SubscriptionAtom subscriptionUpdates,
//            @ModelAttribute("id") Subscription subscriptionToEdit){
//        return new ResponseEntity<>(subscriptionService.updateSubscription(subscriptionToEdit, subscriptionUpdates), HttpStatus.OK);
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SubscriptionAtom> deleteSubscription(@ModelAttribute("id") Subscription subscription){
        return new ResponseEntity<>(subscriptionService.deleteSubscription(subscription),HttpStatus.OK);
    }
}
