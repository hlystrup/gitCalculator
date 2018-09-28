package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calculator {
    private JPanel panelMain;
    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton divide;
    private JButton lParenthesis;
    private JButton rParenthesis;
    private JButton one;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton two;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton equals;
    private JTextField helloTextField;
    private JButton cButton;

    public Calculator() {



        plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "+");
            }
        });

        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "-");
            }
        });
        multiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "*");
            }
        });
        divide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "/");
            }
        });
        lParenthesis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "(");
            }
        });
        rParenthesis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + ")");
            }
        });
        one.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "1");
            }
        });
        two.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "2");
            }
        });
        three.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "3");
            }
        });
        four.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "4");
            }
        });
        five.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "5");
            }
        });
        six.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "6");
            }
        });
        seven.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "7");
            }
        });
        eight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "8");
            }
        });
        nine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "9");
            }
        });
        zero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText(helloTextField.getText() + "0");
            }
        });
        equals.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String userInput = helloTextField.getText();
                Calc calc1 = new Calc();
                calc1.stringToParser(userInput);
                int answer = calc1.calculate();
                String Answer = Integer.toString(answer);
                helloTextField.setText(Answer);
            }
        });
        cButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helloTextField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Standard Calculator");
        frame.setResizable(false);
        frame.setSize(450,550);
        frame.setLocationRelativeTo(null);
    }
}
