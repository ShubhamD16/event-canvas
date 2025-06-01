package com.app.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.OrdersDao;
import com.app.dto.ApiResponse;
import com.app.dto.ClientDto;
import com.app.dto.CreateOrder;
import com.app.dto.FeedbackDto;
import com.app.dto.OrdersDto;
import com.app.pojo.Client;
import com.app.pojo.Feedback;
import com.app.pojo.Orders;
import com.app.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/all")
	public ResponseEntity<List<ClientDto>> getAllClients() {
		return ResponseEntity
				.ok(clientService.getAllClients().stream().map(c -> new ClientDto(c)).collect(Collectors.toList()));
	}

	@PostMapping("/add")
	public ApiResponse addClient(@RequestBody Client client) {
		if (clientService.addClient(client) == null) {
			return new ApiResponse("Error adding client");
		}
		return new ApiResponse("Client Added");
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> getClientFromId(@PathVariable Long id) {

		Client client = clientService.getClient(id).orElse(null);

		return ResponseEntity.ok(new ClientDto(client));
	}

	@PostMapping("/authanticate")
	public ResponseEntity<ClientDto> Authanticate(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		Client client = clientService.authanticate(email, password).orElse(null);
		if (client == null) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok(new ClientDto(client));

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ClientDto> UpdateClient(@RequestBody Client client, @PathVariable Long id) {
		return ResponseEntity.ok(new ClientDto(clientService.updateClient(id, client)));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeleteClient(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.deleteClient(id));
	}

	@GetMapping("/feedback/{userId}")
	public ResponseEntity<FeedbackDto> getFeedback(@PathVariable Long userId) {
		return ResponseEntity.ok(clientService.getFeedback(userId));
	}

	@PutMapping("/feedback/add/{userId}")
	public ResponseEntity<String> addFeedback(@PathVariable Long userId, @RequestBody Feedback feedback) {
		feedback.setDate(LocalDateTime.now());
		return ResponseEntity.ok(clientService.addFeedback(userId, feedback));
	}

}
