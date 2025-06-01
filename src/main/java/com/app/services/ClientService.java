package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.CreateOrder;
import com.app.dto.FeedbackDto;
import com.app.dto.OrdersDto;
import com.app.pojo.Client;
import com.app.pojo.Event;
import com.app.pojo.Feedback;
import com.app.pojo.Orders;

public interface ClientService {
	//for client 
	List<Client> getAllClients();
	Optional<Client> getClient(Long id);
	Client addClient(Client client);
	Optional<Client> authanticate(String username,String password);
	Client updateClient(Long id,Client client);
	String deleteClient(Long id);
	
	
	// For Feedback 
	FeedbackDto getFeedback(Long userId);
	String addFeedback(Long userId, Feedback fback);
	
	
}
