package com.shatakshee.erp.execption;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentNotFoundExecption extends RuntimeException {
    private final String msg;
}

