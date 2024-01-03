/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.service;

import PAW.UAS.model.Product;
import PAW.UAS.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author M S I
 */
@Service
public class ProductServiceImplement implements ProductService{
    
    @Autowired ProductRepository productRepository;
    
    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Employee not found for id : " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(long id) {
       this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProduct(String keyword) {
        if (keyword != null){
            return productRepository.search(keyword);
        }else
            return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
            Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                    Sort.by(sortField).descending();
            
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
            return this.productRepository.findAll(pageable);
    }
    
    @Override
        public List<Product> findByName (String keyword){
        return productRepository.search(keyword);
    }
    
}
