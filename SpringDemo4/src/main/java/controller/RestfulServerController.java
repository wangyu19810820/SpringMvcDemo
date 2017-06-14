package controller;

import com.sun.jndi.toolkit.url.Uri;
import model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import service.SpittleService;

import java.net.URI;
import java.util.List;

/**
 * Created by admin on 2017/6/11.
 */
@RestController
@RequestMapping("/restful")
public class RestfulServerController {

    private SpittleService service;

    @Autowired
    public RestfulServerController(SpittleService service) {
        this.service = service;
    }

    @RequestMapping(value = "list", produces = "application/json")
    public List<Spittle> list() {
        return service.findSpittle(Long.MAX_VALUE, 20);
    }

    @RequestMapping(value = "add", consumes = "application/json")
    public List<Spittle> add(@RequestBody Spittle spittle) {
        System.out.println(spittle);
        return service.findSpittle(Long.MAX_VALUE, 20);
    }

    @RequestMapping(value = "get")
    @ResponseBody
    public Spittle get(int id) {
        if (id == 0) {
            throw new SpitteNotFoundException();
        } else {

            return new Spittle((long)id, "aaa");
        }
    }

    @RequestMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<Spittle> create(@RequestBody Spittle spittle, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        URI uri = builder.path("/restful/get").query("id=" + spittle.getId()).build().toUri();
        headers.setLocation(uri);
        return new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}")
    public void update(@RequestBody Spittle spittle, @PathVariable long id) {
        System.out.println(id);
        System.out.println(spittle);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        System.out.println(id);
    }

    @ExceptionHandler(SpitteNotFoundException.class)
    private ResponseEntity spittleNotFound() {
        return new ResponseEntity(new Error(1, "spittle not found"), HttpStatus.OK);
    }
}
