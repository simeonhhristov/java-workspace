package providers;

import services.Cipherable;

import java.util.HashMap;
import java.util.Map;

public class CipherGenerator {

    public static Result countDistinct(Cipherable cipher, int seed) {
        char[] randomSymbols = cipher.getSecretChars(seed);
        int symbolCount = 0;
        boolean unique;
        Map<Character, Boolean> encounteredChars = new HashMap<>();

        for (int i = 0; i < randomSymbols.length; i++) {
            if(encounteredChars.containsKey(randomSymbols[i]))
            {
                continue;
            }

            encounteredChars.put(randomSymbols[i], true);
            symbolCount++;
        }

        return new Result(randomSymbols, symbolCount);
    }
}
