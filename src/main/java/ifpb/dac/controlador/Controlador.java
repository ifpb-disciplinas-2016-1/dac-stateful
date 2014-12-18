package ifpb.dac.controlador;

import ifpb.dac.service.Carrinho;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Job
 */
@ManagedBean(name = "controlador")
@SessionScoped
public class Controlador implements Serializable {

    private String produto;

    @EJB
    private Carrinho carrinho;

    public Controlador() {
        produtos= new ArrayList<>();
    }

    public String add() {
        carrinho.add(produto);
//        produtos.add(produto);// = carrinho.listaDeProdutos();
        produto = new String();
        
        produtos = carrinho.listaDeProdutos();
        return null;
    }

    public String finalizar() {
        carrinho.finalizar();
        produtos = new ArrayList<>();
        logout();
        return null;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String logout() {
        //Redireciona o usuário para tela de login efetuando o logout.  
        String loginPage = "/index.jsf";
        ExternalContext context = FacesContext.getCurrentInstance().
                getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.
                getRequest();
        HttpSession session = (HttpSession) context.
                getSession(false);
        session.invalidate();
        try {
            context.redirect(request.getContextPath() + loginPage);
        } catch (IOException e) {
            //logger.error("Erro ao tentar redirecionar para página solicitada ao efetuar Logout: " + e.toString());  
        }

        return null;
    }

    private List<String> produtos;

    public List<String> getProdutos() {
//        System.out.println("Essa lista está invocada: "+produtos.size());
        return produtos;
    }
    
    public String removerProduto(String p){
        carrinho.del(p);
        produtos = carrinho.listaDeProdutos();
        return null;
    }
 

}
