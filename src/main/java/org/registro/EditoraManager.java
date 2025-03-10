package org.registro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class EditoraManager {
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

    public void create(Editora editora) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(editora);
        session.getTransaction().commit();
        session.close();
    }
    public void delete() {
        Session session = sessionFactory.openSession();
        Editora editora = new Editora();
        editora.setCodigo(1);
        session.beginTransaction();
        session.delete(editora);
        session.getTransaction().commit();
        session.close();
    }

    public void readEditorabyLivro(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("Livro.findEditoraByTitulo");
        query.setParameter("titulo", "Java with Spring");
        session.getTransaction().commit();
        System.out.println("editora por livro --------------------");
        System.out.println(query.list().get(0));
        session.close();
    }

    public void readEditorabyAutor(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("Livro.findEditoraByAutor");
        query.setParameter("nome", "Joao");
        List<Editora> editoras = query.list();
        session.getTransaction().commit();
        System.out.println("editora por autor --------------------");
        for (Editora editora : editoras) {
            System.out.println(editora);
        }
        session.close();
    }
}
