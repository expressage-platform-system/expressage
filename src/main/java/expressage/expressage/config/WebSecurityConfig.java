package expressage.expressage.config;


import expressage.expressage.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth
            .inMemoryAuthentication()
            .passwordEncoder(passwordEncoder).withUser(username).password(passwordEncoder.encode(password)).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/code/**", "/font/**", "/img/**", "/js/**","/notice/**", "/express/**","/login","/admin/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .anonymous()
                .and()
            .formLogin()
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .successHandler(new LoginSuccessHandler())
                .failureUrl("/login?error")
                .and()
                .csrf().disable();
    }
}
