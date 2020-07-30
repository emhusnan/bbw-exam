package id.emhusnan.exam.bbw.authorization.repository;

import id.emhusnan.exam.bbw.authorization.model.ApiAudit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends CrudRepository<ApiAudit, Long> {

}
