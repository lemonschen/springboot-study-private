package top.uninut.core.practice.design.proxy.simple;

public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("hello man");
    }
}
