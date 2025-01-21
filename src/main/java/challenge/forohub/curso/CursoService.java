package challenge.forohub.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso registrar(DatosRegistroCurso datos){

        var curso = new Curso(datos);
        return cursoRepository.save(curso);

    }

}


