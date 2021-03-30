package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomArticle;

@RepositoryRestResource(path = "article",excerptProjection = CustomArticle.class)
public interface ArticleRepository extends JpaRepository<Article, Integer> {


}
