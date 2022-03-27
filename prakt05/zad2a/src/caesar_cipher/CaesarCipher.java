package caesar_cipher;

public class CaesarCipher {

    private int shiftLength;

    public CaesarCipher(int shiftLength) {
        setShiftLength(shiftLength);
    }
    public CaesarCipher() {
        shiftLength = 3;
    }


    private static final int CAPITAL_A_CODE = 65;

    public int getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(int shiftLength) {
        if (shiftLength > 0 && shiftLength <= 26){
            this.shiftLength = shiftLength;
        } else {
            this.shiftLength = 3;
        }
    }

    public String encrypt(String plainText) {
        char[] letters = plainText.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int letterCode = letters[i];
            letters[i] = (char)((letterCode + shiftLength - CAPITAL_A_CODE) % 26 + CAPITAL_A_CODE);
        }
        return new String(letters);
    }

    public String decrypt(String encryptedText){
        char[] letters = encryptedText.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int letterCode = letters[i];
            letters[i] = (char)((letterCode - shiftLength - CAPITAL_A_CODE + 26) % 26 + CAPITAL_A_CODE);
        }
        return new String(letters);
    }
}
