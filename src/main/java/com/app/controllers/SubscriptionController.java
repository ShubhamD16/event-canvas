package com.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
		return ResponseEntity.ok(subService.addSubscription(subscription));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id,
			@RequestBody Subscription subscription) {
		return ResponseEntity.ok(subService.updateSubscription(id, subscription));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteSubscription(@PathVariable Long id) {
		return ResponseEntity.ok(subService.deleteSubscription(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getSubscription(@PathVariable Long id) {
		return ResponseEntity.ok(subService.getSubscription(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Subscription>> getAllSubscriptions() {
		return ResponseEntity.ok(subService.getAllSubscriptions());
	}
}
