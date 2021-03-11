package top.uninut.core.practice.design.proxy.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoInjection {
    public static Object getBean(Object object){
        try{
            Field[] fs = object.getClass().getDeclaredFields();
            for(Field f:fs){
                Seven s = f.getAnnotation(Seven.class);
                if(s != null){
                    System.err.println("注入 " + f.getName() + " 属性" + "\t\t" + s.value());
                    object.getClass().getMethod("set"+f.getName().substring(0,1).toUpperCase()
                    +f.getName().substring(1),new Class<?>[]{String.class})
                            .invoke(object,s.value());
                }
            }
            Method[] ms = object.getClass().getDeclaredMethods();
            for(Method m:ms){
                Seven s = m.getAnnotation(Seven.class);
                if(s != null){
                    System.err.println("注入 " + m.getName() + " 方法注解" + "\t" + s.property());
                    m.invoke(object, s.property());// 通过方法注入注解的值
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
}
