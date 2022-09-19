package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cipherable makeFixedSelection() {
        return new FixedSelection();
    }

    public Cipherable makeFixedRandom() {
        return new FixedRandom();
    }

    private class FixedRandom implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            Random rnd = new Random();
            rnd.setSeed(seed);
            char[] secretCharsArr = new char[size];

            for(int i=0; i<secretCharsArr.length; i++) {
                char random = (char)(rnd.nextInt(26) + 'A');
                secretCharsArr[i] = random;
            }
            return secretCharsArr;
        }
    }

    private class FixedSelection implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            Random rnd = new Random(seed);

            char[] secretCharsArr = new char[seed];

            for (int i = 0; i < seed; i++)
            {
                secretCharsArr[i] = (char) (rnd.nextInt(26) + 'A');
            }

            char[] res = new char[size];

            for (int i = 0; i < size; i++)
            {
                res[i] = secretCharsArr[rnd.nextInt(seed)];
            }

            return res;
        }
    }
}
