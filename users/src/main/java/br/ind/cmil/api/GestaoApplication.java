package br.ind.cmil.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@SpringBootApplication
public class GestaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoApplication.class, args);
    }
    /*
    @Bean
    CommandLineRunner init(CategoryRepository categoryRepository, LocalizationRepository localRepository) {
        return args -> {
            Stream.of("impressoras", "desktop", "servidor", "switch", "notebooks").forEach(name -> {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            });
            // categoryRepository.findAll().forEach(System.out::println);
            Stream.of("sede", "amt", "ipatinga").forEach(name -> {
                Localization local = new Localization();
                local.setName(name);
                localRepository.save(local);
            });

        };
    }
     */
}
