package co.com.ikitech.mongo.attachment;

import co.com.ikitech.model.guardianship.Attachment.Attachment;
import co.com.ikitech.model.guardianship.Attachment.AttachmentRepository;
import co.com.ikitech.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class AttachmentMongoRepositoryAdapter extends AdapterOperations<Attachment/* change for domain model */, AttachmentEntity/* change for adapter model */, String, AttachmentMongoDBRepository>
 implements AttachmentRepository
{

    public AttachmentMongoRepositoryAdapter(AttachmentMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper. map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Attachment.class/* change for domain model */));
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
