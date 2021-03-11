package top.uninut.core.practice.design.proxy.aop;

public class DogImp implements AnimalInterface {

    @Seven(value = "Lumia")
    private String name;

    private String property;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void say() {
        System.out.println("小狗：汪汪汪......");
    }

    @Override
    public void getProperty() {
        System.out.println(this.name + " = "+this.property);
    }

    @Override
    @Seven("水陆两栖动物")
    public void setProperty(String property) {
        this.property = property;
    }
}
