package ru.maleev;

import java.util.List;
import java.util.Scanner;

public class Caesar {               // программа реализует шифр Цезаря - сдвиг всех алфавитных символов строки на определенное число символов вправо

    public static void main(String[] args) {
        int testKey = 34;
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String encryptString = encrypt(s, testKey);
        System.out.println("Encrypt:" + encryptString);
        String decryptString = decrypt(s, testKey);
        System.out.println("Decrypt:" + decryptString);
    }

    public static String encrypt(String s, int key) {  // метод шифрования
        char[] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch : charArray) {
            ch = encryptChar(key, ch);
            resultString.append(ch);
        }
        return resultString.toString();
    }

    public static String decrypt(String s, int key) {  // метод расшифровщика шифра
        char[] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch : charArray) {
            ch = decryptChar (key, ch);
            resultString.append(ch);
        }
        return resultString.toString();
    }

    private static char encryptChar(int key, char ch) {
        for (List<Character> alphabet: Alphabet.all) {
            if (alphabet.contains(ch)) return alphabet.get((alphabet.indexOf(ch) + key) % alphabet.size());
        }
        return ch;
    }

    private static char decryptChar(int key, char ch) {
        for (List<Character> alphabet: Alphabet.all) {
            if (alphabet.contains(ch)) {
                if ((alphabet.indexOf(ch) - key % alphabet.size()) < 0) {
                    ch = alphabet.get(alphabet.size() - (key % alphabet.size() - alphabet.indexOf(ch)));
                } else ch = alphabet.get(alphabet.indexOf(ch) - key % alphabet.size());
                return ch;
            }
        }
        return ch;
    }
}
