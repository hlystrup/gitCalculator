/**
 *  This is a basic java class for the stack data structure
 *
 * @author Havard Lystrup
 * @version 1.0
 */

package com.codebind;

public class Stack {

    //constructors
    private int stack[] = new int[100];
    private int top = 0;
    private int data;

    //methods
    public void push(int data) { //adds value to stack
        stack[top] = data;
        top++;
    }

    public int pop() { //removes value from stack
        top--;
        data = stack[top];
        stack[top] = 0;
        return data;
    }

    public int peek() { //returns top value in stack
        data = stack[top - 1];
        return data;
    }

    public int peekAtIndex(int index) { //returns value at specific index
        data = stack[index];
        return data;
    }

    public boolean isEmpty() {
        if (stack[0] == 0) {
            return true;
        } else { return false; }
    }

    public void show() {  //prints entire stack
        for (int i = 0; i < top; i++) {
            int n = stack[i];
            if (n>=0) {
                System.out.print(n + "  ");
            } else {
                switch (n) {
                    case -1: System.out.print("*   "); break;
                    case -2: System.out.print("/   "); break;
                    case -3: System.out.print("+   "); break;
                    case -4: System.out.print("-   "); break;
                    case -5: System.out.print("(   "); break;
                    case -6: System.out.print(")   "); break;
                }
            }
        }
    }
}