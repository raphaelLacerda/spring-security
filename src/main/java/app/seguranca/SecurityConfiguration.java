package app.seguranca;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {

        //funcionou somente anonimo

//        http.authorizeRequests()
//                .antMatchers("/anonimo")
//                .anonymous()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .authenticated();

        //a ordem importa... agora anonimo nao funcionou

//        http.authorizeRequests()
//                .antMatchers("/**")
//                .authenticated()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/anonimo")
//                .anonymous();


        //deveria permitir anonimo para todas somente OPTIONS
        //nao funfou

//        http.authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**")
//                .anonymous();


        //With this config, we will authorize all users (both anonymous and logged in) to access the page starting with ‘/’ (for example, our homepage).
        //nao funciona com PreAuthorize

        http.authorizeRequests()
                .antMatchers("/**")
                .anonymous()
                .antMatchers("/**")
                .permitAll();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("1").roles("admin");
    }

}