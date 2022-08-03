package co.com.ikitech.model.guardianship.Attachment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AttachmentRepository {

    Mono<Attachment> save(Attachment attachment);

    Flux<Attachment> findAll();

    Mono<Attachment> findById(String id);

    Mono<Void> delete(String id);
}
