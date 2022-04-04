package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.service.Reader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class FormulaReaderTest {

    @Test
    @DisplayName("Check file read")
    void read() throws IOException {
        Reader reader = new FormulaReader(Logger.getAnonymousLogger());
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("formulae.txt").getFile());
        List<Formula> actual = reader.read(file);
        List<Formula> expected = new ArrayList<>();
        expected.add(new Formula(1.0, 2.0, "+"));
        expected.add(new Formula(10.0, 2.0, "-"));
        expected.add(new Formula(9.0, 0.7865, "*"));
        assertIterableEquals(expected, actual);
    }

    @Test
    @DisplayName("Check not existing file")
    void readNUll() throws IOException {
        assertThrows(FileNotFoundException.class, () -> {
            Reader reader = new FormulaReader(Logger.getAnonymousLogger());
            File file = new File("null");
            reader.read(file);
        });
    }

    @Test
    @DisplayName("Check invalid formula is skipped")
    void readInvalidFormula() throws IOException {
        Reader reader = new FormulaReader(Logger.getAnonymousLogger());
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("formulaeNegative.txt")).getFile());
        List<Formula> actual = reader.read(file);
        List<Formula> expected = new ArrayList<>();
        expected.add(new Formula(1.0, 3.0, "+"));
        expected.add(new Formula(10.0, 1.0, "*"));
        assertIterableEquals(expected, actual);
    }
}
