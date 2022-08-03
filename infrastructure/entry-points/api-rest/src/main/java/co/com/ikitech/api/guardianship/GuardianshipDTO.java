package co.com.ikitech.api.guardianship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class GuardianshipDTO {

    private String id;
    private String name;
    private String description;
   // private String attachment;
}
