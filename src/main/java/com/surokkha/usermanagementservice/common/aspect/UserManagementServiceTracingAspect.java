package com.surokkha.usermanagementservice.common.aspect;

import com.surokkha.usermanagementservice.common.logger.CommonTraceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserManagementServiceTracingAspect extends CommonTraceLoggerAspect {
	
	@Pointcut ("execution(* com.surokkha.usermanagementservice..*.controller..*(..)))")
	public void userManagementControllerAspect() {
	}
	
	@Pointcut ("execution(* com.surokkha.usermanagementservice..*.service..*(..)))")
	public void userManagementServiceTrace() {
	}
	
	@Around ("userManagementServiceTrace() && !noLogging()")
	public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
		return trace(joinPoint);
	}
	
	@Around ("userManagementControllerAspect()")
	public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
		return trace(joinPoint);
	}
	
}
