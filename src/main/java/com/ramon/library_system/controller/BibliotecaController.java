package com.ramon.library_system.controller;

import com.ramon.library_system.entity.Autor;
import com.ramon.library_system.entity.Livro;
import com.ramon.library_system.repository.AutorRepository;
import com.ramon.library_system.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    // 1. Cadastrar Autor
    @PostMapping("/autores")
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    // 2. Listar Autores (traz os livros juntos)
    @GetMapping("/autores")
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // 3. Cadastrar Livro vinculando a um Autor (IMPORTANTE!)
    @PostMapping("/autores/{autorId}/livros")
    public ResponseEntity<Livro> criarLivro(@PathVariable Long autorId, @RequestBody Livro livro) {
        // Busca o autor pelo ID, se não achar, lança erro
        return autorRepository.findById(autorId)
                .map(autor -> {
                    livro.setAutor(autor);
                    return ResponseEntity.ok(livroRepository.save(livro));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
