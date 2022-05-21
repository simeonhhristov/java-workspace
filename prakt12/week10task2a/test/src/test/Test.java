package test;

import model.BaseClass;
import model.DerivedClass;

public class Test {
    public static void main(String[] args) {
        DerivedClass derivedClass = new DerivedClass();
        BaseClass baseClass = derivedClass;

        baseClass.firstMethod();
    }
}
