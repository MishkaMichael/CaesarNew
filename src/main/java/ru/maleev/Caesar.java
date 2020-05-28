package ru.maleev;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Caesar {               // программа реализует шифр Цезаря - сдвиг всех алфавитных символов строки на определенное число символов вправо

    static final HashMap<Character, AlphabetSymbol> SYMBOL_HASH_MAP = createSymbolHashMap();

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

    public static HashMap<Character, AlphabetSymbol> createSymbolHashMap () {
        HashMap<Character, AlphabetSymbol> symbolHashMap = new HashMap<>();
        for (List<Character> alp: Alphabet.all) {
            for (int i = 0; i < alp.size(); i++) {
                symbolHashMap.put(alp.get(i), new AlphabetSymbol (alp.get(i), i, alp));
            }
        }
        return symbolHashMap;
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
        if (SYMBOL_HASH_MAP.containsKey(ch)) {
            int index = SYMBOL_HASH_MAP.get(ch).getIndex();
            List<Character> alphabet = SYMBOL_HASH_MAP.get(ch).getAlphabet();
            int newIndex = (index + key) % alphabet.size();
            return alphabet.get(newIndex);
        }
        return ch;
    }

    private static char decryptChar(int key, char ch) {
        if (SYMBOL_HASH_MAP.containsKey(ch)) {
            int index = SYMBOL_HASH_MAP.get(ch).getIndex();
            List<Character> alphabet = SYMBOL_HASH_MAP.get(ch).getAlphabet();
            int newIndex = index - key % alphabet.size();
            if (newIndex < 0) newIndex = alphabet.size() - (key % alphabet.size() - index);
            return alphabet.get(newIndex);
        }
        return ch;
    }
}
