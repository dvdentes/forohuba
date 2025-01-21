package challenge.forohub.controller;

import challenge.forohub.respuesta.*;
import challenge.forohub.topico.DatosActualizarTopico;
import challenge.forohub.topico.Topico;
import challenge.forohub.topico.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private RespuestaService registro;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosListadoRespuesta> registrar(@RequestBody @Valid DatosRegistroRespuesta datos) {
        var respuesta = registro.registrar(datos);

        var contesta = new DatosListadoRespuesta(respuesta);

        return ResponseEntity.ok(contesta);
    }

    @GetMapping
    public Page<DatosListadoRespuesta> listadoRespuestas(Pageable paginacion) {
    return respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new);
    }

//    @GetMapping 1
//    public List<DatosListadoRespuesta> listadoRespuestas() {
//        return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
//    }

//    @PutMapping
//    @Transactional
//    public void actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta){
//        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
//        respuesta.actualizarDatos(datosActualizarRespuesta);
//    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datos) {
        Respuesta respuesta = respuestaRepository.findById(datos.id())
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrado"));

        respuesta.actualizarDatos(datos, topicoRepository);
        respuestaRepository.save(respuesta);

        return ResponseEntity.ok("Topico actualizado correctamente");
    }

//    @PutMapping
//    @Transactional
//    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
//        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
//        topico.actualizarDatos(datosActualizarTopico);
//    }
}

//@GetMapping
//public List<DatosDetalleTopico> listadoTopicos() {
//    return topicoRepository.findAll().stream().map(DatosDetalleTopico::new).toList();
//}