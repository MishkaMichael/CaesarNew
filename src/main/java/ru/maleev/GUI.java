package ru.maleev;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
    // this is FIELD)))
    static final JFrame FRAME = new JFrame("Caesar cipher");
    //если field static то он пишется с большых буквы всегда.
    // между словами "_", например THIS_IS_TEST_FIELD_STATIC
    static public void run() {
        //Создадим окно, настраиваем иконку, закрытие по крестику

        ImageIcon img = new ImageIcon("java.png");
        FRAME.setIconImage(img.getImage());
        FRAME.setDefaultCloseOperation(FRAME.EXIT_ON_CLOSE);

        //Создадим панели
        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        //Подписи
        JLabel labelInput = new JLabel("Исходная строка");
        JLabel labelOutput = new JLabel("Результат");
        JLabel labelKey = new JLabel("Ключ шифрования");
        JLabel labelTime = new JLabel("mc");

        //Текстовые поля
        JTextArea textInput = new JTextArea(1,20);
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);
        JTextArea textOutput = new JTextArea(1,20);
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        JTextField textKey = new JTextField(5);
        JTextField textTime = new JTextField(5);

        //Создадим кнопки
        JButton encrypt = new JButton("Зашифровать");
        JButton decrypt = new JButton("Расшифровать");
        JButton copyButton = new JButton("Скопировать в исходную");


        //Событие для кнопки "Зашифровать"
        encrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long startTime = System.currentTimeMillis();
                String string = textInput.getText();
                try {
                    int key = Integer.parseInt(textKey.getText());
                    if (key >= 0) {
                        String encryptedString = Caesar.encrypt(string, key);
                        textOutput.setText(encryptedString);
                        textTime.setText(String.valueOf(System.currentTimeMillis() - startTime));
                    } else
                        textOutput.setText("Введите неотрицательный ключ шифрования");
                }
                catch (NumberFormatException ex) {
                    textOutput.setText("Введите корректный ключ шифрования");
                    textKey.setText(null);
                }
            }
        });

        //Событие для кнопки "Расшифровать"
        decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long startTime = System.currentTimeMillis();
                String string = textInput.getText();
                try {
                    int key = Integer.parseInt(textKey.getText());
                    if (key >= 0) {
                        String decryptedString = Caesar.decrypt(string, key);
                        textOutput.setText(decryptedString);
                        textTime.setText(String.valueOf(System.currentTimeMillis() - startTime));
                    } else
                        textOutput.setText("Введите неотрицательный ключ шифрования");
                }
                catch (NumberFormatException ex) {
                    textOutput.setText("Введите корректный ключ шифрования");
                    textKey.setText(null);
                }
            }
        });

        //Событие для кнопки "Скопировать"
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textInput.setText(textOutput.getText());
            }
        });

        //Добавим панель прокрутки для текстовых полей
        JScrollPane scrollPaneInput = new JScrollPane(textInput);
        scrollPaneInput.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneInput.setPreferredSize(new Dimension(250, 100));

        JScrollPane scrollPaneOutput = new JScrollPane(textOutput);
        scrollPaneOutput.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneOutput.setPreferredSize(new Dimension(250, 100));

        //Добавим кнопки и поля на панель
        topPanel.add(labelInput);
        topPanel.add(scrollPaneInput);
        topPanel.add(labelKey);
        topPanel.add(textKey);
        centerPanel.add(encrypt);
        centerPanel.add(decrypt);
        bottomPanel.add(labelOutput);
        bottomPanel.add(scrollPaneOutput);
        bottomPanel.add(copyButton);
        bottomPanel.add(textTime);
        bottomPanel.add(labelTime);

        //Добавим панели в окно и настроим
        FRAME.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        FRAME.getContentPane().add(BorderLayout.NORTH, topPanel);
        FRAME.getContentPane().add(BorderLayout.CENTER, centerPanel);

        FRAME.pack();
        FRAME.setSize(700, 300);
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
        FRAME.setResizable(true);
    }

    public static void main(String[] args) {
        run();
    }
}