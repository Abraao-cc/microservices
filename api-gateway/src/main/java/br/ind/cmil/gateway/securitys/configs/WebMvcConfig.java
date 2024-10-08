package br.ind.cmil.gateway.securitys.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 *
 * @author Administrativo
 */
@Configuration
public class WebMvcConfig {

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin(corsOrigins);
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }

    /**
     * @Bean public CorsFilter corsWebFilter() { CorsConfiguration corsConfig =
     * new CorsConfiguration(); corsConfig.addAllowedOrigin(corsOrigins);
     * corsConfig.addAllowedHeader("*");
     * corsConfig.addAllowedMethod(HttpMethod.GET);
     * corsConfig.addAllowedMethod(HttpMethod.POST);
     * corsConfig.addAllowedMethod(HttpMethod.PUT);
     * corsConfig.addAllowedMethod(HttpMethod.PATCH);
     * corsConfig.addAllowedMethod(HttpMethod.OPTIONS);
     * corsConfig.setAllowCredentials(false);
     *
     * UrlBasedCorsConfigurationSource source = new
     * UrlBasedCorsConfigurationSource();
     * source.registerCorsConfiguration("/**", corsConfig);
     *
     * return new CorsFilter(source); }
     *
     * @Value("${cors.origins}")
     * private String origens;
     *
     * @Bean
     * public WebMvcConfigurer corsConfig() {
     * return new WebMvcConfigurer() {
     * @Override
     * public void addCorsMappings(CorsRegistry registry) {
     * registry.addMapping("/**")
     * .allowedOrigins(origens)
     * .allowedMethods(HttpMethod.GET.name(),
     * HttpMethod.POST.name(),
     * HttpMethod.DELETE.name())
     * .allowedHeaders(HttpHeaders.CONTENT_TYPE,
     * HttpHeaders.AUTHORIZATION);
     * }
     * };
     * }
     *
     *
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
