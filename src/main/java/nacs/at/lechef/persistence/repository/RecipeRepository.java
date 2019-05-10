package nacs.at.lechef.persistence.repository;

import nacs.at.lechef.persistence.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
  List<Recipe> findAllByTypeIs(String type);

  List<Recipe> findAllByLabelsIn(List<String> labels);

  List<Recipe> findAllByOriginIs(String origin);
}
