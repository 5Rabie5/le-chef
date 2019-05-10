package nacs.at.lechef.communication;

import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecipeEndpointTest {
  private Recipe recipe = new Recipe();
  @Autowired
  TestRestTemplate restTemplate;

  @MockBean
  RecipeRepository recipeRepository;

  @Test
  void post() {
    String url = "/recipes";
    restTemplate.postForObject(url, recipe, Recipe.class);
    verify(recipeRepository).save(recipe);
  }
}