package model;

public class DerivedClass extends BaseClass {
    private int variable = 1;



    @Override
    public void print() {
        System.out.println(variable);
    }
}
