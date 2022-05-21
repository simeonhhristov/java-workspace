package zad3a;

public class OuterClassB {
    public class InnerClassB extends OuterClassA.InnerClassA {

        public InnerClassB(String myName) {
            super(myName);
        }

        public InnerClassB() {
            super("InnerClassB");
        }

        @Override
        public String toString() {
            return "InnerClassB{}" + getMyName();
        }
    }

    public InnerClassB getInnerClassB(OuterClassA a, String s) {
        return new InnerClassB(s);
    }

    @Override
    public String toString() {
        return "OuterClassB";
    }
}
