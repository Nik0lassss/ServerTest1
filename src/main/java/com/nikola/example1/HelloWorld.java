package com.nikola.example1;
import com.nikola.example1.entity.User;
import com.nikola.example1.persistence.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * Created by Nikola on 9/4/2015.
 */

    @Path("/hello")
    public class HelloWorld {
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String getMessage() {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            User user = new User();

            user.setFirstName("Alexander");
            user.setLastName("Barchuk");

            session.save(user);
            session.getTransaction().commit();
            return "Hello world!";
        }
    }

