package ifpb.dac.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Ricardo Job
 */
@Stateful
@Remote(Carrinho.class)
//@StatefulTimeout(unit = TimeUnit.SECONDS, value = 20)
public class CarrinhoDeCompra implements Carrinho {

    private List<String> produtos = new ArrayList<>();
    

    public void add(String produto) {
        System.out.println("Produto adicionado: " + produto);
        this.produtos.add(produto);
    }

    @Override
    @Remove
    public void finalizar() {
        System.out.println("-----------------------------");
        System.out.println("O carrinho possui: " + produtos.size() + " elementos");       
        produtos.forEach( s -> {System.out.println("Produto: " + s);});        
        System.out.println("-----------------------------");        
    }

    @Override
    public List<String> listaDeProdutos() {
        return produtos;
    }

    @Override
    public void del(String produto) {
        produtos.remove(produto);
    }

    @PreDestroy
    public void dist() {
        System.out.println("-- Finalizando o carrinho --");
    }
}
