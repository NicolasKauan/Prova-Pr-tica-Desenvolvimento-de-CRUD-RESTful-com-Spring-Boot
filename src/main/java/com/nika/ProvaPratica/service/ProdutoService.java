package com.nika.ProvaPratica.service;

import com.nika.ProvaPratica.model.ProdutoModel;
import com.nika.ProvaPratica.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //Criar
    public ProdutoModel criar(ProdutoModel produto) {
        return repository.save(produto);
    }

    //Listar
    public List<ProdutoModel> listar() {
        return repository.findAll();
    }

    //Buscar produto por id
    public ProdutoModel buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    //Atualizar por id
    public ProdutoModel atualizar(Long id, ProdutoModel produtoAtualizado) {
        Optional<ProdutoModel> produtoExistente = repository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoModel produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setStatusProduto(produtoAtualizado.getStatusProduto());

            return repository.save(produto);
        }else {
            throw new RuntimeException("Nenhum produto encontrado, para o id: "+id);
        }
    }

    //Deletar por id
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
