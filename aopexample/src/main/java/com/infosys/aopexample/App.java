package com.infosys.aopexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.aopexample.beans.User;
import com.infosys.aopexample.config.Config;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User u= context.getBean(User.class);
        u.show();
    }
}
