package com.bcopstein.ex1biblioeca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class Controller {
    private final Acervo livros;
    public final EstatisticasAutor estatisticas;
    private UsuarioSistemaService usuarioSistemaService;

    @Autowired
    public Controller(Acervo livros,EstatisticasAutor estatisticas, UsuarioSistemaService usuarioSistemaService) {
        this.livros = livros; 
        this.estatisticas = estatisticas;
        this.usuarioSistemaService= usuarioSistemaService;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return livros.getAll();
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<Autor> getListaAutores() {
        return livros.getAutores();
    }

    @GetMapping("livrosautor")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        estatisticas.informaConsultaAutor(autor.trim());
        return livros.getLivrosDoAutor(autor.trim());
    }

    @GetMapping("autorMaisConsultado")
    @CrossOrigin(origins = "*")
    public String getAutorMaisConsultado() {
        return estatisticas.autorMaisConsultado();
    }

    @GetMapping("autorMenosConsultado")
    @CrossOrigin(origins = "*")
    public String getAutorMenosConsultado() {
        return estatisticas.autorMenosConsultado();
    }

    @GetMapping("/livros-autor-ano")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value="autor") String autor, @RequestParam(value="ano")int ano) {
        estatisticas.informaConsultaAutor(autor.trim());
        return livros.getLivrosDoAutorEAno(autor, ano);
    }

    @GetMapping("/livrosPorAno")
    public List<Livro> getLivrosPorAno(@RequestParam int ano) {
        return livros.getLivrosPorAno(ano);
    }

    @GetMapping("/desatualizados/{ano}")
    public List<Livro> getDesatualizados(@PathVariable int ano) {
        return livros.getLivrosAntesDoAno(ano);
    }

    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return livros.cadastraLivroNovo(livro);
    }

    @PostMapping("/usuarios-sistema")
    public boolean cadastrarUsuarioSistema(
            @RequestBody NovoUsuarioSistemaRequest novo) {

        return usuarioSistemaService.cadastrar(novo);
    }

    @PostMapping("/livros/{id}")
    @CrossOrigin(origins = "*")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return livros.atualizarLivro(id, livroAtualizado);
    }

    @PostMapping("/removelivro/{codigo}")
    @CrossOrigin(origins = "*")
    public boolean removeLivro(@PathVariable(value="codigo") long codigo) {
        return livros.removeLivro(codigo);
    }
}