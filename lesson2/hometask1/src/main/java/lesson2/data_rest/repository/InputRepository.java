package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "input")

public interface InputRepository extends JpaRepository<Input,Integer> {

}
