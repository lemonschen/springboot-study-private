package top.uninut.core.practice.design.producer.consumer;

public class Producer implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Shop shop = Shop.getInstance();
                FruitFactory factory = FruitFactory.getInstance();
                int minFruitQuantity = Shop.MIN_FRUIT_QUANTITY;
                int appleQuantity = shop.getAppleQuantity();
                if(appleQuantity <= minFruitQuantity){
                    Fruit apple = factory.produce("apple");
                    shop.addApple((Apple)apple );
                    System.out.println("生产一个苹果 "+apple.productionID());
                }
                int bananaQuantity = shop.getBananaQuantity();
                if(bananaQuantity <= minFruitQuantity){
                    Fruit banana = factory.produce("banana");
                    shop.addBanana((Banana)banana);
                    System.out.println("生产一个香蕉 "+banana.productionID());
                }
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
