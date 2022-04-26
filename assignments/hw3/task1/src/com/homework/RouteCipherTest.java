package com.homework;

public class RouteCipherTest {
    public static void main(String[] args) {
        RouteCipher cipher = new RouteCipher(10);

        System.out.println(cipher.encrypt("ABORT THE MISSION YOU HAVE BEEN SPOTTED"));
        System.out.println(cipher.decrypt(" OEVOI TROBA MOUENTTEDPEAYSEHTIN   SBH S"));
    }
}
