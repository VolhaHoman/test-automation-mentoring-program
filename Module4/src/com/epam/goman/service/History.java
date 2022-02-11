package com.epam.goman.service;

import com.epam.goman.model.exception.InvalidOperatorException;

public interface History {

    Number getLast(int number) throws InvalidOperatorException;
}
