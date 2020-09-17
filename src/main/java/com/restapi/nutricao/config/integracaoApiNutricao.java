package com.restapi.nutricao.config;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class integracaoApiNutricao {

    private static final String HOST_NAME = "x-rapidapi-host";
    private static final String HOST_VALUE = "edamam-edamam-nutrition-analysis.p.rapidapi.com";
    private static final String KEY_NAME = "x-rapidapi-key";
    private static final String KEY_VALUE = "2cd6897d4fmshc78ed50d3c9d0d4p1a64c6jsn86d73865203f";

    public String consultarAlimentos(int quantidade, String tamanho, String nome) {
        try {
            HttpResponse<String> response = Unirest.get(HOST_VALUE + "/" +
                    "api/nutrition-data?ingr=" + quantidade + "%20" + tamanho + "%20" + nome + "")
                    .header(HOST_NAME, HOST_VALUE)
                    .header(KEY_NAME, KEY_VALUE)
                    .asString();
            return response.toString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
