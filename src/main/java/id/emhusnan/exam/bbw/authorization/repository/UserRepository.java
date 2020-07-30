package id.emhusnan.exam.bbw.authorization.repository;

import id.emhusnan.exam.bbw.authorization.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
