package com.app.services;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.ClientDao;
import com.app.dao.EventDao;
import com.app.dao.OrdersDao;
import com.app.dto.ClientDto;
import com.app.dto.CreateOrder;
import com.app.dto.FeedbackDto;
import com.app.dto.OrdersDto;
import com.app.pojo.Client;
import com.app.pojo.Event;
import com.app.pojo.Feedback;
import com.app.pojo.Orders;
import com.app.pojo.Subscription;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDao clientDao;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	EventDao eventDao;

	@Autowired
	SubscriptionServiceImpl subsServer;

	// TODO Add DTO for data transfer (Standart Practice in industry)

	@Override
	public List<Client> getAllClients() {
		return clientDao.findAll();
	}

	@Override
	public Client addClient(Client client) {
		client.setId(null);
		return clientDao.save(client);
	}

	@Override
	public Optional<Client> getClient(Long id) {

		return clientDao.findById(id);
	}

	@Override
	public Optional<Client> authanticate(String email, String password) {

		return clientDao.findByEmailAndPassword(email, password);
	}

	@Override
	public Client updateClient(Long id, Client client) {
		client.setId(id);
		return clientDao.save(client);
	}

	@Override
	public String deleteClient(Long id) {
		Client client = clientDao.findById(id).orElse(null);
		if (client == null) {
			return "error";
		}
		clientDao.deleteById(id);
		return "deleted";
	}

	@Override
	public FeedbackDto getFeedback(Long userId) {
		Client client = clientDao.findById(userId).orElse(null);
		if (client == null) {
			return new FeedbackDto();
		}
		return new FeedbackDto(client.getFeedback());
	}

	@Override
	public String addFeedback(Long userId, Feedback fback) {
		Client client = clientDao.findById(userId).orElse(null);
		if (client == null) {
			return "error";
		}
		fback.setClient(client);
		client.setFeedback(fback);
		return "sucessful";
	}

	

	
	

}
