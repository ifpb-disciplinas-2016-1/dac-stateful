package ifpb.dac.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Ricardo Job
 */
@Stateful
@Remote(Carrinho.class)
public class CarrinhoDeCompra implements Carrinho {

    private List<String> produtos = new ArrayList<>();

    public void add(String produto) {
        System.out.println("Produto adicionado: " + produto);
        this.produtos.add(produto);
    }

    @Override
    @Remove
    public void finalizar() {
        System.out.println("O carrinho possui: " + produtos.size() + " elementos");
        for (String string : produtos) {
            System.out.println("Produto: " + string);
        }
    }
}
