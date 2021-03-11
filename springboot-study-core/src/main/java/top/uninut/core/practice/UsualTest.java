package top.uninut.core.practice;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UsualTest {
    public static void main(String[] args) {
        test7();
    }

    public static void test7(){
        new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("["+Thread.currentThread().getName()+"] "+i);
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<1000;i++){
                System.out.println("["+Thread.currentThread().getName()+"] "+i);
            }
        }).start();
    }

    @Data
    public class AC{
        private String name;
        private int age;
        public AC(String name,int age){
            this.name = name;
            this.age = age;
        }

        public void m(){
            System.out.println("inner method");
        }

        public String toString(){
            return JSON.toJSONString(this);
        }
    }

    public static void test6() {
        try {
            Class clazz = Class.forName("top.uninut.core.practice.UsualTest$AC");
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor constructor:constructors){
                System.out.println(JSON.toJSONString(constructor.getParameterTypes()));
            }
            Class clazz1 = Class.forName("top.uninut.core.practice.UsualTest");
            Constructor constructor = clazz.getConstructor(clazz1,String.class,int.class);
//            Constructor constructor = clazz.getConstructor(Class.forName("top.uninut.core.practice.UsualTest"),String.class,int.class);
            Object object = constructor.newInstance(clazz1.newInstance(),"new char[]{'A','B'}",123);
            Method method = clazz.getMethod("m");
            method.invoke(object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void test1(){
        String a = "a";
        String b = new String("a");
        System.out.println(a == b);
    }
    public static void test2(){
        InnerClass.InnerClassOne a = new InnerClass().new InnerClassOne();
        a.m();
        InnerClass.InnerClassTwo.n();
        InnerClass.InnerClassTwo b = new InnerClass.InnerClassTwo();
        b.m();
    }

    public static void test3(){
        A a = new UsualTest().new B();
        a.m();

        Comparator c;
        Comparable d;
    }

    public class A{
        private void m(){
            System.out.println("Am");
        }
    }

    public class B extends A{
        public int m(){
            System.out.println("Bm");
            return 1;
        };
    }

    public static void test5(){
        Iterator iterator;
        Map map;
        Collection collection;
        List list;
        Set set;
        Queue queue;
        ArrayList arrayList;
        LinkedList linkedList;
        Vector vector;
        HashSet hashSet;
        LinkedHashSet linkedHashSet;
        TreeSet treeSet;
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap;
        TreeMap treeMap;
        Set set1 = hashMap.entrySet();
        Iterator<Map.Entry> it = set1.iterator();
        if(it.hasNext()){
            Map.Entry entry = it.next();
            entry.getKey();
            entry.getValue();
        }
        Hashtable hashtable;

        ConcurrentHashMap concurrentHashMap;

    }
}
