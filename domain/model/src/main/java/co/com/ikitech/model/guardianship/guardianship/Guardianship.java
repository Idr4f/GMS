package co.com.ikitech.model.guardianship.guardianship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)

public class Guardianship {

    private String id;
    private String name;
    private String description;
  //  private Attachment attachment;

}
