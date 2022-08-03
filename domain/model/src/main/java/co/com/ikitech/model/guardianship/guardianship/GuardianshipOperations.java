package co.com.ikitech.model.guardianship.guardianship;

import reactor.core.publisher.Mono;

public interface GuardianshipOperations {

    default Mono<Guardianship> disable(Guardianship model){

        return Mono.just(model.toBuilder().build());
    }

    default Mono<Guardianship> updateModel(Guardianship model, Guardianship modelDB){

        return Mono.just(modelDB.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
//                .attachment(Attachment.builder()
//                        .id(att.getId())
//                        .name(att.getName())
//                        .description(att.getDescription())
//                        .active(att.getActive())
//                        .type(att.getType())
//                        .build())
                .build());
    }
}
