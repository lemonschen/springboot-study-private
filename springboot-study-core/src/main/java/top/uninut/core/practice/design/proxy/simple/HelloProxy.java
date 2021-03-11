package top.uninut.core.practice.design.proxy.simple;

public class HelloProxy implements HelloInterface {
    private final HelloInterface helloInterface = new Hello();
    @Override
    public void sayHello() {
        System.out.println("Invoke sayHello");
        helloInterface.sayHello();
    }
}
