package com.WEATHER.REST_API1.Entity;

import lombok.Data;

@Data
public class Entity
{
    public Entity () {
        System.out.println ("*Entity Invoked*");
    }

    private Integer ID;

    private String NAME;

    private String Subscription;
}
