package tests;

import com.company.CSVReader;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    CSVReader csv;

    @org.junit.jupiter.api.Test
    void test1() throws Exception{
        csv = new CSVReader("a");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("The path was not found. Please check the entered data.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test2() throws Exception{
        csv = new CSVReader("src/tests/2.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("There are not enough columns in the file or there are more than 6 of them.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test3() throws Exception{
        csv = new CSVReader("src/tests/3.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Contains incorrect data in column A line 6! Please fix it.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test4() throws Exception{
        csv = new CSVReader("src/tests/4.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Contains incorrect data in column C line 4! Please fix it.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test5() throws Exception{
        csv = new CSVReader("src/tests/5.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Column D of row 7 contains an incorrect date of birth.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test6() throws Exception{
        csv = new CSVReader("src/tests/6.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Column D of row 8 contains an incorrect date of birth.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test7() throws Exception{
        csv = new CSVReader("src/tests/7.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Column D of row 2 contains an incorrect date of birth.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test8() throws Exception{
        csv = new CSVReader("src/tests/8.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Column E of row 6 contains an incorrect division.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test9() throws Exception{
        csv = new CSVReader("src/tests/9.csv");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("Column F of row 3 contains an incorrect salary", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void test10() throws Exception{
        csv = new CSVReader("src/tests/1.txt");
        Exception exception = assertThrows(Exception.class, () -> csv.reading());
        assertEquals("The file format does not match. Please check the entered data.", exception.getMessage());
    }
}