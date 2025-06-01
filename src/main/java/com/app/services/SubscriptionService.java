package com.app.services;

import java.util.List;

import com.app.pojo.Subscription;

public interface SubscriptionService {
	Subscription addSubscription(Subscription subscription);
	Subscription updateSubscription(Long id,Subscription subscription);
	String deleteSubscription(Long id);
	Subscription getSubscription(Long id);
	List<Subscription> getAllSubscriptions();
}
