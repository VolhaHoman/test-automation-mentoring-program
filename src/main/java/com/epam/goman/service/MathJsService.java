package com.epam.goman.service;

import com.epam.goman.model.Formula;

public interface MathJsService {
    Double httpRequest (Number x, Number y, String operator);
}
