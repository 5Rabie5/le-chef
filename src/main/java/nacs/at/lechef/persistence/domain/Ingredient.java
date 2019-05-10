package nacs.at.lechef.persistence.domain;

import lombok.Data;

@Data
public class Ingredient {
  private String id;
  private String name;
  private int amount;
}
