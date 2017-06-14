package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Spittle;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/12.
 */
@Controller
@RequestMapping("/restfulClient")
public class RestfulClientController {

    @RequestMapping("/old")
    public String old(Model model) {
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://127.0.0.1:8080/restful/get?id=1");
        get.setHeader("Accept", "application/json");
        try {
            HttpResponse response = client.execute(get);
            org.apache.http.HttpEntity entity = response.getEntity();
            ObjectMapper mapper = new ObjectMapper();
            Spittle spittle = mapper.readValue(entity.getContent(), Spittle.class);
            System.out.println(spittle);
            model.addAttribute("data", spittle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "restfulClient";
    }

    @RequestMapping("/getObject")
    public String getObject(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Spittle spittle = restTemplate.getForObject("http://127.0.0.1:8080/restful/get?id={id}",
                Spittle.class, 1);
        model.addAttribute("data", spittle);
        return "restfulClient";
    }

    @RequestMapping("/getEntity")
    public String getEntity(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity entity = restTemplate.getForEntity("http://127.0.0.1:8080/restful/get?id={id}",
                Spittle.class, 1);
        System.out.println(entity.getHeaders().getContentType());
        model.addAttribute("data", entity.getBody());
        return "restfulClient";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Spittle spittle = new Spittle();
        spittle.setMessage("ccc");
        spittle.setTime(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Spittle> entity = new HttpEntity<Spittle>(spittle, headers);
        restTemplate.put("http://127.0.0.1:8080/restful/update/{id}",
                entity, 1);
        return "restfulClient";
    }

    @RequestMapping("/delete")
    public String delete(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://127.0.0.1:8080/restful/delete/{id}", 1);
        return "restfulClient";
    }

    @RequestMapping("/postForObject")
    public String postForObject(Model model) {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle();
        spittle.setId(2L);
        spittle.setMessage("ccc");
        spittle.setTime(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Spittle> httpEntity = new HttpEntity<>(spittle, headers);

        Spittle response = template.postForObject("http://127.0.0.1:8080/restful/create", httpEntity, Spittle.class);
        model.addAttribute("data", response);
        return "restfulClient";
    }

    @RequestMapping("/postForEntity")
    public String postForEntity(Model model) {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle();
        spittle.setId(2L);
        spittle.setMessage("ccc");
        spittle.setTime(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Spittle> httpEntity = new HttpEntity<>(spittle, headers);

        ResponseEntity response = template.postForEntity("http://127.0.0.1:8080/restful/create", httpEntity, Spittle.class);
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders().getLocation());
        model.addAttribute("data", response.getBody());
        return "restfulClient";
    }

    @RequestMapping("/postForLocation")
    public String postForLocation(Model model) {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle();
        spittle.setId(2L);
        spittle.setMessage("ccc");
        spittle.setTime(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Spittle> httpEntity = new HttpEntity<>(spittle, headers);

        URI uri = template.postForLocation("http://127.0.0.1:8080/restful/create", httpEntity, Spittle.class);
        System.out.println(uri);
        return "restfulClient";
    }

    @RequestMapping("/exchange")
    public String exchange(Model model) {
        RestTemplate template = new RestTemplate();
        Spittle spittle = new Spittle();
        spittle.setId(2L);
        spittle.setMessage("ccc");
        spittle.setTime(new Date());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Spittle> httpEntity = new HttpEntity<>(spittle, headers);

        ResponseEntity responseEntity = template.exchange("http://127.0.0.1:8080/restful/create",
                HttpMethod.POST, httpEntity, Spittle.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getHeaders().getLocation());
        model.addAttribute("data", responseEntity.getBody());
        return "restfulClient";
    }
}
