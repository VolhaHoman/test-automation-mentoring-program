package com.epam.goman.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Writer {

    void writeResults(File file, List<Object> objects) throws IOException;
}
