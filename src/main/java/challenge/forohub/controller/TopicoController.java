package challenge.forohub.controller;

import challenge.forohub.topico.*;
import challenge.forohub.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService registro;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosListadoTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        var topico = registro.registrar(datos);

        var respuesta = new DatosListadoTopico(topico);

        return ResponseEntity.ok(respuesta);
    }


    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }





    @PutMapping
    @Transactional
    public ResponseEntity<?> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.findById(datosActualizarTopico.id())
                .orElseThrow(() -> new EntityNotFoundException("Topico no encontrado"));

        topico.actualizarDatos(datosActualizarTopico, usuarioRepository);
        topicoRepository.save(topico);

        return ResponseEntity.ok("Topico actualizado correctamente");
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminaTopico(@PathVariable Long id) {
        //Buscamo el tópico a eliminar
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        Topico topico = new Topico();
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

}





