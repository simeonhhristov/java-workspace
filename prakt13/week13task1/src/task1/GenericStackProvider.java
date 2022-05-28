package task1;

import java.util.Arrays;

public class GenericStackProvider {

    private class GenericStack<E> {

        private E[] array = (E[]) new Object[10];
        private int topIndex = 0;

        public int getSize() {
            return topIndex;
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            }
            return array[getSize() - 1];
        }

        public void push(E o) {
            if (topIndex == array.length) {
                expandArray();
            }
            array[topIndex++] = o;
        }

        public E pop() {
            if (isEmpty()) {
                return null;
            }
            E o = peek();
            array[getSize() - 1] = null;
            topIndex--;
            return o;
        }

        public boolean isEmpty() {
            return topIndex == 0;
        }

        private void expandArray() {
            E[] copy = (E[]) new Object[array.length * 2];

            System.arraycopy(array, 0, copy, 0, array.length);
            array = copy;
        }

        @Override
        public String toString() {
            return "stack: " + Arrays.toString(array);
        }
    }

    public <T> GenericStack<T> getGenericStack() {
        return new GenericStack<>();
    }

    public static void main(String[] args) {
        GenericStackProvider genericStackProvider = new GenericStackProvider();
        GenericStack<Integer> integerGenericStack = genericStackProvider.getGenericStack();

        for (int i = 0; i < 10; i++) {
            integerGenericStack.push(i);

        }

        System.out.println(integerGenericStack.toString());

        GenericStack<String> textStack = genericStackProvider.getGenericStack();

        for (int i = 0; i < 10; i++) {
            textStack.push("a" +  i);
        }

        System.out.println(textStack.toString());
    }
}
