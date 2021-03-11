package top.uninut.core.practice.design.producer.consumer;

import java.util.UUID;

public class Apple implements Fruit{
    @Override
    public void name() {
        System.out.println("苹果");
    }

    @Override
    public String productionID() {
        return "APPLE"+ UUID.randomUUID().toString().toUpperCase();
    }

    @Override
    public void price() {
        System.out.println("5元");
    }
}
