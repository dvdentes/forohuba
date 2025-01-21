package challenge.forohub.controller;

import challenge.forohub.curso.*;
import challenge.forohub.usuario.DatosActualizarUsuario;
import challenge.forohub.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private CursoService registro;

    @PostMapping
//    public void registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso){
//        repository.save(new Curso(datosRegistroCurso));

            public ResponseEntity<DatosListadoCurso> registrar(@RequestBody @Valid DatosRegistroCurso datos) {
            var curso = registro.registrar(datos);

            var respuesta = new DatosListadoCurso(curso);

            return ResponseEntity.ok(respuesta);

    }

//    @GetMapping 1
//    public List<Curso> listadoCurso(){
//        return repository.findAll();
//    }

    //@GetMapping2
//public List<DatosDetalleRespuesta> listadoRespuestas() {
//    return respuestaRepository.findAll().stream().map(DatosDetalleRespuesta::new).toList();
//}

//    @GetMapping3
//    public Page<DatosListadoCurso> listadoCurso(Pageable paginacion) {
//        return repository.findAll(paginacion).map(DatosListadoCurso::new);
//    }


    @GetMapping
    public Page<DatosListadoCurso> listadoCurso(@PageableDefault(size = 2) Pageable paginacion) {
    return repository.findAll(paginacion).map(DatosListadoCurso::new);
    }

    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso = repository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
    }


}


