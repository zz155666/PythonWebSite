package org.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: spring2
 * @Package: org.exception
 * @ClassName: BookException
 * @Description: java类作用描述
 * @Author: teerus
 * @CreateDate: 2018/9/1 10:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@ResponseStatus(reason="查询数据失败")
public class BookException extends RuntimeException {
}
