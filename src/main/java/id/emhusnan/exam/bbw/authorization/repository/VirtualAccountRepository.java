package id.emhusnan.exam.bbw.authorization.repository;

import id.emhusnan.exam.bbw.authorization.model.ApiAudit;
import id.emhusnan.exam.bbw.authorization.model.VirtualAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualAccountRepository extends CrudRepository<VirtualAccount, Long> {

    VirtualAccount findByClientId(String clientId);
}
