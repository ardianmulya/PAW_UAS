/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PAW.UAS.repositories;

import PAW.UAS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author M S I
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);
}
