package nacs.at.lechef.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeEndpoint {
  private final RecipeRepository recipeRepository;

  @GetMapping
  List<Recipe> get() {
    return recipeRepository.findAll();
  }

  @PostMapping
  Recipe post(@RequestBody Recipe recipe) {
    recipeRepository.save(recipe);
    return recipe;
  }
}
