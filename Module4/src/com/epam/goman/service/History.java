package com.epam.goman.service;

import com.epam.goman.model.Formula;

public interface History {

    Formula getLast(int number);
}
