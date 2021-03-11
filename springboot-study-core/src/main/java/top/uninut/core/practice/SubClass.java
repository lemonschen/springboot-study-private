package top.uninut.core.practice;

public class SubClass extends SuperClass {

    public SubClass(){
        System.out.println("sub class constructor");
    }

    public SubClass(String args){
        System.out.println("sub class constructor args 1");
    }

    public static void method4(){
        System.out.println("sub public static method");
    }

    public void method0(){
        System.out.println("sub public instance method");
    }

    public static void main(String[] args) {
        System.out.println("------------------");

        SubClass subClass;

        System.out.println("------------------");

        subClass = new SubClass();

        System.out.println("-------------------");

        subClass = new SubClass("");

        System.out.println("------------------");

        System.out.println(subClass.str0);

        System.out.println("------------------");

        subClass.method0();

        System.out.println("------------------");

        SubClass.method4();
    }
}
