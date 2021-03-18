package appapilesson1.hometask1.repository;

import appapilesson1.hometask1.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
