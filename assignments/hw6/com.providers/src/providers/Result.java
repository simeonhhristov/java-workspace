package providers;

import java.util.Arrays;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        setChars(chars);
        setData(data);
    }

    public char[] getChars() {
        char[] tmp = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            tmp[i] = chars[i];
        }
        return tmp;
    }

    public void setChars(char[] chars) {
        if (chars == null) {
            throw new RuntimeException("Invalid array");
        }
        this.chars = chars;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");

        result.append("Data: ");
        result.append(data);

        for (char c : chars) {
            result.append(c).append(", ");
        }
        
        return result.toString();
    }
}
