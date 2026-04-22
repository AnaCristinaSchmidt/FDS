package com.bcopstein.ex1biblioeca;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorNome(String nome);
    List<Livro> findByAutorNomeAndAno(String nome, int ano);
    Livro findByTitulo(String titulo);
    List<Livro> findByAno(int ano);
    List<Livro> findByAnoLessThan(int ano);
}