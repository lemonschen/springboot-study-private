package top.uninut.core.practice.design.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandle implements InvocationHandler {
    private AOPMethod method;
    private Object object;
    public AOPHandle(Object object,AOPMethod method){
        this.object = object;
        this.method = method;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret;
        if(this.method != null){
            this.method.before(proxy,method,args);
            ret = method.invoke(object,args);
            this.method.after(proxy,method,args);
        }else {
            System.out.println("invocation handler before");
            ret = method.invoke(object,args);
            System.out.println("invocation handler after");
        }
        return ret;
    }
}
