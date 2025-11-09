package customer.service.crm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import customer.service.crm.Entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long>{

	Optional<UserEntity> findByEmail(String email);	
	
	Boolean existsByEmail(String email);

}
