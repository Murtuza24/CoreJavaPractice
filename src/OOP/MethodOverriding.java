package OOP;

class Parent{
    public void doSomething(){
        System.out.println("Im Parent");
    }
}

class Child1 extends Parent{
    public void doSomething(){
        System.out.println("Im Child 1.");
    }
}

class Child2 extends Parent{
    public void doSomething(){
        System.out.println("Im Child 2.");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Parent parent;
        parent = new Parent();
        parent.doSomething();

        parent = new Child1();
        parent.doSomething();

        parent = new Child2();
        parent.doSomething();


    }

}
