package co.com.ikitech.api.guardianship;

import co.com.ikitech.api.ikitech.IkitechRestService;
import co.com.ikitech.model.guardianship.guardianship.Guardianship;
import co.com.ikitech.usecase.guardian.GuardianshipUseCase;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class GuardianshipRest extends IkitechRestService<GuardianshipDTO, Guardianship> {
    private final GuardianshipUseCase useCase;

    private final GuardianshipMapper MAPPER = Mappers.getMapper(GuardianshipMapper.class);

    @PostMapping(path = "/guard", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Map<String, Object>>> create(@RequestHeader(name = "Accept-Language", required = false)
                                                            final Locale locale,
                                          @RequestBody GuardianshipDTO dto){

        return Mono.just(dto)
                .flatMap(dataTransfer -> useCase.create(MAPPER.toEntity(dataTransfer))
                        .map(businessObject -> createResponseSuccess(businessObject,
                                MAPPER::toTransferObject)));
    }

    @PutMapping(path = "/guard/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Map<String, Object>>>  update(@RequestHeader(name = "Accept-Language", required = false) final Locale locale,
                                                             @Valid @RequestBody GuardianshipDTO dto,
                                                             @PathVariable String id) {
        return Mono.just(dto)
                .flatMap(dataTransfer -> useCase.update(MAPPER.toEntity(dataTransfer), id)
                        .map(businessObject -> createResponseSuccess(businessObject,
                                MAPPER::toTransferObject)));
    }

    @GetMapping(path = "/guard")
    public Flux<Guardianship> getAllGuards(){

        return useCase.getAll();
    }

    @GetMapping(path = "/guard/{id}")
    public Mono<Guardianship> getGuardByID(@PathVariable String id) {

        return useCase.findById(id);
    }

    @DeleteMapping(path = "/guard/{id}")
    public Mono<Void> delete(@PathVariable String id) {

        return useCase.delete(id);
    }
}
