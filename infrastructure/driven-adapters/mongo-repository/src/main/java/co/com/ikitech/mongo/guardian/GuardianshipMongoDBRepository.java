package co.com.ikitech.mongo.guardian;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface GuardianshipMongoDBRepository extends ReactiveMongoRepository<GuardianshipEntity/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<GuardianshipEntity/* change for adapter model */> {
}
