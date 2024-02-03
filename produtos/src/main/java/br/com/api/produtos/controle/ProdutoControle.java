package br.com.api.produtos.controle;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @DeleteMapping("/deletar")
    public void deletarProduto(@RequestBody ProdutoModelo produtoModelo) {
        ps.remove(produtoModelo);
    }

    @PutMapping("/update")
    public ResponseEntity<?> atualizarCadastro(@RequestBody ProdutoModelo produtoModelo) {
        return ps.cadastrarAtualizar(produtoModelo, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoModelo produtoModelo) {
        return ps.cadastrarAtualizar(produtoModelo, "cadastrar");
    }
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> list() {
        return ps.listar();
    }
    @GetMapping("/")
    public String rota() {
        return "Api de produtos funcionando corretamente";
    }




}
