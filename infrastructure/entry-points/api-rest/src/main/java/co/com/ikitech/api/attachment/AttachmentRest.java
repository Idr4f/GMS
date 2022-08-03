package co.com.ikitech.api.attachment;

import co.com.ikitech.model.guardianship.Attachment.Attachment;
import co.com.ikitech.usecase.guardian.AttachmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AttachmentRest {
    private final AttachmentUseCase useCase;

    @PostMapping(path = "/att", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Attachment> create(@RequestHeader(name = "Accept-Language", required = false)
                                                            final Locale locale,
                                   @RequestBody Attachment att){

        return useCase.create(att);
    }

    @PutMapping(path = "/att/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Attachment> update(@RequestHeader(name = "Accept-Language", required = false)
                                 final Locale locale,
                                   @RequestBody Attachment att,
                                   @PathVariable String id){

        return useCase.update(att, id);
    }

    @GetMapping(path = "/att")
    public Flux<Attachment> getAllAttachments(){

        return useCase.getAll();
    }

    @GetMapping(path = "/att/{id}")
    public Mono<Attachment> getAttByID(@PathVariable String id) {

        return useCase.findById(id);
    }

    @DeleteMapping(path = "/att/{id}")
    public Mono<Void> deleteAttById(@PathVariable String id){

        return useCase.delete(id);
    }
}
