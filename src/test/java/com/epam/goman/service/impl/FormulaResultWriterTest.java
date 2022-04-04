package com.epam.goman.service.impl;

import com.epam.goman.model.FormulaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormulaResultWriterTest {

    @Test
    @DisplayName("Check write result file")
    void write() throws IOException {
        List<Object> listResult = new ArrayList<>();
        listResult.add(new FormulaDto("/", 8, 2, 4));
        FormulaResultWriter writer = new FormulaResultWriter();
        File tempFile = File.createTempFile("tmp", "txt");
        writer.write(tempFile, listResult);
        String s = readFile(tempFile);
        assertEquals("8/2=4", s);

    }

    private String readFile(File file)
            throws IOException {
        return String.join("\n", Files.readAllLines(file.toPath()));
    }
}
