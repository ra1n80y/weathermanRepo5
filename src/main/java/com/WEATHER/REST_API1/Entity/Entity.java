package com.WEATHER.REST_API1.Entity;

import lombok.Data;

@Data
public class Entity
{
    private Integer ID;

    private String NAME;

    private String Subscription;

    public Entity()
    {
        System.out.println ("*Entity Invoked*");
    }
}
