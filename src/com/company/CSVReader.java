package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The class is designed to read CSV files about foreigners.
 * The file that will be submitted for reading
 * must contain the following columns with information about users in the given order:
 * id, name, gender, birthdate, division, salary. In case of non-compliance,
 * the corresponding errors are processed.
 *
 * @author Evgeniy Kalishkin
 * @version 1.0
 */
public class CSVReader
{
    /**
     * A list that stores information about all.
     * the people from the file.
     */
    public List<Human> humans;
    /**
     * A set in which all possible subdivisions.
     * from the file are stored.
     */
    public Set<Division> divisions;
    /**
     * The full path to the file.
     */
    public String path;
    /**
     * The number of the current line for more accurate error output.
     */
    private long numOfLine;

    /**
     * Constructor of the class. Initialization of all class properties occurs.
     * @param path Full path to the file.
     */
    public CSVReader(String path)
    {
        this.path = path;
        humans = new LinkedList<>();
        divisions = new HashSet<>();
        numOfLine = 1;
    }

    /**
     * Reading the file.
     * @throws Exception If there is a shortage/overabundance in the file
     */
    public void reading() throws Exception
    {
        validPath();
        BufferedReader bufferedReader = null;
        String line = "";
        bufferedReader = new BufferedReader(new FileReader(path));
        bufferedReader.readLine();
        numOfLine++;
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] row = line.split(";");
            if (row.length != 6)
            {
                throw new Exception("There are not enough columns in the file or there are more than 6 of them.");
            }
            validId(row[0]);
            validGender(row[2]);
            validBirthdate(row[3]);
            validDivision(row[4]);
            validSalary(row[5]);
            Division div = new Division(row[4].charAt(0));
            divisions.add(div);
            humans.add(new Human(Integer.parseInt(row[0]), row[1], row[2], div, Integer.parseInt(row[5]), row[3]));
            numOfLine++;
        }
    }

    private void validPath() throws Exception
    {
        File file = new File(path);
        if (!file.isDirectory() && !file.isFile())
        {
            throw new Exception("The path was not found. Please check the entered data.");
        }
        if (!getFileExtension(file).equals("csv"))
        {
            throw new Exception("The file format does not match. Please check the entered data.");
        }
    }

    /**
     * Checking the ID for correctness. Characters other than numbers are not allowed.
     * @param id The current ID in the row.
     * @throws Exception If the ID contains elements other than digits.
     */
    private void validId(String id) throws Exception
    {
        try
        {
            Integer.parseInt(id);
        }
        catch(Exception exception)
        {
            throw new Exception("Contains incorrect data in column A line " + numOfLine + "! Please fix it.");
        }
    }

    /**
     * Checking the gender for correctness.
     * @param gender The current gender in the row.
     * @throws Exception If an unknown gender is entered.
     */
    private void validGender(String gender) throws Exception
    {
        if (!gender.equals("Male") && !gender.equals("Female"))
        {
            throw new Exception("Contains incorrect data in column C line " + numOfLine +"! Please fix it.");
        }
    }

    /**
     * Checking the birthdate for correctness.
     * @param birthdate The current birthdate in the row.
     * @throws Exception If the date is entered incorrectly.
     */
    private void validBirthdate(String birthdate) throws Exception
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthdate);
        }
        catch(Exception exception) {
            throw new Exception("Column D of row " + numOfLine + " contains an incorrect date of birth.");
        }
    }

    /**
     * Checking the division for correctness.
     * @param division The current division in the row.
     * @throws Exception If the division contains more than one character.
     */
    private void validDivision(String division) throws Exception
    {
        if (division.length() > 1)
        {
            throw new Exception("Column E of row " + numOfLine +" contains an incorrect division.");
        }
    }

    /**
     * Checking the salary for correctness. Characters other than numbers are not allowed.
     * @param salary The current salary in the row.
     * @throws Exception If the salary contains elements other than digits.
     */
    private void validSalary(String salary) throws Exception
    {
        try
        {
            Integer.parseInt(salary);
        }
        catch (Exception exception)
        {
            throw new Exception("Column F of row " + numOfLine + " contains an incorrect salary");
        }
    }

    /**
     * Checking the file extension.
     * @param file The file to which the path was specified.
     * @return The file extension, if any. If it is not present, an empty string is sent.
     */
    private String getFileExtension(File file)
    {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    /**
     * A method for finding people working in the same department
     * @param title The division we need
     * @return Array with people from this division
     */
    public List<Human> rightPeople(char title)
    {
        List<Human> rightPeople = new ArrayList<>();
        for (Human i: humans) {
            if (i.getDivision().getTitle() == title)
            {
                rightPeople.add(i);
            }
        }
        return rightPeople;
    }

    /**
     * Overriding the method for comparing objects.
     * @param o Object to compare
     * @return true if equal and false if not equal
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSVReader csvReader = (CSVReader) o;
        return humans.equals(csvReader) && divisions.equals(csvReader.divisions);
    }

    /**
     * Redefining the hash code method
     * @return Hash code of this object.
     */
    @Override
    public int hashCode()
    {
        return humans.size() - divisions.size();
    }
}
