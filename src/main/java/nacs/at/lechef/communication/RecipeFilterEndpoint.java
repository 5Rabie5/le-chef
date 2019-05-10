package nacs.at.lechef.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.lechef.logic.RecipesFilter;
import nacs.at.lechef.persistence.domain.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeFilterEndpoint {
  private final RecipesFilter recipesFilter;

  @GetMapping("/type/{type}")
  List<Recipe> filterByType(@PathVariable String type) {
    return recipesFilter.filterByType(type);
  }

  @GetMapping("/labels/{lables}")
  List<Recipe> filterByLables(@PathVariable String[] lablesArray) {
    List<String> lables = Arrays.asList(lablesArray);
    return recipesFilter.filterByLables(lables);
  }

  @GetMapping("/origin/{origin}")
  List<Recipe> filterByOrigin(@PathVariable String origin) {
    return recipesFilter.filterByOrigin(origin);
  }

}
