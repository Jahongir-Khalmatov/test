package lesson2.data_rest.repository;

//import app_work_with_files.lesson9.entity.Attachment;
import lesson2.data_rest.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
