package com.devsuperior.hrpayroll.clients;

import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "http://localhost:8001", path = "/workers")
public interface WorkerClient {

    @GetMapping("/{id}")
    Worker findById(@PathVariable Long id);
}