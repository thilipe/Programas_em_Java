package com.minicrm.minicrm.controller;


import com.minicrm.minicrm.model.Cliente;
import com.minicrm.minicrm.model.Contato;
import com.minicrm.minicrm.repository.ClienteRepository;
import com.minicrm.minicrm.repository.ContatoRepository;
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
