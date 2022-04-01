package com.epam.goman.service.impl;

import com.epam.goman.model.FormulaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormulaResultWriterTest {

    @Test
    @DisplayName("Check write result file")
    void write() throws IOException {
        List<Object> listResult = new ArrayList<>();
        listResult.add(new FormulaDto("/", 8, 2, 4));
        FormulaResultWriter writer = new FormulaResultWriter();
        String path = "src/test/resources/formulaeResult.txt";
        File file = new File(path);
        writer.write(file, listResult);
        String s = readFile(file);
        assertEquals("8/2=4\n", s);

    }

    private String readFile(File file)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
