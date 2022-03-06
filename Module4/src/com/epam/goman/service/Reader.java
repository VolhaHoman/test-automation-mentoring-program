package com.epam.goman.service;

import com.epam.goman.model.Formula;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Reader {

    List<Formula> read(File file) throws IOException;
}
