package realproject.lesson11.repository;

//import app_work_with_files.lesson9.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
