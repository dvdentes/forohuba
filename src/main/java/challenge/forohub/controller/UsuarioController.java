package challenge.forohub.controller;

import challenge.forohub.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        usuarioRepository.save(new Usuario(datosRegistroUsuario));

    }



    @GetMapping
    public Page<DatosListadoUsuario> listadoUsuarios(Pageable paginacion){
        return usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new);
    }



    @PutMapping
    @Transactional
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatos(datosActualizarUsuario);
    }



}
