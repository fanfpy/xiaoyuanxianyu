package top.fanfpy.xiaoyuanxianyu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * top.fanfpy.xiaoyuanxianyu.web.GoodsImgApiController.addImg(..))")
    public void log(){
    }

    //启动前
    @Before("log()")

    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());

        logger.info("args={}",joinPoint.getArgs());
    }

    //启动后

    @After("log()")
    public void doAfter(){

    }

    //返回参数

    @AfterReturning(returning = "object" , pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}

