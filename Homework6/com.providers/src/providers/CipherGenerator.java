package providers;

import services.Cipherable;

public class CipherGenerator {

    public static Result countDistinct(Cipherable cipher, int seed) {

        char[] secretCharsArr = cipher.getSecretChars(seed);

        if(secretCharsArr.length == 0)
        {
            return new Result(secretCharsArr, 0);
        }

        if(secretCharsArr.length == 1)
        {
            return new Result(secretCharsArr, 1);
        }

        int cnt = 0;
        int currIdx = 0;
        int size = secretCharsArr.length;

        while(size > 0) {
            int i = 0;
            while(i < secretCharsArr.length) {
                char curr = secretCharsArr[currIdx];


                if(curr == secretCharsArr[i] && currIdx != i) {
                    cnt++;
                    break;
                }else {
                    i++;
                }
            }
            currIdx++;
            size--;
        }

        return new Result(secretCharsArr, secretCharsArr.length - cnt);
    }

}
