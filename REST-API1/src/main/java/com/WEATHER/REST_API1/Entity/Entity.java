package com.WEATHER.REST_API1.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Entity
{
    private Integer ID;

    private String NAME;

    private String Subscription;

    public Entity(Integer ID,String NAME,String Subscription)
    {
        this.ID = ID;
        this.NAME = NAME;
        this.Subscription = Subscription;
    }

    public Entity()
    {
        System.out.println ("*Entity Invoked*");
    }
}
