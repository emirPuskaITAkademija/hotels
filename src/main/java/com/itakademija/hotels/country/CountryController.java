package com.itakademija.hotels.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country")
    public String showCountries(Model model) {
        List<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        model.addAttribute("country", new Country());
        return "country";
    }

    @PostMapping("/country")
    public String saveCountry(@ModelAttribute("country") Country country) {
        countryRepository.save(country);
        return "redirect:/country";
    }

//    @PutMapping("/country")
//    public String updateCountryPut(@ModelAttribute Country country) {
//        countryRepository.save(country);
//        return "redirect:/country";
//    }

    @PatchMapping("/country")
    public String updateCountryPatch(@ModelAttribute Country country) {
        countryRepository.save(country);
        return "redirect:/country";
    }


    @GetMapping("/country/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country ID: " + id));
        model.addAttribute("country", country);
        model.addAttribute("countries", countryRepository.findAll());
        return "country";
    }

    @GetMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
        return "redirect:/country";
    }
}
