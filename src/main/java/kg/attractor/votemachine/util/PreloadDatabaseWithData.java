package kg.attractor.votemachine.util;


import kg.attractor.votemachine.model.Task;
import kg.attractor.votemachine.model.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {

    @Bean
   CommandLineRunner initDatabase(TaskRepository repository) {

        repository.deleteAll();

        return (args) -> Stream.of(tasks())
                .peek(System.out::println)
                .forEach(repository::save);
    }

   private Task[] tasks() {
        return new Task[]{
                new Task("Clean"),
                new Task("Study"),
                new Task("Walk"),
                new Task("Do homework")};
    }
}
