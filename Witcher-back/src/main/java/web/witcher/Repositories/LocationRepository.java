package web.witcher.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.witcher.Entities.Location;
import web.witcher.Repositories.Custom.CustomRepository;

public interface LocationRepository extends CustomRepository<Location, Long> {

}
