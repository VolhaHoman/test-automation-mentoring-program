package com.epam.goman.service;

import com.epam.goman.model.Formula;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Reader {

    List<Formula> getFormula(File file) throws IOException;
}
