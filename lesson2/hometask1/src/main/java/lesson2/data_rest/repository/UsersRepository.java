package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")

public interface UsersRepository extends JpaRepository<Users,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
