package com.epam.goman.service.impl;

import com.epam.goman.model.exception.ParameterIsNullException;
import com.epam.goman.model.exception.RemoteOperatorException;
import com.epam.goman.service.CustomLogger;
import com.epam.goman.service.MathJsService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class MathJsServiceImpl implements MathJsService {

    public static final String EXPR = "expr";
    private final Logger logger = CustomLogger.LOG;

    public static final String BASE_URL = "http://api.mathjs.org/v4/";

    @Override
    public Double httpRequest(Number x, Number y, String operator) {
        Objects.requireNonNull(x, "x can't be null");
        Objects.requireNonNull(y, "y can't be null");
        if (Objects.isNull(operator) && operator.isBlank())
            throw new ParameterIsNullException("Operator can't be null or blank");
        if (y.equals(0) && operator.equals("/")) throw new ArithmeticException("Division by zero");
        try{
            String value = x + operator + y;
            logger.info("Request will be sent to: {} with param: {} and value: {}",
                    BASE_URL, EXPR, value);
            Response result = given()
                    .param(EXPR, x + operator + y)
                    .get(BASE_URL);
            int statusCode = result.getStatusCode();
            String contentType = result.getContentType();
            String statusLine = result.getStatusLine();
            String responseValue = result.asString();
            logger.info("Response received with status: {} {} and content type: {}, value: {}",
                    statusCode, statusLine, contentType, responseValue);
            return Double.parseDouble(responseValue);
        } catch (Exception e){
            throw new RemoteOperatorException("Can't operate: " + x + operator + y);
        }
    }
}
