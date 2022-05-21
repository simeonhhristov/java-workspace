package model;

public class DerivedClass extends BaseClass {

    @Override
    public void method() {
        System.out.println("Method executed.");
    }

    public static void callMethodFromBase(BaseClass baseClass) {
        DerivedClass derivedClass = (DerivedClass) baseClass;
        derivedClass.method();

    }

}
