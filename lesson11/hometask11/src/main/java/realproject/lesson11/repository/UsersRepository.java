package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
