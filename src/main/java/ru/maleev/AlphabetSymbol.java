package ru.maleev;

import java.util.List;

public class AlphabetSymbol {
        char symbol;
        int index;
        List<Character> alphabet;

    public AlphabetSymbol(char symbol, int index, List<Character> alphabet) {
        this.symbol = symbol;
        this.index = index;
        this.alphabet = alphabet;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }
}
