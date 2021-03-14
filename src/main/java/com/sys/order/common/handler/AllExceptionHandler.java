package com.sys.order.common.handler;

import com.sys.order.exception.MyException;
import com.sys.order.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义全局异常处理器
 */
@RestControllerAdvice
public class AllExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AllExceptionHandler.class);

    /**
     * 处理最大的 异常
     *
     * @param e ExcelException
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVo<String> excelExceptionHandler(Exception e) {
        log.error("程序出错：", e);
        return ResultVo.failure("系统错误，请联系管理员");
    }

    /**
     * 处理业务逻辑异常
     *
     * @param run MyException
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public ResultVo<String> runtimeExceptionHandler(MyException run) {
        log.error(run.getMessage());
        return ResultVo.failure(run.getMessage());
    }

}
