package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.SubscriptionRequest;
import org.unibl.program.Entity.Subscription;
import org.unibl.program.Repository.SubscriptionRepository;
import org.unibl.program.Service.SubscriptionService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription createSubscription(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = Subscription.builder().idSubscription(subscriptionRequest.getIdSubscription())
                                                            .category_idCategory(subscriptionRequest.getCategory_idCategory())
                                                            .user_idUser(subscriptionRequest.getUser_idUser())
                                                            .date(subscriptionRequest.getDate()).build();
        Subscription saved = subscriptionRepository.save(subscription);
        return saved;
    }

    @Override
    public Optional<Subscription> getSubscription(Integer id) {
        log.info("Getting subscription with id: " + id);
        return subscriptionRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        subscriptionRepository.deleteById(id);
    }
}
