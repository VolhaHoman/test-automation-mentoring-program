package com.epam.goman.service;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.InvalidOperatorException;

public interface History {

    Formula getLast(int number) throws InvalidOperatorException;
}
