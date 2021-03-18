package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Input;
import realproject.lesson11.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {

}
