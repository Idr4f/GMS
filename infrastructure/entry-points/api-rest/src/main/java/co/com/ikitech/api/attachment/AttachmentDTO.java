package co.com.ikitech.api.attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class AttachmentDTO {

    private String id;
    private String name;
    private String description;
    private Boolean active;
    private String type;
}
