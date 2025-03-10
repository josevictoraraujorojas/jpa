package org.registro;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class AutorManager {
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

    public void create(Autor autor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(autor);
        session.getTransaction().commit();
        session.close();
    }
    public void delete() {
        Session session = sessionFactory.openSession();
        Autor autor = new Autor();
        autor.setCodigo(1);
        session.beginTransaction();
        session.delete(autor);
        session.getTransaction().commit();
        session.close();
    }
    public void readAutorbyLivro(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("Livro.findAutoresByTitulo");
        query.setParameter("titulo", "Java with Spring");
        List<Autor> autores = query.list();
        session.getTransaction().commit();
        System.out.println("autores por livro --------------------");
        for (Autor autor : autores) {
            System.out.println(autor);
        }

        session.close();
    }

    public void readAutorbyEditora(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("Livro.findAutorByEditora");
        query.setParameter("nome", "Pearson");
        List<Autor> autores = query.list();
        session.getTransaction().commit();
        System.out.println("autores por Editora --------------------");
        for (Autor autor : autores) {
            System.out.println(autor);
        }
        session.close();
    }
}
