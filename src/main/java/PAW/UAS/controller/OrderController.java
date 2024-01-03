/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.controller;

import PAW.UAS.model.Order;
import PAW.UAS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author M S I
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String courses(Model model) {
        model.addAttribute("activePage", "order");
        model.addAttribute("order", orderService.findAll());
        return "order";
    }
    
        @GetMapping("/order-customer")
    public String order(Model model) {
        model.addAttribute("activePage", "order");
        model.addAttribute("order", orderService.findAll());
        return "order_customer";
    }
    
    @GetMapping("/addOrder")
    public String addExam(Model model) {
        model.addAttribute("activePage", "order");
        model.addAttribute("order", new Order());
        return "addOrder";
    }

    @PostMapping("/save")
    public String save(Order order, Model model) {
        orderService.addorder(order);
        return "redirect:/order";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
// Panggil service untuk melakukan penghapusan
        orderService.deleteById(id);
// Redirect ke halaman "/exam"
        return "redirect:/order";
    }

    @GetMapping("/editOrder/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
// Panggil service untuk melakukan edit
        model.addAttribute("order", orderService.findById(id));
// membuka halaman "/exam"
        return "editOrder";
    }

    @PostMapping("/update")
    public String update(Order order, Model model) {
// call service update
        orderService.updateorder(order);
        // redirect ke halaman "/exam"
        return "redirect:/order";
    }
}
