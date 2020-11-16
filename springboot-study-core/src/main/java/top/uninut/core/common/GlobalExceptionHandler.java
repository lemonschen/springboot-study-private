package top.uninut.core.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult<Object> handler(Exception e) {
        RestResult<Object> result = new RestResult<>();
        result.setCode(500);
        result.setMsg(e.getClass().getName());
        return result;
    }
}
