import jakarta.persistence.*;
import java.util.List;

public class PersonService {
    private EntityManagerFactory emf;

    public PersonService() {
        this.emf = Persistence.createEntityManagerFactory("personPU"); // Подключение JPA Unit
    }

    // Добавление объекта в базу данных
    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    // Обновление объекта в базе данных
    public void updatePerson(Long id, String newName, int newAge) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            person.setName(newName);
            person.setAge(newAge);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Удаление объекта из базы данных
    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Получение всех объектов из базы данных
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        em.close();
        return persons;
    }
}


