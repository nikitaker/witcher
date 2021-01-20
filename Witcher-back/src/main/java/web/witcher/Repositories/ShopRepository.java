package web.witcher.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.Shop;
import web.witcher.Repositories.Custom.CustomRepository;

@Repository
public interface ShopRepository extends CustomRepository<Shop, String> {

}
