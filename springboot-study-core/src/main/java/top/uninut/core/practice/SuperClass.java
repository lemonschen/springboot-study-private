package top.uninut.core.practice;

public class SuperClass {

    public SuperClass(){
        System.out.println("super class constructor");
    }

    public SuperClass(String str){
        System.out.println("super class constructor args 1");
    }

    public String str0 = "public instance field";

    protected String str1 = "protected instance field";

    String str2 = "friendly instance field";

    private String str3 = "private instance field";

    public static String str4 = "public static field";

    protected static String str5 = "protected static field";

    static String str6 = "friendly static field";

    private String str7 = "private static field";

    {
        System.out.println("instance code block");
    }

    static {
        System.out.println("static code block");
    }

    public void method0(){
        System.out.println("public instance method");
    }

    protected void method1(){
        System.out.println("protected instance method");
    }

    void method2(){
        System.out.println("friendly instance method");
    }

    private void method3(){
        System.out.println("private instance method");
    }

    public static void method4(){
        System.out.println("public static method");
    }

    protected static void method5(){
        System.out.println("protected static method");
    }

    static void method6(){
        System.out.println("friendly static method");
    }

    private static void method7(){
        System.out.println("private static method");
    }
}
