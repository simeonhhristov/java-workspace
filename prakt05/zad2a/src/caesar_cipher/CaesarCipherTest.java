package caesar_cipher;

import java.util.Scanner;

public class CaesarCipherTest {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();

        Scanner input = new Scanner(System.in);

        System.out.print("1.Encrypt\n2.Decrypt\nEnter choice: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Enter Word: ");
            String plainText = input.nextLine();
            System.out.println("Encrypted Text: " + caesarCipher.encrypt(plainText));
        } else if (choice == 2) {
            System.out.print("Enter Word: ");
            String encryptedText = input.nextLine();
            System.out.println("Encrypted Text: " + caesarCipher.encrypt(encryptedText));
        }
    }
}
