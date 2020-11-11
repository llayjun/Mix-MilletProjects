package com.llayjun.millet.common.exception.handler;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.llayjun.millet.common.entity.BaseResult;
import com.llayjun.millet.common.exception.*;
import com.llayjun.millet.common.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleException(Throwable e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(BAD_REQUEST.value(),e.getMessage());
        return buildResponseEntity(baseResult);
    }

    /**
     * 处理 接口无权访问异常AccessDeniedException
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity handleAccessDeniedException(AccessDeniedException e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(FORBIDDEN.value(),e.getMessage());
        return buildResponseEntity(baseResult);
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<BaseResult> badRequestException(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(e.getStatus(),e.getMessage());
        return buildResponseEntity(baseResult);
	}

    /**
     * 处理 EntityExist
     * @param e
     * @return
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<BaseResult> entityExistException(EntityExistException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(BAD_REQUEST.value(),e.getMessage());
        return buildResponseEntity(baseResult);
    }

    /**
     * 处理 EntityNotFound
     * @param e
     * @return
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<BaseResult> entityNotFoundException(EntityNotFoundException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(NOT_FOUND.value(),e.getMessage());
        return buildResponseEntity(baseResult);
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @returns
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("========参数异常统一处理有拦截！==========");
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        String[] str = e.getBindingResult().getAllErrors().get(0).getCodes()[1].split("\\.");
        StringBuffer msg = new StringBuffer(str[1]+":");
        msg.append(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        BaseResult baseResult = new BaseResult(BAD_REQUEST.value(),msg.toString());
        return buildResponseEntity(baseResult,200);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BaseResult> businessException(BusinessException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(e.getCode(),e.getMessage(),null);
        return buildResponseEntity(baseResult,200);
    }

    @ExceptionHandler(value = TokenValidException.class)
    public ResponseEntity<BaseResult> tokenValidException(TokenValidException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(300,e.getMessage());
        return buildResponseEntity(baseResult,200);
    }

    @ExceptionHandler(value = JWTVerificationException.class)
    public ResponseEntity<BaseResult> jWTVerificationException(JWTVerificationException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        BaseResult baseResult = new BaseResult(300,"token解析失败！");
        return buildResponseEntity(baseResult,200);
    }

    /**
     * 统一返回
     * @param baseResult
     * @return
     */
    private ResponseEntity<BaseResult> buildResponseEntity(BaseResult baseResult) {
        return new ResponseEntity(baseResult, valueOf(baseResult.getCode()));
    }

    private ResponseEntity<BaseResult> buildResponseEntity(BaseResult baseResult,int code) {
        return new ResponseEntity(baseResult, valueOf(code));
    }

}
