package com.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojo.Subscription;
import com.app.services.SubscriptionService;



@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subService;
	
	@PostMapping("/add")
	public Subscription addSubscription(@RequestBody Subscription subscription) {
		return subService.addSubscription(subscription);
	}
	
	@PutMapping("/update/{id}")
	public Subscription updateSubscription(@PathVariable Long id,@RequestBody Subscription subscription) {
		return subService.updateSubscription(id, subscription);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteSubscription(@PathVariable Long id) {
		return subService.deleteSubscription(id);
	}
	
	@GetMapping("/{id}")
	public Subscription getSubscription(@PathVariable Long id) {
		return subService.getSubscription(id);
	}
	
	@GetMapping("/all")
	public List<Subscription> getAllSubscriptions() {
		return subService.getAllSubscriptions();
	}
}
