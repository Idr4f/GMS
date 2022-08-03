package co.com.ikitech.mongo.guardian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "guardian")
public class GuardianshipEntity {

    @Id
    private String id;
    private String name;
     private String description;
    // private String attachment;
}
