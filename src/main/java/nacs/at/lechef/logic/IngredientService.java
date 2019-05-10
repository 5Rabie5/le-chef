package nacs.at.lechef.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.lechef.persistence.domain.Ingredient;
import nacs.at.lechef.persistence.repository.IngredientsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientService {
  private final IngredientsRepository ingredientsRepository;

  Ingredient save(Ingredient ingredient){
    ingredientsRepository.save(ingredient);
    return ingredient;
  }

  void delete(String id){
    ingredientsRepository.deleteById(id);
  }

}
