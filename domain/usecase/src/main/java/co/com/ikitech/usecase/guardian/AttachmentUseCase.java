package co.com.ikitech.usecase.guardian;

import co.com.ikitech.model.guardianship.Attachment.Attachment;
import co.com.ikitech.model.guardianship.Attachment.AttachmentOperations;
import co.com.ikitech.model.guardianship.Attachment.AttachmentRepository;
import co.com.ikitech.model.guardianship.error.AttachmentMessageError;
import co.com.ikitech.model.guardianship.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AttachmentUseCase implements AttachmentOperations {

    private final AttachmentRepository repository;
    public Mono<Attachment> findById(String id) {

        return repository.findById(id);
    };

    public Mono<Attachment> create(Attachment att){

        return Mono.just(att)
                .switchIfEmpty(Mono.error(new AppException(AttachmentMessageError.ATTACHMENT_Not_Create.value)))
                .flatMap(repository::save);
    }

    public Mono<Void> delete(String id){

        return repository.findById(id)
                .switchIfEmpty(Mono.error(new AppException(AttachmentMessageError.ATTACHMENT_Not_Exist.value))).then();
    }

    public Flux<Attachment> getAll(){

        return repository.findAll();
    }

    public Mono<Attachment> update(Attachment model, String id){

        return Mono.just(model)
                .flatMap(m -> repository.findById(model.getId()))
                .flatMap(modelDB -> this.updateModel(model, modelDB))
                .flatMap(repository::save)
                .switchIfEmpty(Mono.error(new AppException(AttachmentMessageError.ATTACHMENT_Not_Exist.value)));
    }
}
