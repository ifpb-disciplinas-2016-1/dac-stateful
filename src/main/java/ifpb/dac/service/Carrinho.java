/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
