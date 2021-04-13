package top.uninut.core.practice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiService {
    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()){
            Animal animal = iterator.next();
            animal.name();
        }
    }
}
