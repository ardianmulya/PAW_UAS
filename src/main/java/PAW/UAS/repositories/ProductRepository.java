/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PAW.UAS.repositories;

import PAW.UAS.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author M S I
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query("SELECT product FROM Product product WHERE CONCAT (product.id, ' ' ,product.productName, ' ' ,product.price) LIKE %?1%")
    public List<Product> search (String keyword);
    public Product findByproductName(String productName);
}
