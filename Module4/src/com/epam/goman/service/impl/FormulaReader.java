package com.epam.goman.service.impl;

import com.epam.goman.model.Formula;
import com.epam.goman.model.exception.IllegalExpressionException;
import com.epam.goman.service.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaReader implements Reader {

    Logger LOG;

    public FormulaReader(Logger log) {
        this.LOG = log;
    }

    public static final String EXPRESSION_PATTERN = "(-?[\\d\\.]{1,6})([-+\\/*]{1})(-?[\\d\\.]{1,6})";

    @Override
    public List<Formula> getFormula(File file) throws IOException {
        List<Formula> list = new ArrayList<>();
        String expression;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((expression = bufferedReader.readLine()) != null) {
                try {
                    Formula formula = parseExpression(expression);
                    list.add(formula);
                } catch (IllegalExpressionException e) {
                    LOG.warning(e.getLocalizedMessage() + ": " + expression);
                }
            }
        } finally {
            if (Objects.nonNull(fileReader)) {
                fileReader.close();
            }
            if (Objects.nonNull(bufferedReader)) {
                bufferedReader.close();
            }
        }

        return list;
    }

    private Formula parseExpression(String expression) throws IllegalExpressionException {
        Pattern pattern = Pattern.compile(EXPRESSION_PATTERN);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            return new Formula(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(3)), matcher.group(2));
        }
        throw new IllegalExpressionException("Expression doesn't match regExp pattern");
    }
}
