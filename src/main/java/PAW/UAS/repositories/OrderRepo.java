/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PAW.UAS.repositories;

import PAW.UAS.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author M S I
 */
public interface OrderRepo extends CrudRepository<Order, Long>{
    
}
