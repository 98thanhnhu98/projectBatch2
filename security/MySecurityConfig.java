package com.example.Project.security;

import com.example.Project.Service.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/pageLogin")
                .defaultSuccessUrl("/login-success")
                .failureUrl("/pageLogin?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
//                .and()
//                .rememberMe()
//                .key("remember-key")
//                .rememberMeCookieName("remember-me")
//                .rememberMeParameter("remember-me")
//                .tokenValiditySeconds(24 * 60 * 60)
                .and()
                .logout().logoutUrl("/logOut").logoutSuccessUrl("/pageLogin");

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/profile","/UserTenancyDetail","/allRoom/**","/allTenancy/**","/myTenancy","/myRoom","/detailOne/**","/detailTwo/**").hasAuthority("USER")
                .and()
                .authorizeRequests()
                .antMatchers("/my/dashboard").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/Room").hasAuthority("ADMIN")
                .antMatchers("/api/Feedback","/api/addTenancy").hasAuthority("ADMIN")
                .antMatchers("/feeall").hasAuthority("ADMIN")
                .antMatchers("/fee/**").hasAuthority("ADMIN")
                .antMatchers("/api/Tenancy").hasAuthority("ADMIN")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .and()
                .formLogin();

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/demo/*").permitAll()
                .antMatchers("/403","/about","/Category","/Categoryshtml","/contact","/Feedback").permitAll()
                .antMatchers("/frag","/index","/room/aroom/**","/Roles-html","/services","Users-html",
                        "/room/delete/","/room/update","/fontawesome-fee/**").permitAll()
                .antMatchers("/Admin/dist/**","/dist/plugins/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/uploads/**").permitAll()
                .antMatchers("/updateRoom","/send-email").permitAll()
                .antMatchers("/lib/**").permitAll()
                .antMatchers("/pageLogin").permitAll()
                .antMatchers("/pageRegister").permitAll()
                .antMatchers("/rolez/lsclass").permitAll()
                .antMatchers("/scss/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/*").permitAll()
                .antMatchers("/static/*").permitAll()
                .antMatchers("/test").permitAll()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
