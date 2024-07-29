package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.SubscriptionRequest;
import org.unibl.program.Entity.Subscription;

import java.util.List;
import java.util.Optional;

@Service
public interface SubscriptionService {
    List<Subscription> getAll();
    Subscription createSubscription(SubscriptionRequest subscriptionRequest);
    Optional<Subscription> getSubscription(Integer id);
    void delete(Integer id);
}
