package com.epam.goman;

public class Formula {

    private Number x;
    private Number y;
    private String operator;

    public Formula(Number x, Number y, String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public void validate() throws Exception {
        if (x==null){
            throw new Exception("Formula exception: Parameter x can't be null");
        }
        if (y==null){
            throw new Exception("Formula exception: Parameter y can't be null");
        }
        if (operator==null || operator.isBlank()){
            throw new Exception("Formula exception: Operator can't be null or empty");
        }
    }
    public Number getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = x;
    }

    public Number getY() {
        return y;
    }

    public void setY(Number y) {
        this.y = y;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
