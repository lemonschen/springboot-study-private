package top.uninut.core.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OtherTest {

    public static void main(String[] args) {
        test23();
    }

    public static void test23(){
        List<String> list = new ArrayList<>();
        list.add("a");
        Collection<String> collection = Collections.unmodifiableCollection(list);
        addElement(collection);
    }

    public static void addElement(Collection<String> collection){
        collection.add("s");
    }


    public static void test22(){
        String s = "abdcdda2123123s";

        s = s.replaceAll("/d/g","a");
        System.out.println(s);
    }

    public static int a = 1;

    public static void test21(){
        System.out.println(a);
    }

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
}
