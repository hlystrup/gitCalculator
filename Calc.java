package com.codebind;

public class Calc {

    //for checkString
    private char c;

    //for stringToParser
    private Parser problem = new Parser();
    private int index = 0;
    private int number = 0;
    private int number1 = 0;
    private int operator1 = 0;


    //for compute()
    int operator;
    int operand1;
    int operand2;
    private int answer;


    //for calculate()
    private Stack operands = new Stack();
    private Stack operators = new Stack();
    private int previousOperator;
    private int currentOperator;
    private boolean goOn;
    public int flag = 0;


    public boolean checkString(String sample) { //validate the input string
        for (int i = 0; i < sample.length(); i++) {
            c = sample.charAt(i);
            if (c != '+' && c != '-' && c != '/' && c != '*' && c != '(' && c != ')' && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void stringToParser(String sample) { //converts input string to array that is passed to Parser
        index = 0;
        while (index < sample.length()) { //for the whole length of the problem, iterate through each char
            c = sample.charAt(index);
            if (Character.isDigit(c)) {   //if the char is a digit, get the associated number
                while (Character.isDigit(c) && index < sample.length()) {
                    c = sample.charAt(index);
                    number = Character.getNumericValue(c);
                    if (number < 0) { break; }    //fix that makes sure number isn't -1, because while loop continues even though the char is not a digit (weird bug)
                    number1 = (number1 * 10) + number;
                    index++;
                }
                problem.addInt(number1);
                number1 = 0;
                number = 0;
            } else {    //the char must be an operator, hence store the value in the current operator
                if (c == '*') {
                    operator1 = -1;
                } else if (c == '/') {
                    operator1 = -2;
                } else if (c == '+') {
                    operator1 = -3;
                } else if (c == '-') {
                    operator1 = -4;
                } else if (c == '(') {
                    operator1 = -5;
                } else if (c == ')') {
                    operator1 = -6;
                }
                problem.addInt(operator1);
                index++;
            }
        }
    }

    private int checkPrecedence(int operator2) {
        if (operator2 == -5 || operator2 == -6) { //if it is a parenthesis, top priority
            return 2;
        } else if (operator2 == -1 || operator2 == -2) { //if it is multiplication or division it is middle priority
            return 1;
        } else { //it must be addition or subtraction, the lowest priority
            return 0;
        }
    }

    private void compute() {
        operator = operators.pop(); //pop the necessary parameters
        operand2 = operands.pop();
        operand1 = operands.pop();
        if (operator == -1) {
            answer = operand1 * operand2;
        } else if (operator == -2) {
            answer = operand1 / operand2;
        } else if (operator == -3) {
            answer = operand1 + operand2;
        } else if (operator == -4){
            answer = operand1 - operand2;
        }
        operands.push(answer);
    }

    private void computePostFix () {
        operands.push(operators.pop());
    }

    public int calculate() {
        index = 0;
        do {
            number = problem.getArrayElement(index);
            if (number > 0) {//it must be an integer, hence push it to the stack for operands
                operands.push(number);
            }
            else if (operators.peekAtIndex(0) == 0 || number == -5) {//if the operator stack is empty or if the operator is '('
                operators.push(number);
            }
            else {
                goOn = true;
                currentOperator = number;
                while (goOn) {
                    previousOperator = operators.peek();
                    if (currentOperator != -6) { //if the operator is not ')'
                        if (checkPrecedence(previousOperator) < checkPrecedence(currentOperator) || previousOperator == -5) {
                            //the current operator has HIGHER precedence than the previous one
                            operators.push(currentOperator);
                            goOn = false; //stops the while loop
                        } else {//the current operator must have LOWER OR EQUAL precedence than the previous one
                            if (flag == 0) {
                                compute();//the while loop goes on
                            } else {
                                computePostFix();
                            }
                            if (operators.isEmpty()) {
                                goOn = false;
                                index--;
                            } //unless there are no more operators in the stack
                        }
                    } else {//the operator is ')'
                        while (currentOperator != -5) {
                            if (flag == 0) {
                                compute();//the while loop goes on
                            } else {
                                computePostFix();
                            }
                            currentOperator = operators.peek();
                        }
                        int waste = operators.pop(); //getting rid of the '('
                        if (flag == 0) {
                            compute();//the while loop goes on
                        } else {
                            computePostFix();
                        }
                        goOn = false; //stops the while loop
                    }
                }
            }
            index++;
        } while (problem.isElement(index - 1));
        if (flag == 0) {
            return operands.peekAtIndex(0);
        } else {
            operands.show();
            return 0;
        }
    }
}