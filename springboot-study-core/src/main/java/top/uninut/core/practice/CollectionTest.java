package top.uninut.core.practice;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionTest {

    public static void testLinkedList(){
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }

    public static void testArray(){
        Queue queue = new LinkedList();
//        Array array = Array.newInstance(Integer.class,10);
    }

    public static void testQueue(){
        Queue queue = new LinkedBlockingQueue();
    }

    public static void testMap(){
        Map<String ,String> map;
        Collection collection;
        List list;
        Queue queue;
        Set set;
        Vector vector;
    }

    public static void testInterface(){
        List list = new ArrayList();
        list.add("a");
        list.add("d");
        list.add("c");
        String s = JSON.toJSONString(list);

        List copy = JSON.parseObject(s,List.class);
        System.out.println(copy.get(0));
        System.out.println(copy.get(1));
        System.out.println(copy.get(2));
    }

    public static void main(String[] args) {
        testInterface();
    }
}
