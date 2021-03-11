package top.uninut.core.practice.design.producer.consumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Shop {
    private static Shop shop = null;
    private Shop(){}
    public static Shop getInstance(){
        if(shop == null){
            synchronized (Shop.class){
                if(shop == null){
                    shop = new Shop();
                }
            }
        }
        return shop;
    }

    public static final int MIN_FRUIT_QUANTITY = 20;

    private Queue<Apple> apples = new ConcurrentLinkedQueue<>();
    private Queue<Banana> bananas = new ConcurrentLinkedQueue<>();

    public void addApple(Apple apple){
        apples.offer(apple);
    }
    public Apple sellApple(){
        return apples.poll();
    }

    public void addBanana(Banana banana){
        bananas.offer(banana);
    }
    public Banana sellBanana(){
        return bananas.poll();
    }

    public int getAppleQuantity(){
        return apples.size();
    }

    public int getBananaQuantity(){
        return bananas.size();
    }

}
