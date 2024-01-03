/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PAW.UAS.service;

import PAW.UAS.dto.UserDto;
import PAW.UAS.model.User;

/**
 *
 * @author M S I
 */
public interface UserService {
    User save (UserDto userDto);
}
