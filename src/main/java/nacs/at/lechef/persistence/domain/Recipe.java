package nacs.at.lechef.persistence.domain;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
  private String id;
  private String type;
  private List<String> labels;
  private String origin;
  private String title;
  private List<Ingredient> ingredients;
}
