package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Article;
import lesson2.hometask2_pcmarket.entity.Attachment;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Article.class)
public interface CustomArticle {
     Integer getId();

     String getTitle();

     String getDescription();

     String getUrlLink();
     Attachment getAttachment();
}
