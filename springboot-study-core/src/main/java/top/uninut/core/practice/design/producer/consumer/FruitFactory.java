package top.uninut.core.practice.design.producer.consumer;

public class FruitFactory {
    private static FruitFactory factory = null;
    private FruitFactory(){}
    public static FruitFactory getInstance(){
        if(factory == null){
            synchronized (FruitFactory.class){
                if(factory == null){
                    factory = new FruitFactory();
                }
            }
        }
        return factory;
    }

    public Fruit produce(String name){
        if("apple".equals(name)){
            return new Apple();
        }else if("banana".equals(name)){
            return new Banana();
        }
        return null;
    }
}
