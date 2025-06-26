package com.itakademija.hotels.country.town;

import com.itakademija.hotels.country.Country;
import com.itakademija.hotels.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String addTown(@ModelAttribute("town") Town town) {
        townRepository.save(town);
        return "redirect:/town";
    }

    //BAZNI_URL/{id}
    @GetMapping("/{id}")
    public String showTownEditForm(@PathVariable Long id, Model model) {
        Town townToEdit = townRepository.findById(id).orElse(new Town());
        model.addAttribute("town", townToEdit);
        model.addAttribute("towns", townRepository.findAll());
        model.addAttribute("countries", countryRepository.findAll());
        return "town";
    }

    @PutMapping
    public String updateTown(@ModelAttribute Town town) {
        townRepository.save(town);
        return "redirect:/town";
    }
}
