package com.epam.goman.validator;

import com.epam.goman.model.Formula;

public class FormulaValidator implements Validator {

    @Override
    public void validate(Formula formula) throws Exception {

        if (formula.getX() == null) {
            throw new Exception("Formula exception: Parameter x can't be null");
        }
        if (formula.getY() == null) {
            throw new Exception("Formula exception: Parameter y can't be null");
        }
        if (formula.getOperator() == null || formula.getOperator().isBlank()){
            throw new Exception("Formula exception: Operator can't be null or empty");
        }
    }
}
