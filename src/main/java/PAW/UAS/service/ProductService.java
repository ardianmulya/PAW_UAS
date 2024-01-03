/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PAW.UAS.service;

import PAW.UAS.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author M S I
 */
public interface ProductService {
    Product saveProduct(Product product);
    Product getProductById(long id);
    
    void deleteProductById (long id);
    List<Product> findByName (String keyword);
    List<Product> getAllProduct(String keyword);
    Page<Product> findPaginated(int pageNo,int pageSize,String sortField,String sortDir);
}
