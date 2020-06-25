package com.stackroute.springboot.rest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stackroute.springboot.rest.entity.Employee;
import com.stackroute.springboot.rest.exception.EmployeeAlreadyExistsException;

@Aspect
@Component
public class LoggingAspect {
	
	 private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// What action you want to take at what point
	
	//take some action before my saveEmployee method executes
	
	//Before , after ,afterthrowing
	/*com.stackroute.springboot.rest.controller.EmployeeController.saveEmployee
	private
	public 
	protected
	*/
	@Before(value = "execution(* com.stackroute.springboot.rest.controller.EmployeeController.*(..)) and args(employee)")
	public void beforeAdviceMethod(JoinPoint joinPoint, Employee employee) {
		logger.info("Inside Before Advice...");
		logger.info("Target Objet Method-->"  + joinPoint.getSignature().getName());
		logger.info("Creatign an employee with the following details::: " + employee);
	}
	
	@After(value = "execution(* com.stackroute.springboot.rest.controller.EmployeeController.*(..)) and args(employee)")
	public void afterAdviceMethod(JoinPoint joinPoint, Employee employee) {
		logger.info("Inside After Advice...");
		logger.info("Target Objet Method-->"  + joinPoint.getSignature().getName());
		logger.info("Created an employee with the following details::: " + employee);

	}
	
	@AfterReturning(value = "execution(* com.stackroute.springboot.rest.controller.EmployeeController.*(..)) and args(employee)")
	public void afterReturningAdvice(JoinPoint joinPoint, Employee employee) {
		logger.info("Inside After Returning Advice...");
		logger.info("Target Objet Method-->"  + joinPoint.getSignature().getName());
		logger.info("Created an employee with the following details::: " + employee);


	}
	
	@AfterThrowing(pointcut="within(com.stackroute.springboot.rest.controller..*)", throwing="exception")
	public void afterThrowingAdvice(JoinPoint joinPoint, EmployeeAlreadyExistsException exception ) {
		logger.error("Inside After Throwing Advice...");
		logger.error("Target Objet Method-->"  + joinPoint.getSignature().getName());
		logger.error("Exception thrown " + exception.toString());

	}
	
	@Around("execution(* com.stackroute.springboot.rest.controller.EmployeeController.*(..)) and args(employee)")
	public void methodAroundAdvice(ProceedingJoinPoint pJoinPoint, Employee employee) throws Throwable {
		logger.info("Mothod Around Advice::" + pJoinPoint.getSignature().getName());
		logger.info("Arguments:::" + employee);
		
		try {
			pJoinPoint.proceed(); //target object method
			// it can return the data successfully
			// it can throw the exception
		} catch (Throwable e) {
			//Response
			e.printStackTrace();
			throw e;
		} finally {
			logger.info("some recovery action is taken");
		
			//Response
		}
		
		logger.info("After method execution:::" + pJoinPoint.getSignature().getName());
		
	}
    
}
