package web.witcher.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.witcher.Entities.MonsterType;

import java.util.List;

@Repository
public interface MonsterTypeRepositories extends JpaRepository<MonsterType, Long> {

}
