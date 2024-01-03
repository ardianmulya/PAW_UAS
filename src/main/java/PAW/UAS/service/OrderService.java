/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.service;

import PAW.UAS.model.Order;
import PAW.UAS.repositories.OrderRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author M S I
 */
@Service
@Transactional
public class OrderService {
     @Autowired
    private OrderRepo repo;
// fungsi untuk return course

    public Iterable<Order> findAll() {
        return repo.findAll();
    }
// Function create order data

    public void addorder(Order order) {
        repo.save(order);
    }
//function delete

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
//function edit

    public Optional<Order> findById(Long id) {
        return repo.findById(id);
    }
//function update

    public void updateorder(Order order) {
        repo.save(order);
    }
}
