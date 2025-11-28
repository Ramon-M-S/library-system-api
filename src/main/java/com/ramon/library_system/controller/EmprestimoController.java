package com.ramon.library_system.controller;

import com.ramon.library_system.dto.EmprestimoDTO;
import com.ramon.library_system.entity.Emprestimo;
import com.ramon.library_system.entity.Livro;
import com.ramon.library_system.repository.EmprestimoRepository;
import com.ramon.library_system.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/biblioteca/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<?> realizarEmprestimo(@RequestBody EmprestimoDTO dto){

        Livro livro = livroRepository.findById(dto.livroId()).orElseThrow(() -> new  RuntimeException("Livro não encontrado"));

        if (emprestimoRepository.findByLivroAndDataDevolucaoIsNull(livro).isPresent()) {
            return ResponseEntity.badRequest().body("Este livro já está emprestado!");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setNomeUsuario(dto.nomeUsuario());
        emprestimo.setDataDeEmprestimo(LocalDate.now());
        return ResponseEntity.ok(emprestimoRepository.save(emprestimo));
    }

    @PutMapping("/{id}/devolver")
    public  ResponseEntity<Emprestimo> devolverLivro(@PathVariable Long id){
        return emprestimoRepository.findById(id)
                .map(emprestimo -> {
                    emprestimo.setDataDevolucao(LocalDate.now());
                    return ResponseEntity.ok(emprestimoRepository.save(emprestimo));
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
