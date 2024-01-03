/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.controller;

import PAW.UAS.dto.SearchFormData;
import PAW.UAS.dto.UserDto;
import PAW.UAS.model.Product;
import PAW.UAS.service.ProductService;
import PAW.UAS.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author M S I
 */
@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userDto.setRole("USER");
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfuly!");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage(Model model, Principal principal, @Param("keyword") String keyword) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("user", userDetails);
        List<Product> listProduct = productService.getAllProduct(keyword);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchForm", new SearchFormData());
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage(Model model, Principal principal, @Param("keyword") String keyword) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        List<Product> listProduct = productService.getAllProduct(keyword);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchForm", new SearchFormData());
        return "admin";
    }

    @GetMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("product", productService.findByName(searchFormData.getKeyword()));
        return "admin";
    }
}
