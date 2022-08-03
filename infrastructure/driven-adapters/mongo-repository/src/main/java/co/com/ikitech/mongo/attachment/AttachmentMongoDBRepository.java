package co.com.ikitech.mongo.attachment;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface AttachmentMongoDBRepository extends ReactiveMongoRepository<AttachmentEntity/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<AttachmentEntity/* change for adapter model */> {
}
