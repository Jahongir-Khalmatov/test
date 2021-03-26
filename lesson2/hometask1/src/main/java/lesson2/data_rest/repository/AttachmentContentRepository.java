package lesson2.data_rest.repository;

//import app_work_with_files.lesson9.entity.AttachmentContent;
import lesson2.data_rest.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    Optional<AttachmentContent> findByAttachment_Id(Integer attachment_id);
}
