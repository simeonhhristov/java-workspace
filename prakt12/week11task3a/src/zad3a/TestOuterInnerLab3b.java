package zad3a;

public class TestOuterInnerLab3b {
    public static void main(String[] args) {
        OuterClassA outerClassA = new OuterClassA();
        OuterClassB outerClassB = new OuterClassB();
        OuterClassA.InnerClassA innerClassA = outerClassA.getInnerClassA("InnerClassA");
        OuterClassB.InnerClassB innerClassB  =outerClassB.getInnerClassB(outerClassA,"innerClassB");

        System.out.println(outerClassA.toString());
        System.out.println(outerClassB.toString());
        System.out.println(innerClassA.toString());
        System.out.println(innerClassB.toString());

    }
}
