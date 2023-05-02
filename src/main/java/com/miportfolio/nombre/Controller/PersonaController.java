package com.miportfolio.nombre.Controller;

import com.miportfolio.nombre.Entity.Persona;
import com.miportfolio.nombre.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("persona/traer")
    public List<Persona> getPersona(){
    return ipersonaService.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
       ipersonaService.savePersona(persona);
       return "La persona fue creada correctamente";
    }
    
   @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.delatePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //URL:PUERTO/personas/editar/4/nombre & apellido & img
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
                    @RequestParam("nombre") String nuevoNombre,
                    @RequestParam("apellido") String nuevoApellido,
                    @RequestParam("img") String nuevoImg){
        
        Persona persona = ipersonaService.fiendPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
 @GetMapping("/persona/traer/perfil")
public Persona findPersona(){
    return ipersonaService.findPersona((long)1);

}  
}
    
