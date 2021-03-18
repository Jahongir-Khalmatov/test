package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {

}
