package realproject.lesson11.repository;

//import app_work_with_files.lesson9.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    Optional<AttachmentContent> findByAttachment_Id(Integer attachment_id);
}
