package edu.cursor;

import edu.cursor.config.AppConfig;
import edu.cursor.config.WebConfig;
import edu.cursor.constants.Defined;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@ComponentScan(basePackages = {"edu.cursor.controller"})
public class App extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class<?>[]{AppConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class<?>[]{WebConfig.class};
   }

   @Override
   protected String[] getServletMappings() {
//      return new String[]{"/spring-library/*"};
      return new String[]{ Defined.BASE_URL + "/*"};
   }
}