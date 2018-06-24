package ua.prog.kiev.lesson1.taskThree;

import ua.prog.kiev.lesson1.taskThree.Save;

import java.io.Serializable;

public class SerializedClass implements Serializable {

    @Save
    private String strOne = "Hello";
    private int intOne = 123;
    @Save
    public double doubleOne = 23.45;
    private String strTwo = "Bye";
    @Save
    private int intTwo = 555;
    public double doubleTwo = 33.435;
    @Save
    private Integer integer = 12345;

    public SerializedClass() {
    }

    public String getStrOne() {
        return strOne;
    }

    public int getIntOne() {
        return intOne;
    }

    public double getDoubleOne() {
        return doubleOne;
    }

    public String getStrTwo() {
        return strTwo;
    }

    public int getIntTwo() {
        return intTwo;
    }

    public double getDoubleTwo() {
        return doubleTwo;
    }

    public void setStrOne(String strOne) {
        this.strOne = strOne;
    }

    public void setIntOne(int intOne) {
        this.intOne = intOne;
    }

    public void setDoubleOne(double doubleOne) {
        this.doubleOne = doubleOne;
    }

    public void setStrTwo(String strTwo) {
        this.strTwo = strTwo;
    }

    public void setIntTwo(int intTwo) {
        this.intTwo = intTwo;
    }

    public void setDoubleTwo(double doubleTwo) {
        this.doubleTwo = doubleTwo;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
