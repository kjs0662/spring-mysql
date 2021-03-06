package jp.pulit.mysqltest.config;

import jp.pulit.mysqltest.Auth.AuthFailureHandler;
import jp.pulit.mysqltest.Auth.AuthProvider;
import jp.pulit.mysqltest.Auth.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthProvider authProvider;
    private final AuthFailureHandler authFailureHandler;
    private final AuthSuccessHandler authSuccessHandler;

    public SecurityConfig (AuthProvider authProvider, AuthFailureHandler authFailureHandler, AuthSuccessHandler authSuccessHandler) {
        this.authProvider = authProvider;
        this.authFailureHandler = authFailureHandler;
        this.authSuccessHandler = authSuccessHandler;
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 로그인 설정
        http.authorizeRequests()
                // ROLE_USER, ROLE_ADMIN으로 권한 분리 유알엘 정의
                .antMatchers("/login").permitAll()
                .and()
                // 로그인 페이지 및 성공 url, handler 그리고 로그인 시 사용되는 id, password 파라미터 정의
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureHandler(authFailureHandler)
                .successHandler(authSuccessHandler)
                .usernameParameter("id")
                .passwordParameter("password")
                .and()
                // 로그아웃 관련 설정
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                // csrf 사용유무 설정
                // csrf 설정을 사용하면 모든 request에 csrf 값을 함께 전달해야한다.
                .csrf().disable()
                // 로그인 프로세스가 진행될 provider
                .authenticationProvider(authProvider);

    }
}
