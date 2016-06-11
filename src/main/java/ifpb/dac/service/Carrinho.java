package ifpb.dac.service;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ricardo Job
 */
//@Remote
public interface Carrinho {

    public void add(String produto);
    
    public void del(String produto);

    public void finalizar();
    
    public List<String> listaDeProdutos();

}
