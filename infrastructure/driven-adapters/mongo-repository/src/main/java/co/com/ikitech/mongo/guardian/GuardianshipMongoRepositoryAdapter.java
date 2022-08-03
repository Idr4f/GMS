package co.com.ikitech.mongo.guardian;

import co.com.ikitech.model.guardianship.guardianship.Guardianship;
import co.com.ikitech.model.guardianship.guardianship.GuardianshipRepository;
import co.com.ikitech.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class GuardianshipMongoRepositoryAdapter extends AdapterOperations<Guardianship/* change for domain model */, GuardianshipEntity/* change for adapter model */, String, GuardianshipMongoDBRepository>
 implements GuardianshipRepository
{

    public GuardianshipMongoRepositoryAdapter(GuardianshipMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper. map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Guardianship.class/* change for domain model */));
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
