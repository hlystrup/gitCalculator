package com.codebind;

public class Parser {

    public int array[] = new int[100];
    private int indexCount = 0;

    public void addInt(int input) {
        array[indexCount] = input;
        indexCount++;
    }

    public int getArrayElement(int index) {
        return array[index];
    }

    public boolean isElement(int index) { //checks if there is a value other than zero in the array at a given index
        if (array[index] == 0)
            return false;
        else
            return true;
    }
}