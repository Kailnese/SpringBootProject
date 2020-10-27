package com.kailnese.controller;

import com.kailnese.bean.Client;
import com.kailnese.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/info")
public class MainController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/getClient")
    public String getClients(Model model){
        List<Client> all = clientRepository.findAll();
        model.addAttribute("clients", all);
        System.out.println(all);
        return "mainPage/client";
    }

    @GetMapping(value = "/dashboard")
    public String dashBoard(){
        return "mainPage/dashboard";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id){
        clientRepository.deleteById(id);
        return "redirect:/info/getClient";
    }
    @GetMapping(value = "/toEdit/{id}")
    public String redirectToEdit(@PathVariable("id") Integer id, Model model){
        Client client = clientRepository.findById(id).get();
        model.addAttribute("client", client);
        return "mainPage/edit";
    }
    @PutMapping(value = "/editClient")
    public String editClient(Client client){
        System.out.println(client);
        clientRepository.save(client);
        return "redirect:/info/getClient";
    }
}
