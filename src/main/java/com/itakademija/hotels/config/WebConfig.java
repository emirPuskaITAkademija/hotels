package com.itakademija.hotels.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;


/**
 * Ovaj filter neće dozvoliti pristup Controller metodama sve dok ne odradi intervenciju nad
 * HTTP Request koji je došao na Spring Backend App.
 *
 * Šta će uraditi ?
 * 1. Pogledaće da li HTTP POST request sadrži
 * <input type="hidden" th:if="${country.id != null}" name="_method" value="put"/>
 * 2. Ukoliko sadrži _method sa value = PUT umjesto da gađamo metodu koja odgovara na POST
 *    ovaj filter će nas preusmjeriti na metodu koja odgovara na PUT zahtjev
 */
@Configuration
public class WebConfig {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
