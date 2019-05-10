package nacs.at.lechef.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.lechef.persistence.domain.Ingredient;
import nacs.at.lechef.persistence.domain.Recipe;
import nacs.at.lechef.persistence.repository.IngredientsRepository;
import nacs.at.lechef.persistence.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientEndpoint {
  private final IngredientsRepository ingredientsRepository;

  @GetMapping
  List<Ingredient> get() {
    return ingredientsRepository.findAll();
  }

  @PostMapping
  Ingredient post(@RequestBody Ingredient ingredient) {
    ingredientsRepository.save(ingredient);
    return ingredient;
  }
}
