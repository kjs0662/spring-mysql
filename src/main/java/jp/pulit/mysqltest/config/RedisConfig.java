package jp.pulit.mysqltest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;


@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1000)
@Configuration
public class RedisConfig extends AbstractHttpSessionApplicationInitializer {

}
