package com.api.scania.api.scania.controller;

import com.api.scania.api.scania.model.Orgao;
import com.api.scania.api.scania.model.Status;
import com.api.scania.api.scania.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/list")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status")
    public List<Status> lista() {
        return statusRepository.findAll();
    }

    @GetMapping("/status/{id}")
    public List<Status> lista(@PathVariable int id) {
        return statusRepository.findAllById(Collections.singleton(id
        ));
    }
}
