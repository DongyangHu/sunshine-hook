package com.hudongyang.sunshinehook.common.bean;

import com.hudongyang.sunshinehook.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dongyang.hu
 * @date 2019/12/5 22:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public static <T> Result success(T data) {
        return Result.builder().code(ResultEnum.SUCCESS.getCode()).message(ResultEnum.SUCCESS.getMessage()).data(data).build();
    }

    public static Result success() {
        return Result.builder().code(ResultEnum.SUCCESS.getCode()).message(ResultEnum.SUCCESS.getMessage()).build();
    }

    public static <T> Result error(T data) {
        return Result.builder().code(ResultEnum.FAILED.getCode()).message(ResultEnum.FAILED.getMessage()).data(data).build();
    }

    public static Result error() {
        return Result.builder().code(ResultEnum.FAILED.getCode()).message(ResultEnum.FAILED.getMessage()).build();
    }

    public static <T> Result result(ResultEnum messageEnum, T data) {
        return Result.builder().code(messageEnum.getCode()).message(messageEnum.getMessage()).data(data).build();
    }

    public static Result result(ResultEnum messageEnum) {
        return Result.builder().code(messageEnum.getCode()).message(messageEnum.getMessage()).build();
    }
}
