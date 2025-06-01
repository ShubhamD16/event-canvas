package com.app.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.SubscriptonDao;
import com.app.pojo.Subscription;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptonDao subDao;

	@Override
	public Subscription addSubscription(Subscription subscription) {
		subscription.setId(null);
		return subDao.save(subscription);
	}

	@Override
	public Subscription updateSubscription(Long id, Subscription subscription) {
		subscription.setId(id);
		return subDao.save(subscription);
	}

	@Override
	public String deleteSubscription(Long id) {
		Subscription subs = subDao.findById(id).orElse(null);
		if (subs == null) {
			return "error";
		}
		subDao.deleteById(id);
		return "deleted";
	}

	@Override
	public Subscription getSubscription(Long id) {
		return subDao.findById(id).orElse(null);
	}

	@Override
	public List<Subscription> getAllSubscriptions() {
		return subDao.findAll();
	}

}
