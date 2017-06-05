package com.datalex;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@SpringBootApplication
public class SpelDemoApplication {
    
    Logger log = LoggerFactory.getLogger(SpelDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpelDemoApplication.class, args);
	}
	
	@Bean
	public String testSepl() throws Exception
	{
	    log.info("RUNNING....");
	    
	    DyamicSearchVariables rootObj = new DyamicSearchVariables();
	    StandardEvaluationContext evalContext = new StandardEvaluationContext();
	    

	    evalContext.registerFunction("days",
            DyamicSearchVariables.class.getDeclaredMethod("days", new Class[] { Integer.class }));
        
	    TemplateParserContext ctx = new TemplateParserContext();

	    
	    ExpressionParser parser = new SpelExpressionParser();
	    Object message = parser.parseExpression("ReturnDate: #{currentDate + ' ' + (days(10) + days(10))}, Origin: #{searchParams.get('origin')}"
	        , ctx).getValue(evalContext, rootObj);
	    
	    log.info("\n\n " + message + "\n\n");
	    return "OK";
	    
	}
}
