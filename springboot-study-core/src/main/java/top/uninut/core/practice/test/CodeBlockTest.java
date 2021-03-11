package top.uninut.core.practice.test;

public class CodeBlockTest {
    ActionClass actionClass = new ActionClass();

    static ActionClass staticActionClass = new ActionClass();

    static {
        System.out.println("static代码块被执行");
        staticActionClass.instanceMethod();
        ActionClass.staticMethod();
    }

    {
        System.out.println("代码块被执行");
        actionClass.instanceMethod();
        ActionClass.staticMethod();
    }
}
