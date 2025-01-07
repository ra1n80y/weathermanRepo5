package com.WEATHER.REST_API1.Controller;

import com.WEATHER.REST_API1.Entity.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController//@Controller + @ResponseBody
@RequestMapping("Genesys")
public class RESTAPI1
{
    public RESTAPI1()
    {
        /*
        Request to Bean ratio is 1:1 for RestControllers,
        all requests in the same session use the same bean
        */
        System.out.println ("http://localhost:8080/Genesys/greeting");
        System.out.println ("http://localhost:8080/Genesys/msg");
        System.out.println ("http://localhost:8080/Genesys/json");
        System.out.println ("http://localhost:8080/Genesys/save");
    }

    @GetMapping("greeting")
    public ResponseEntity<String> RE()
    {
        LocalDateTime ldt = LocalDateTime.now ();
        int hour = ldt.getHour ();
        String body;

        if (hour<12)
            body="GOOD MORNING!";
        else if (hour<18)
            body="GOOD AFTERNOON!";
        else if (hour<21)
            body="GOOD EVENING!";
        else
            body="GOOD NIGHT!";

        System.out.println ("*Controller: 'RE' was called*");

        /*
        In B2B contexts,
        your controllers return this object instead of view file names
        */
        return new ResponseEntity<> (body, HttpStatus.OK);
    }

    @GetMapping("msg")
    public String MSG(@RequestParam(value = "name",required = false,defaultValue = "twan") String name)
    {
        //'required' attribute 'de-compulsifies' key-val pair typically required 2 access this endpoint
        String ss="Sup "+name+", wsg!";
        System.out.println ("*Controller 'MSG' was called*");
        return ss;
    }

    @GetMapping("json")
    public ResponseEntity<Entity>showEntity()
    {
        Entity entity = new Entity ();
        entity.setID (1);
        entity.setNAME ("Hakeem");
        entity.setSubscription ("Premium");
        return new ResponseEntity<> (entity,HttpStatus.OK);
    }

    @PostMapping("save")//@PostMapping sends data directly from client 2 server in the URL body not Header
    public ResponseEntity<String>SAVE(@RequestBody Entity entity)
    {
        //This controller type receives JSON data and converts it in2 a Java entity via @RequestBody
        System.out.println (entity);
        String ss="*DATA STORED*";
        return new ResponseEntity<> (ss,HttpStatus.OK);
    }
}
