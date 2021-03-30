package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import lesson2.hometask2_pcmarket.projection.CustomProduct;

import java.util.List;

@RepositoryRestResource(path = "product",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @RestResource(path="searchByName", rel="searchByName")
    List<Product> findAllByNameContainsIgnoreCase(@Param("searchByName") String searchByName);

    @RestResource(path="searchByCharacteristics", rel="searchByCharacteristics")
    @Query(value = "select * from product p where p.id in (select product_id from charachteristics c where c.type =:type  and c.size =:size )",nativeQuery = true)
    List<Product> searchByCharacteristics(@Param("type") String type, @Param("size") Integer size);

    @RestResource(path="searchByGraphicCard", rel="searchByGraphicCard")
    @Query(value = "select * from product p where p.id in (select product_id from charachteristics c where c.type =:type  and c.name =:name )",nativeQuery = true)
    List<Product> searchByGraphicCard(@Param("type") String type, @Param("name") String name);

    @RestResource(path="searchByModel", rel="searchByModel")
    @Query(value = "select * from product p where p.model=:name",nativeQuery = true)
    List<Product> searchByModel(@Param("name") String name);

    @RestResource(path="searchByPrice", rel="searchByPrice")
    @Query(value = "select * from product p where p.price >:min and p.price<:max",nativeQuery = true)
    List<Product> searchByPrice(@Param("min") Integer min, @Param("max") Integer max);

}
