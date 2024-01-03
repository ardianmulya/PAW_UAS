/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author M S I
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry){
        exposeDirectory("product-photos", registry);
    }
    
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry){
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        
        registry.addResourceHandler("/" + dirName + "/").addResourceLocations("file:/"+ uploadPath + "/");
    }
}
