package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import com.mysql.cj.log.Log;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1L;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1L);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoPorNome("Xiamoi Redmi");
        System.out.println(precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Xiamoi Redmi","Muito legal",new BigDecimal("800"), celulares);


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        em.persist(celulares);
        celulares.setNome("XPTO");


        em.getTransaction().commit();
        em.clear();

//        celulares = em.merge(celulares);
//        celulares.setNome("1234");
//        em.getTransaction().commit();

//        em.remove(celulares);
//        em.getTransaction().commit();
//        em.flush();
    }
}
