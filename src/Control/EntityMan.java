/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victoria
 */
public class EntityMan {
    private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("MetodosAgilesPU");
    public EntityMan(){
    
    }
    public static EntityManagerFactory getInstance(){
        return emf;
    }
}
