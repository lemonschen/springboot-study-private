package top.uninut.core.practice.design.proxy.dynamic;

import top.uninut.core.practice.design.proxy.simple.Hello;
import top.uninut.core.practice.design.proxy.simple.HelloInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic Proxy invoke method");
        method.invoke(object,args);
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface helloInterface = new Hello();
        InvocationHandler handler = new ProxyHandler(helloInterface);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(helloInterface.getClass().getClassLoader(),helloInterface.getClass().getInterfaces(),handler);
        proxyHello.sayHello();
    }
}
