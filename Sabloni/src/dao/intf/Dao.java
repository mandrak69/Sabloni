package dao.intf;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public  interface Dao<T, EntityManager> {
	
    Optional<T> getById(int id);
    Optional<T> getByName(String name);
    Collection<T> getAll();
    
    void saveAll(Collection<T> collection);
    Collection<T> getAllByPredicate(Predicate<T> predicate);
    
    int save(T t);
    void update(T t);
    void delete(T t);
    void printAll();
    T makeCopyOfMe(T t);
   
    void executeInsideTransaction(Consumer<EntityManager> action); 
     /*   EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }*/
    
    
}
