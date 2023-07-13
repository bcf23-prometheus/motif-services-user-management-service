package com.surokkha.usermanagementservice.common.aspect;

import com.surokkha.usermanagementservice.common.logger.CommonIntegrationLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserManagementServiceIntegrationAspect extends CommonIntegrationLoggerAspect {

    @Pointcut("execution(public * com.surokkha.usermanagementservice..*.rest.client..*.*(..))")
    public void userManagementIntegrationTrace() {
    }

    @Around("userManagementIntegrationTrace()")
    public Object traceMerchantIntegration(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

}
