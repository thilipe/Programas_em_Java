package com.minicrm.controller;


import com.minicrm.model.Cliente;
import com.minicrm.model.Contato;
import com.minicrm.repository.ClienteRepository;
import com.minicrm.repository.ContatoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;


    public ClienteController(ClienteRepository clienteRepository,  ContatoRepository contatoRepository ){

        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;

    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente payLoad){

        Cliente cliente = clienteRepository.save(payLoad);
        return ResponseEntity.created(URI.create("/clientes/"+cliente.getId())).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente payLoad){

        var opt = clienteRepository.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        var cliente = opt.get();
        // ATUALIZE CAMPO A CAMPO
        cliente.setNome(payLoad.getNome());
        cliente.setEmail(payLoad.getEmail());

        var salvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }


    @PostMapping("/{id}/contatos")
    public ResponseEntity<Contato> criarContato(@PathVariable Long id, @RequestBody Contato payLoad){

        var opt = clienteRepository.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        var cliente = opt.get();
        payLoad.setId(null);
        payLoad.setCliente(cliente);
        var salvo = contatoRepository.save(payLoad);
        return ResponseEntity.created(URI.create("/clientes/"+id+"/contatos/"+salvo.getId())).body(salvo);
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<Contato>> listarContatos(@PathVariable Long id){

        var opt = clienteRepository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else {
            var cliente = opt.get();
            var contatos = cliente.getContatos();
            return ResponseEntity.ok(contatos);
        }
    }

}
