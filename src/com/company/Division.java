package com.company;

import java.util.Objects;

/**
 * A class for storing information about a division
 */
public class Division {
    /**
     * Unit ID
     */
    private int id;
    /**
     * Division name
     */
    private char title;

    /**
     * Class Constructor
     * @param title Division name
     */
    public Division(char title) {
        this.title = title;
        id = (int) title;
    }

    /**
     * Getting the division ID
     * @return Division ID
     */
    public int getId() {return id;}

    /**
     * Getting the division name
     * @return Division name
     */
    public char getTitle() {return title;}

    /**
     * Setting the division ID
     * @param id New division ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setting the division name
     * @param title New division name
     */
    public void setTitle(char title) {
        this.title = title;
    }

    /**
     * Overriding the method to return a string
     * @return A line with information about a division
     */
    @Override
    public String toString() {
        return "" + id + " " + title;
    }

    /**
     * Overriding the method for comparing objects.
     * @param o Object to compare
     * @return true if equal and false if not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id && Objects.equals(title, division.title);
    }

    /**
     * Redefining the hash code method
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() { return (int) title; }
}
