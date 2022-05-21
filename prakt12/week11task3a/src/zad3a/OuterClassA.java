package zad3a;

public class OuterClassA {
    public static class InnerClassA {
        private String myName;

        public InnerClassA(String myName) {
            setMyName(myName);
        }

        public String getMyName() {
            return myName;
        }

        public void setMyName(String myName) {
            if (myName == null) {
                this.myName = "myName";
                return;
            }

            this.myName = myName;
        }

        @Override
        public String toString() {
            return "InnerClassA{" +
                    "myName='" + myName + '\'' +
                    '}';
        }
    }

    public InnerClassA getInnerClassA(String s) {
        return new InnerClassA(s);
    }

    @Override
    public String toString() {
        return "OuterClassA{}";
    }
}
