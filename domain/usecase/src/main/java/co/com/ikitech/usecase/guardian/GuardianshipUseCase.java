package co.com.ikitech.usecase.guardian;

import co.com.ikitech.model.guardianship.error.GuardianMessageError;
import co.com.ikitech.model.guardianship.exceptions.AppException;
import co.com.ikitech.model.guardianship.guardianship.Guardianship;
import co.com.ikitech.model.guardianship.guardianship.GuardianshipOperations;
import co.com.ikitech.model.guardianship.guardianship.GuardianshipRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GuardianshipUseCase implements GuardianshipOperations {

    private final GuardianshipRepository repository;
    public Mono<Guardianship> findById(String id) {

        return repository.findById(id);
    };

    public Mono<Guardianship> create(Guardianship guard){

        return Mono.just(guard)
                .switchIfEmpty(Mono.error(new AppException(GuardianMessageError.GUARDIAN_Not_Create.value)))
                .flatMap(repository::save);
    }

    public Mono<Void> delete(String id){

        repository.findById(id).switchIfEmpty(Mono.error(new AppException(GuardianMessageError.GUARDIAN_Not_Exist.value)));

        return repository.delete(id);
    }

    public Flux<Guardianship> getAll(){

        return repository.findAll();
    }

    public Mono<Guardianship> update(Guardianship model, String id) {

        model.setId(id);
        return Mono.just(model)
                .flatMap(m -> repository.findById(id))
                .flatMap(modelDB -> this.updateModel(model, modelDB)
                .flatMap(repository::save)
                .switchIfEmpty(Mono.error(new AppException(GuardianMessageError.GUARDIAN_Not_Exist.value))));
    }
}
