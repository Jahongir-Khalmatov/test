package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomComment;

@RepositoryRestResource(path = "comments",excerptProjection = CustomComment.class)
public interface CommentsRepository extends JpaRepository<Comments, Integer> {


}
