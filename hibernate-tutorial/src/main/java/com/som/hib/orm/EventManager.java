package com.som.hib.orm;

import com.som.hib.orm.domain.Event;
import com.som.hib.orm.domain.Person;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

//        mgr.createAndStorePerson(27, "firstName", "lastName");

        mgr.addEmailToPerson(6L, "som@santa.com");

//        mgr.addPersonToEvent2(2L, 7L);

//        if (args[0].equals("store")) {
//            mgr.createAndStoreEvent("My Event", new Date());
//        } else if (args[0].equals("list")) {
//            List events = mgr.listEvents();
//            for (Object event : events) {
//                Event theEvent = (Event) event;
//                System.out.println(
//                        "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
//                );
//            }
//        }

        HibernateUtil.getSessionFactory().close();
    }

    private void addEmailToPerson(Long personId, String emailAddress) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        // adding to the emailAddress collection might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }

    private void createAndStorePerson(int age, String firstName, String lastName){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person person =  new Person();
        person.setAge(age);
        person.setFirstname(firstName);
        person.setLastname(lastName);

        Long id = (Long) session.save(person);
        System.out.println("PERSON_ID: " + person.getId());
        System.out.println("PERSON_ID: " + id);
        session.getTransaction().commit();

    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        System.out.println("EVENT_ID: " + theEvent.getId());

        session.getTransaction().commit();
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private void addPersonToEvent(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);
        aPerson.getEvents().add(anEvent);

        session.getTransaction().commit();
    }

    private void addPersonToEvent2(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session
                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached
        Event anEvent = (Event) session.load(Event.class, eventId);

        session.getTransaction().commit();

        // End of first unit of work

        aPerson.getEvents().add(anEvent); // aPerson (and its collection) is detached

        // Begin second unit of work

        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        session2.update(aPerson); // Reattachment of aPerson

        session2.getTransaction().commit();
    }

}