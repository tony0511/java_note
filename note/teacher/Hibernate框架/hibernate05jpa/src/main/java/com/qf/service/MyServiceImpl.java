package com.qf.service;

import com.qf.dao.MyComputerJpaDAO;
import com.qf.pojo.MyComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Thanks for Everything.
 */
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyComputerJpaDAO myComputerJpaDAO;

//	@Transactional
	public void addCom(MyComputer computer) {
		myComputerJpaDAO.save(computer);
	}


	public MyComputer findById(Long id) {
		MyComputer one = myComputerJpaDAO.findOne(id);
		return one;
	}
}
