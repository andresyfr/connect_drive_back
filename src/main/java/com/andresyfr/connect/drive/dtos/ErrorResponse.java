package com.andresyfr.connect.drive.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {

    private int statusCode;
    private String message;

}
