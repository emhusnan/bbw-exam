package id.emhusnan.exam.bbw.authorization.repository;

import id.emhusnan.exam.bbw.authorization.model.VirtualAccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualAccountTransactionRepository extends CrudRepository<VirtualAccountTransaction, Long> {

}
