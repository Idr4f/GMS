package co.com.ikitech.model.guardianship.guardianship;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GuardianshipRepository {

    Mono<Guardianship> save(Guardianship guard);

    Flux<Guardianship> findAll();

    Mono<Guardianship> findById(String id);

    Mono<Void> delete(String id);
}
