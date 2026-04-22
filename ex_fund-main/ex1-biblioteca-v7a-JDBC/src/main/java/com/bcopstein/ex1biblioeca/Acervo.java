package com.bcopstein.ex1biblioeca;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Acervo {
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private UsuarioSistemaRepository usuarioSistemaRepository;

    @Autowired
    public Acervo(LivroRepository livroRepository, AutorRepository autorRepository, UsuarioSistemaRepository usuarioSistemaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.usuarioSistemaRepository = usuarioSistemaRepository;
    }

    @PostConstruct
    public void init() {
        // Inicializa com dados padrão se o banco estiver vazio
        if (livroRepository.count() == 0) {
            Autor a1 = autorRepository.save(new Autor(1, "Huguinho Pato", LocalDate.of(1987,9,10)));
            Autor a2 = autorRepository.save(new Autor(2,"Zezinho Pato", LocalDate.of(1987,9,10)));
            Autor a3 = autorRepository.save(new Autor(3, "Luizinho Pato", LocalDate.of(1987,9,10)));
            Autor a4 = autorRepository.save(new Autor(4, "Lala Pato", LocalDate.of(1987,9,10)));

            livroRepository.save(new Livro(10, "Introdução ao Java", a1, 2022));
            livroRepository.save(new Livro(20, "Introdução ao Spring-Boot", a2, 2020));
            livroRepository.save(new Livro(15, "Principios SOLID", a3, 2023));
            livroRepository.save(new Livro(17, "Padroes de Projeto", a4, 2019));
            livroRepository.save(new Livro(25, "Usando JPA", a4, 2026));
        }
    }

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public List<String> getTitulos() {
        return getAll()
                .stream()
                .map(livro -> livro.getTitulo())
                .toList();
    }

    public List<Autor> getAutores() {
        return getAll()
                .stream()
                .map(livro -> livro.getAutor())
                .toList();
    }

    public List<Livro> getLivrosDoAutor(String autorNome) {
        return livroRepository.findByAutorNome(autorNome);
    }

    public List<Livro> getLivrosDoAutorEAno(String autor, int ano) {
        return livroRepository.findByAutorNomeAndAno(autor, ano);
    }

    public Livro getLivroTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }

    public List<Livro> getLivrosPorAno(int ano) {
        return livroRepository.findByAno(ano);
    }

    public boolean cadastraLivroNovo(Livro livro) {
        livroRepository.save(livro);
        return true;
    }

    public boolean removeLivro(long codigo) {
        if (livroRepository.existsById(codigo)) {
            livroRepository.deleteById(codigo);
            return true;
        }
        return false;
    }

    public List<Autor> getAllAutores() { return autorRepository.findAll(); }

    public Autor getAutorPorNome (String nome) {
        return autorRepository.findByNome(nome).orElse(null);
    }
    public Livro atualizarLivro(Long id, Livro novo) {
        Livro existente = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        existente.setTitulo(novo.getTitulo());
        existente.setAno(novo.getAno());
        existente.setAutor(novo.getAutor());

        return livroRepository.save(existente);
    }

    public List<Livro> getLivrosAntesDoAno(int ano) {
        return livroRepository.findByAnoLessThan(ano);
    }
}
