package com.ramon.library_system.repository;

import com.ramon.library_system.entity.Emprestimo;
import com.ramon.library_system.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {


    Optional<Emprestimo> findByLivroAndDataDevolucaoIsNull(Livro livro);
}
