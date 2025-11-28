package com.ramon.library_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    private LocalDate dataDeEmprestimo = LocalDate.now();

    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;
}
