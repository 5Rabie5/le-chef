package nacs.at.lechef;

import lombok.Getter;
import lombok.Setter;
import nacs.at.lechef.persistence.domain.Recipe;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties("dataset")
public class RecipeConfiguration {
  private List<Recipe> recipes;

  @Bean
  List<Recipe> recipes() {
    return recipes;
  }
}
