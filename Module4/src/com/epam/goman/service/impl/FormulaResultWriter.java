package com.epam.goman.service.impl;

import com.epam.goman.service.Writer;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class FormulaResultWriter implements Writer {
    @Override
    public void writeResults(File file, List<Object> objects) throws IOException {
        FileOutputStream fos = null;
        OutputStreamWriter writer = null;

        try {
            fos = new FileOutputStream(file);
            writer = new OutputStreamWriter(fos);

            for (Object value : objects) {
                writer.write(value.toString() + "\n");
            }
        } finally {
            if (Objects.nonNull(writer)) {
                writer.close();
            }
            if (Objects.nonNull(fos)) {
                fos.close();
            }
        }

    }
}
