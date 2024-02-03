package br.com.api.produtos.servicos;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    //    Metodo para listar todos os produtos
    public Iterable<ProdutoModelo> listar() {
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrarAtualizar(ProdutoModelo pm, String acao) {
        if (pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório.");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca é obrigatório.");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    public void remove(ProdutoModelo produtoModelo) {
        pr.delete(produtoModelo);
    }




}