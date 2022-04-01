package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.service.Reader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormulaReaderTest {

    @Test
    @DisplayName("Check file read")
    void read() throws IOException {
        Reader reader = new FormulaReader(Logger.getAnonymousLogger());
        String path = "src/test/resources/formulae.txt";
        File file = new File(path);
        List<Formula> read = reader.read(file);
        assertEquals(3, read.size());
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
}
