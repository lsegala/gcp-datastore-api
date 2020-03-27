package br.edu.lsegala.simplecrudapi.controller;

import br.edu.lsegala.simplecrudapi.model.Caso;
import br.edu.lsegala.simplecrudapi.repository.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin("http://localhost:3000")
@RolesAllowed("hasRole('ROLE_CLIENT')")
@RequestMapping("/casos")
public class CasoController {
    @Autowired
    private CasoRepository casoRepository;

    @GetMapping
    public List<Caso> findAll(){
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        casoRepository.findAll().iterator(), Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Caso> findById(@PathVariable Long id){
        return casoRepository.findById(id)
                .map(p -> ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Caso save(@RequestBody Caso caso){
        return casoRepository.save(caso);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Caso> update(@PathVariable Long id,
                                         @RequestBody Caso caso){
        return casoRepository.findById(id)
                .map(casoExistente -> {
                    casoExistente.acesso = caso.acesso;
                    casoExistente.clientes = caso.clientes;
                    casoExistente.descricao = caso.descricao;
                    casoExistente.observacoes = caso.observacoes;
                    casoExistente.pasta = caso.pasta;
                    casoExistente.responsavel = caso.responsavel;
                    casoExistente.titulo = caso.titulo;
                    return ResponseEntity.ok().body(casoRepository.save(casoExistente));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id){
        casoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "_deleteAll")
    public ResponseEntity<Void> deleteAll(){
        casoRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
