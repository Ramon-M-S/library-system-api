package com.ramon.library_system.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatorio")
    private  String titulo;

    private  String isbn;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIgnore
    private  Autor autor;

}
