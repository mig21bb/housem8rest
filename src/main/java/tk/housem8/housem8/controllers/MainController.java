/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.repos.MateRepository;

/**
 *
 * @author Administrador
 */
@Controller
public class MainController {
    
    @Autowired
    MateRepository mateRepository;

    //@RequestMapping()
    public String index(HttpSession httpSession, Model model) {

        String response = "login successful";
        Mate mate = new Mate();
        try {

            SecurityContextImpl secContext = (SecurityContextImpl) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
            if (secContext != null) {
                User user = (User) secContext.getAuthentication().getPrincipal();

                mate = (Mate) mateRepository.findByEmail(user.getUsername());
                response="login incorrect";
            }else{
                mate = (Mate) mateRepository.findByEmail("user@example.com");
            }

            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    //@RequestMapping("/login")
    public String logPage(Model model) {

        try {
            Mate mate = (Mate) mateRepository.findByEmail("user@example.com");

            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";

    }

    @RequestMapping("/singup")
    public String singUpPage(Model model) {

        return "singup";

    }
    /*
    @RequestMapping("/logIn")
    public String logIn( Model model, String user, String Password) {
        
        System.out.println("Logging in");
        
        return "logPage";
    }
     */
    
}
