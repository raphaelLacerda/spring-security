package app.seguranca;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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


        //deveria permitir anonimo para todas, ate quem precisa estar autenticado

                http.authorizeRequests()
                .antMatchers("/**")
                .anonymous();



    }
}