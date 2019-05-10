package nacs.at.lechef.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipesFilter {
  private final RecipeRepository recipeRepository;

  public List<Recipe> filterByType(String type) {

    return recipeRepository.findAllByTypeIs(type);
  }

  public List<Recipe> filterByLables(List<String> lables) {
    return recipeRepository.findAllByLabelsIn(lables);
  }

  public List<Recipe> filterByOrigin(String origin) {
    return recipeRepository.findAllByOriginIs(origin);
  }
}
