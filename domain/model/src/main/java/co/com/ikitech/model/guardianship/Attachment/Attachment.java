package co.com.ikitech.model.guardianship.Attachment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Attachment {

    private String id;
    private String name;
    private String description;
    private Boolean active;
    private String type;

}
