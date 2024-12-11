package academia.demo.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academia.demo.academia.model.academiaModel;
import academia.demo.academia.repository.academiaRepository;


@Service
public class academiaService {
	
	@Autowired
    private academiaRepository academiaRepository;

   
    public academiaModel createAcademia(academiaModel academia) {
        if (academia.getId() == null) {
            academia.setId(UUID.randomUUID());  
        }
        return academiaRepository.save(academia); 
    }

    
    public academiaModel getAcademiaById(UUID id) {
        Optional<academiaModel> academia = academiaRepository.findById(id);
        return academia.orElse(null);  
    }

   
    public List<academiaModel> getAllAcademias() {
        List<academiaModel> academias = academiaRepository.findAll();
        System.out.println("Dados do banco: " + academias);
        return academias;
    }

}
