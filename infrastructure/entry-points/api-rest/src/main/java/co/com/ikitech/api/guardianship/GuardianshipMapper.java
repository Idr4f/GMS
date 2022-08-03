package co.com.ikitech.api.guardianship;

import co.com.ikitech.model.guardianship.guardianship.Guardianship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GuardianshipMapper {

    @Mapping(target = "id", source = "id",
            defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    Guardianship toEntity(GuardianshipDTO dto);

    GuardianshipDTO toTransferObject(Guardianship model);
}
