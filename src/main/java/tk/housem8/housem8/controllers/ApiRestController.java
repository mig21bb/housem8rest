/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.repos.MateRepository;

/**
 *
 * @author Administrador
 */
@RestController
public class ApiRestController {
    
    @Autowired
    MateRepository mateRepository;
    /*
    @RequestMapping({ "/", "/login"})    
    public String index(HttpSession httpSession, Model model) {

        String response = "{login: error}";
        Mate mate = new Mate();
        try {

            SecurityContextImpl secContext = (SecurityContextImpl) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
            if (secContext != null) {
                User user = (User) secContext.getAuthentication().getPrincipal();

                //mate = (Mate) mateRepository.findByEmail(user.getUsername());
                response="{login: success}";
            }

            //model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    */
}
