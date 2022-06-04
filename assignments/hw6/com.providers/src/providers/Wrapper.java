package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper() {
        setSize(1);
    }

    public Wrapper(int size) {
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new RuntimeException("invalid size");
        }
        this.size = size;
    }

    public class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random(seed);
            char[] symbols = new char[size];

            for (int i = 0; i < symbols.length; i++) {
                symbols[i] = (char) (rand.nextInt(26) + 65);
            }

            return symbols;
        }
    }

    public class FixedSelection implements Cipherable {
        @Override
        public char[] getSecretChars(int seed) {
            Random rand = new Random(seed);
            int randIdx;

            char[] result = new char[size];

            char[] randomGeneratedSymbols = new char[seed];

            for (int i = 0; i < randomGeneratedSymbols.length; i++) {
                randomGeneratedSymbols[i] = (char)(rand.nextInt(26) + 65);
            }

            for (int i = 0; i < result.length; i++) {
                randIdx = rand.nextInt(seed);
                result[i] = randomGeneratedSymbols[randIdx];
            }
            return result;
        }
    }

    public Cipherable makeFixedRandom() {return new FixedSelection();}
    public Cipherable makeFixedSelection() {return new FixedRandom();}

}
