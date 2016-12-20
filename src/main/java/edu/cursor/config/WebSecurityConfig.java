package edu.cursor.config;

import edu.cursor.constants.Defined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.*;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private DriverManagerDataSource dataSource;

   @Autowired
   private LoginSuccessHandler loginSuccessHandler;

   @Autowired
   public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{

      auth.jdbcAuthentication().dataSource( dataSource )
          .usersByUsernameQuery("select login, password, enabled from users where login=?")
          .authoritiesByUsernameQuery("select login, email from users where login=?")
//          .passwordEncoder( new BCryptPasswordEncoder())
      ;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests()
            .antMatchers(
                "/css/**",
                "/img/**",
                "/js/**",
                "/vendors/**",
                "/views/**",
                Defined.BASE_URL + "/css/**",
                Defined.BASE_URL + "/img/**",
                Defined.BASE_URL + "/js/**",
                Defined.BASE_URL + "/vendors/**",
                Defined.BASE_URL + "/views/**",
                Defined.Mappings.REGISTER_ACCOUNT,
                Defined.Mappings.REGISTRATION,
                Defined.Mappings.CONFIRM_REGISTRATION + "/**"
            ).permitAll()
            .anyRequest().fullyAuthenticated()
               .and()
               .formLogin()
                  .loginPage(Defined.Mappings.LOGIN)
                  .permitAll()
                  .successHandler(loginSuccessHandler)
               .and()
               .logout()
                  .invalidateHttpSession(true)
                  .logoutUrl(Defined.Mappings.LOGOUT)
                  .logoutSuccessUrl(Defined.Mappings.LOGIN)
                  .permitAll()
          ;
   }


//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//      auth.inMemoryAuthentication()
//          .withUser("user1").password("pass").roles("USER");
//   }
}