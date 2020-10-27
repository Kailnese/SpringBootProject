package com.kailnese.controller;


import com.kailnese.bean.Client;
import com.kailnese.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){
        Client clientByUsername = clientRepository.findClientByUsername(username);
        if(clientByUsername != null && clientByUsername.getPassword().equals(password)){
//            request.getSession().setAttribute("user", username);
            session.setAttribute("user", username);
            return "redirect:/dashboard";
        }
        model.addAttribute("notExist", "The username is not exist or password incorrect");
//        request.setAttribute("notExist", "The username is not exist or password incorrect");
        return "/login";
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String login(Client client, Model model){
        List<Client> clients = clientRepository.findAll();
        for(Client temp: clients){
            if(temp.getUsername().equals(client.getUsername())){
//                request.setAttribute("error", "Username already taken, please try another one");
//                request.setAttribute("clientTemp", client);
                model.addAttribute("clientTemp", client);
                model.addAttribute("error", "Username already taken, please try another one");
                return "/registration";
            }
        }
        clientRepository.save(client);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
