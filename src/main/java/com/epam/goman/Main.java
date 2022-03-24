package com.epam.goman;

import com.epam.goman.model.Formula;
import com.epam.goman.model.FormulaDto;
import com.epam.goman.model.exception.ArgumentsNotFoundException;
import com.epam.goman.operator.impl.Division;
import com.epam.goman.operator.impl.Multiply;
import com.epam.goman.operator.impl.Subtraction;
import com.epam.goman.operator.impl.Sum;
import com.epam.goman.service.CustomLogger;
import com.epam.goman.service.Reader;
import com.epam.goman.service.Writer;
import com.epam.goman.service.impl.FormulaReader;
import com.epam.goman.service.impl.FormulaResultWriter;
import com.epam.goman.service.impl.LocalCalculator;
import com.epam.goman.service.impl.ProxyCalculator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final ProxyCalculator calc = new ProxyCalculator(new LocalCalculator());

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new ArgumentsNotFoundException("File path is empty or null");
        }

        Logger logger = CustomLogger.LOG;

        try {

            List<Object> resultList = new ArrayList<>();

            Reader reader = new FormulaReader(logger);
            Writer writer = new FormulaResultWriter();

            List<Formula> formula = reader.read(new File(args[0]));
            calc.addOperator(new Sum());
            calc.addOperator(new Multiply());
            calc.addOperator(new Subtraction());
            calc.addOperator(new Division());

            for (Formula value:formula) {
                try {
                    Number calculate = calc.calculate(value);
                    resultList.add(new FormulaDto(value.getOperator(), value.getX(), value.getY(),
                            calculate));

                } catch (Exception ex) {
                    logger.log(Level.WARNING, ex.getLocalizedMessage(), ex);
                }
            }

            writer.write(new File(args[1]), resultList);

        } catch (IOException e) {
            logger.log(Level.WARNING, e.getLocalizedMessage(), e);
        }
    }
}