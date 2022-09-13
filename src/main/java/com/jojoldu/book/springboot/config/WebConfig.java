package com.jojoldu.book.springboot.config;

import com.jojoldu.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/** LoginUserArgumentResolver 가 스프링에 인식하기 위해 WebConfig 파일 만듬
 *
 */

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        /**
         * HandlerMethodArgumentResolver 는 항상 WebMvcConfigurer의 addArgumentResolvers 를 통해 추가해야 함
         */
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
