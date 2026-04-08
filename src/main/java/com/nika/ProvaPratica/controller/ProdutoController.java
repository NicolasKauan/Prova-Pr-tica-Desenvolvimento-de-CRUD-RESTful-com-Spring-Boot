package com.nika.ProvaPratica.controller;

import com.nika.ProvaPratica.model.ProdutoModel;
import com.nika.ProvaPratica.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    //Criar = 201
    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto){
        ProdutoModel salvar = service.criar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    //Listar = 200(ok)
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> produto = service.listar();
        return ResponseEntity.ok().body(produto);
    }

    //Buscar = 200(ok) or 404(error)
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscar(@PathVariable Long id){
        try {
            ProdutoModel produto = service.buscar(id);
            return ResponseEntity.ok(produto);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //Atualizar = 200(ok) or 404(error)
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoAtualizado){
        try {
            ProdutoModel produto = service.atualizar(id, produtoAtualizado);
            return ResponseEntity.ok(produto);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    //Deletar = 204 or 404
    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoModel> deletar(@PathVariable Long id){
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
