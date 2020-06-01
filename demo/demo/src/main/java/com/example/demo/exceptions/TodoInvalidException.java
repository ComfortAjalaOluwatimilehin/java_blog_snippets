package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Todo is invalid. Title should contain at least one alphanumeric character.")
public class TodoInvalidException extends RuntimeException {
}
