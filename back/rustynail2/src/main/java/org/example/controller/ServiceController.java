package org.example.controller;

import org.example.domain.Service;
import org.example.repos.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class ServiceController {
    @Autowired
    private ServiceRepo serviceRepo;

    private List<Service> serviceFromDb;

    @PostMapping("/service")
    public Map<String, List<Service>> getAll() {
        serviceFromDb = serviceRepo.findAll();
        Map<String, List<Service>> map = new HashMap<>();
        for (Service x: serviceFromDb) {
            if (map.containsKey(x.getType_srv())) {
                map.get(x.getType_srv()).add(x);
            } else {
                map.put(x.getType_srv(), new ArrayList<Service>(Arrays.asList(x)));
            }
        }
        return map;
    }
}
