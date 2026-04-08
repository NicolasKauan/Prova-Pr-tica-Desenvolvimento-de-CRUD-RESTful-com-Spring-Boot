package com.nika.ProvaPratica.repositories;

import com.nika.ProvaPratica.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
