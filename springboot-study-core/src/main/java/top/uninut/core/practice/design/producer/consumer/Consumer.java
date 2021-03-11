package top.uninut.core.practice.design.producer.consumer;

public class Consumer implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Shop shop = Shop.getInstance();
                Apple apple = shop.sellApple();
                if(apple != null){
                    System.out.println("消费一个苹果 "+apple.productionID());
                }
                Banana banana = shop.sellBanana();
                if(banana != null){
                    System.out.println("消费一个香蕉 "+banana.productionID());
                }
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
