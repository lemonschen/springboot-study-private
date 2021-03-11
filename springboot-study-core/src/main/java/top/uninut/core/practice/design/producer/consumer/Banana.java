package top.uninut.core.practice.design.producer.consumer;

import java.util.UUID;

public class Banana implements Fruit{
    @Override
    public void name() {
        System.out.println("香蕉");
    }

    @Override
    public String productionID() {
        return "BANANA"+ UUID.randomUUID().toString().toUpperCase();
    }

    @Override
    public void price() {
        System.out.println("3元");
    }
}
