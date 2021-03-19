package org.example.controller;
import org.example.domain.Adress;
import org.example.repos.AdressRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdressController {
    @Autowired
    private AdressRepo adressRepo;

    private List<Adress> adressFromDB;

    @PostMapping("/adress")
    public List<Adress> getAll(){
        adressFromDB = adressRepo.findAll();
        return adressFromDB;
    }
}
