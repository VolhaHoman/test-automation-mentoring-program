package com.epam.goman.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class CustomLogger {

    private static final String FILES_LOG_TXT = "files/log.txt";
    public final static Logger LOG = Logger.getLogger("MAIN");

    static {
        FileHandler fh = null;
        try {
            fh = new FileHandler(FILES_LOG_TXT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.addHandler(fh);
    }
}
