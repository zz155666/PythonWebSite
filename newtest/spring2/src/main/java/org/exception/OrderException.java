package org.exception;

/**
 * @ProjectName: spring2
 * @Package: org.exception
 * @ClassName: OrderException
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 13:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderException extends RuntimeException{

    public OrderException(){
        super();
    }
    public OrderException(String message,Throwable cause,boolean enableSuppression,boolean wriableStackTrace){
        super(message,cause,enableSuppression,wriableStackTrace);
    }

    public OrderException(String message,Throwable cause){
        super(message,cause);
    }
    public OrderException(String message){
        super(message);
    }
    public OrderException(Throwable cause){
        super(cause);
    }
}
