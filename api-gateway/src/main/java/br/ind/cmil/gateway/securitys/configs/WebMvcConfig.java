package br.ind.cmil.gateway.securitys.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Administrativo
 */
@Configuration

public class WebMvcConfig {

    @Value("${cors.origins}")
    private String origens;

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(origens)
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name())
                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION);
            }
        };
    }

    /**
     * @Override public void addCorsMappings(CorsRegistry registry) {
     *
     * registry.addMapping("/**") .allowedOrigins("http://localhost:4200/**")
     * .allowedOrigins("*") .allowedHeaders("*") .allowedMethods("GET", "PUT",
     * "POST", "PATCH", "DELETE", "OPTIONS"); }
     *
     * @Bean CorsConfigurationSource corsConfigurationSource() {
     * CorsConfiguration configuration = new
     * CorsConfiguration().applyPermitDefaultValues();
     * configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT",
     * "DELETE")); final UrlBasedCorsConfigurationSource source = new
     * UrlBasedCorsConfigurationSource();
     * source.registerCorsConfiguration("/**", configuration); return source; }
     */
}
