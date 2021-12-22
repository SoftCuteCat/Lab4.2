package com.company;

import java.util.Date;
import java.util.Objects;

/**
 * A class for storing information about a person.
 */
public class Human {
    /**
     * ID of the person
     */
    private int id;
    /**
     * Name of the person
     */
    private String name;
    /**
     * Gender of the person
     */
    private String gender;
    /**
     * The division in which the person works
     */
    private Division division;
    /**
     * Employee's salary
     */
    private long salary;
    /**
     * Employee's date of birth
     */
    private String birthdate;

    /**
     * Class Constructor
     * @param id ID of the person
     * @param name Name of the person
     * @param gender Gender of the person
     * @param division The division in which the person works
     * @param salary Employee's salary
     * @param birthdate Employee's date of birth
     */
    public Human(int id, String name, String gender, Division division, long salary, String birthdate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    /**
     * Getting the name of the current person
     * @return name
     */
    public String getName() { return name; }

    /**
     * Getting the gender of the current person
     * @return gender
     */
    public String getGender() { return gender;}

    /**
     * Getting the birthdate of the current person
     * @return birthdate
     */
    public String getBirthdate() {return birthdate;}

    /**
     * Getting the salary of the current person
     * @return salary
     */
    public long getSalary() {return salary;}

    /**
     * Getting the ID of the current person
     * @return ID
     */
    public int getId() {return id; }

    /**
     * Getting the division of the current person
     * @return division
     */
    public Division getDivision() { return division; }

    /**
     * Sets the current value of the birthdate
     * @param birthdate New birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Sets the current value of the division
     * @param division New division
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     * Sets the current value of the gender
     * @param gender New gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets the current value of the ID
     * @param id New ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the current value of the name
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the current value of the salary
     * @param salary New salary
     */
    public void setSalary(long salary) {
        this.salary = salary;
    }

    /**
     * Overriding the method to return a string
     * @return A line with information about a person
     */
    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + birthdate + " " + division.getTitle() + " " + salary;
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
        Human human = (Human) o;
        return id == human.id && salary == human.salary && Objects.equals(name, human.name) && Objects.equals(gender, human.gender) && Objects.equals(birthdate, human.birthdate);
    }

    /**
     * Redefining the hash code method
     * @return Hash code of this object.
     */
    @Override
    public int hashCode() { return id + name.length() + gender.length(); }
}
