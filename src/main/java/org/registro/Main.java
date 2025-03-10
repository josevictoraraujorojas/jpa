package org.registro;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) throws Exception {

//        LivroManager livroManager = new LivroManager();
//        livroManager.setup();
//       livroManager.readLivrobyAutores();
//        livroManager.readLivrobyEditora();

        AutorManager autorManager = new AutorManager();
        autorManager.setup();
        autorManager.readAutorbyEditora();
//        autorManager.readAutorbyLivro();



//          EditoraManager editoraManager = new EditoraManager();
//          editoraManager.setup();
//          editoraManager.readEditorabyAutor();



    }
}