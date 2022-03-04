package com.epam.goman.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class CustomLogger {

    private final Logger LOG = Logger.getLogger("MAIN");

    public CustomLogger(String fileName) throws IOException {
        FileHandler fh = new FileHandler(fileName);
        LOG.addHandler(fh);
    }

    public Logger getLogger() {
        return LOG;
    }
}
