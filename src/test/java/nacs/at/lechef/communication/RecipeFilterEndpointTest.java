package nacs.at.lechef.communication;

import nacs.at.lechef.logic.RecipesFilter;
import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecipeFilterEndpointTest {
  @Autowired
  TestRestTemplate restTemplate;
  @SpyBean
  RecipesFilter recipesFilter;
  @MockBean
  RecipeRepository recipeRepository;

  @Test
  void filterByType() {
    String url = "/recipes/type/soup";
    restTemplate.getForObject(url, Recipe[].class);
    verify(recipesFilter).filterByType(anyString());
  }

  @Test
  void filterByLables() {
    String url = "/recipes/lables/" + anyList().toString();
    restTemplate.getForObject(url, Recipe[].class);
    verify(recipesFilter).filterByLables(anyList());
  }

  @Test
  void filterByOrigin() {
    String url = "/recipes/origin/usa";
    restTemplate.getForObject(url, Recipe[].class);
    verify(recipesFilter).filterByOrigin(anyString());
  }
}