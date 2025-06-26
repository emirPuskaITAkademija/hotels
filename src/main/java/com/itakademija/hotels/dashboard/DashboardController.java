package com.itakademija.hotels.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    //http://localhost:8082/dashboard  GET -> ako nisam logovan
    // -> od Springa ću doživjeti redirect /login
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "dashboard";
    }
}
