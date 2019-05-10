package nacs.at.lechef.persistence.repository;

import nacs.at.lechef.persistence.domain.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientsRepository extends MongoRepository<Ingredient,String> {
}
