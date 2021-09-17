package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.clients.WorkerClient;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerClient workerClient;

    public Payment getPayment(Long id, Integer days) {
        Worker worker = workerClient.findById(id);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
