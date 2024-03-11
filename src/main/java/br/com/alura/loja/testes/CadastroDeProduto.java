package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Produto;

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
        Produto celular = new Produto();

        celular.setNome("Xiamoi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
