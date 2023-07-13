package com.surokkha.usermanagementservice.common.aspect;

import com.surokkha.usermanagementservice.common.logger.CommonPerformanceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserManagementServicePerformanceAspect extends CommonPerformanceLoggerAspect {
	
	@Pointcut ("execution(public * com.surokkha.usermanagementservice..*.repository..*.*(..))")
	public void userManagementRepositoryPerformanceTrace() {
	}
	
	@Around ("userManagementRepositoryPerformanceTrace())")
	public Object calculateUserManagementServicePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
		return tracePerformance(joinPoint);
	}
	
}
