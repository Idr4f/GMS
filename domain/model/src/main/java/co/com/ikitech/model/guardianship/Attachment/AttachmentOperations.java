package co.com.ikitech.model.guardianship.Attachment;

import reactor.core.publisher.Mono;

public interface AttachmentOperations {

    default Mono<Attachment> disable(Attachment model){

        return Mono.just(model.toBuilder().build());
    }

    default Mono<Attachment> updateModel(Attachment model, Attachment modelDB){

        return Mono.just(modelDB.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .active(model.getActive())
                .type(model.getType())
                .build());
    }
}
