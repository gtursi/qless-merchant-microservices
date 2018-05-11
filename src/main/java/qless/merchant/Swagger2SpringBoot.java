package qless.merchant;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Location;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.util.ResourceUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "qless.merchant", "io.swagger.api", "io.swagger.configuration" })
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = ResourceUtils.getFile("classpath:us-locator-etl.json");
//        Location[] locations = objectMapper.readValue(file, Location[].class);
//        Location location = locations[0];
    }

//    @Bean
//    public Stream<Location> getLocationsDB(Supplier<Stream<Location>> locationStreamSupplier){
//        return locationStreamSupplier.get();
//    }

    @Bean
    public Supplier<Stream<Location>> getLocationStreamSupplier() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:us-locator-etl.json");
        Location[] locations = objectMapper.readValue(file, Location[].class);
        Supplier<Stream<Location>> streamSupplier = () -> Stream.of(locations);
        return streamSupplier;
    }


    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
