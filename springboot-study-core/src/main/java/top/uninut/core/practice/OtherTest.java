package top.uninut.core.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class OtherTest {

    private static void testLoop(){
        int i=0;
        for(;;){
            i++;
            System.out.println(i);
            if(i>10)break;
        }
    }

    private static void testAtomic(){
        AtomicInteger i = new AtomicInteger(0);
        System.out.println(i.get());
        i.incrementAndGet();
        System.out.println(i.get());
        i.getAndIncrement();
        System.out.println(i.get());
        i.decrementAndGet();
        System.out.println(i.get());
        i.getAndDecrement();
        System.out.println(i.get());
        System.out.println("--------");
        System.out.println(i.getAndDecrement());
        System.out.println(i.decrementAndGet());
        System.out.println(i.getAndIncrement());
        System.out.println(i.incrementAndGet());
    }

    public static void main(String[] args) {
        testAtomic();
    }
}
