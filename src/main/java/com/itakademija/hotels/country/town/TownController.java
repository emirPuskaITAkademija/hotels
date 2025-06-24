package com.itakademija.hotels.country.town;

import com.itakademija.hotels.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/town")
public class TownController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TownRepository townRepository;

    @GetMapping
    public String showTowns(Model model) {
        model.addAttribute("towns", townRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());
        model.addAttribute("town", new Town());
        return "town";
    }
}
