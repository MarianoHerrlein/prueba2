package com.miportfolio.nombre.Service;

import com.miportfolio.nombre.Entity.Persona;
import com.miportfolio.nombre.Interface.IPersonaService;
import com.miportfolio.nombre.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona=ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonaRepository.save(persona);
    }

    @Override
    public void delatePersona(Long id) {
       ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona fiendPersona(Long id) {
       Persona persona=ipersonaRepository.findById(id).orElse(null);
       return persona;
    }

    @Override
    public Persona findPersona(Long l) {
        
       Persona persona=ipersonaRepository.findById((long)1).orElse(null);
       return persona;
    }
}
