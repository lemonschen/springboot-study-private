package top.uninut.core.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
@Slf4j
public class RequestLogAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void requestLogAdvicePointcut(){};

    @Around("requestLogAdvicePointcut()")
    public Object requestLogAdvice(ProceedingJoinPoint joinPoint)throws Throwable{
        log.info(joinPoint.getKind());
        log.info(JSON.toJSONString(joinPoint.getArgs()));
        log.info(joinPoint.getTarget().getClass().getName());
        log.info(joinPoint.getSignature().getName());
        log.info(joinPoint.getSourceLocation().getFileName());
        log.info("接收到GET请求");
        return joinPoint.proceed();
    }
}
