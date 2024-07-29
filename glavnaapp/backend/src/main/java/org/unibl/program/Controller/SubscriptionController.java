package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Requests.SubscriptionRequest;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.Subscription;
import org.unibl.program.Entity.User;
import org.unibl.program.Service.SubscriptionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionService.getAll();
    }

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionService.createSubscription(subscriptionRequest);
        return new ResponseEntity<>(subscription, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable("id") Integer id) {
        Optional<Subscription> subscription = subscriptionService.getSubscription(id);
        return subscription.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        subscriptionService.delete(id);
    }
}
