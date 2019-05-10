package nacs.at.lechef.logic;

import nacs.at.lechef.RecipeConfiguration;
import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecipesFilterTest {

  @Autowired
  private List<Recipe> recipes;

  @Autowired
  RecipesFilter recipesFilter;
  @Autowired
  RecipeRepository recipeRepository;

  @BeforeEach
  void setUp() {
    recipeRepository.saveAll(recipes);
  }

  @Test
  void filterByType() {
    assertThat(recipesFilter.filterByType("soup").size()).isEqualTo(4);
  }

  @Test
  void filterByLables() {
    List<String> labels = Arrays.asList("vegan", "spicy");
    assertThat(recipesFilter.filterByLables(labels).size()).isEqualTo(8);
  }

  @Test
  void filterByOrigin() {
    assertThat(recipesFilter.filterByOrigin("usa").size()).isEqualTo(2);
  }
}