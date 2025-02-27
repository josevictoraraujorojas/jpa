package org.registro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class LivroManager {

    private static SessionFactory sessionFactory;
    public void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();


        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
    }

    public void create() {
        Editora editora = new Editora();
        editora.setNome("Pearson");

        Autor autor = new Autor();
        autor.setNome("Martin");

        Autor autor2 = new Autor();
        autor2.setNome("Joao");

        List<Autor> autores = new ArrayList<Autor>();
        autores.add(autor);
        autores.add(autor2);

        Livro livro = new Livro();
        livro.setTitulo("Java with Spring");
        livro.setPreco(new BigDecimal("412.65"));
        livro.setLancamento(LocalDate.of(2019, Month.APRIL,25));
        livro.setEditora(editora);
        livro.setAutores(autores);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(livro);
        session.getTransaction().commit();
        session.close();
    }
}
