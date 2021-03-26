package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Users;
import lesson2.data_rest.projection.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users",excerptProjection = CustomUser.class)

public interface UsersRepository extends JpaRepository<Users,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
