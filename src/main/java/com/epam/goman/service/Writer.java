package com.epam.goman.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Writer {

    void write(File file, List<Object> objects) throws IOException;
}
