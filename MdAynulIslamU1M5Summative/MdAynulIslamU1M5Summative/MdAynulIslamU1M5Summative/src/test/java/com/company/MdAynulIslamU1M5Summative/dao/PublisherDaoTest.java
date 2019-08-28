package com.company.MdAynulIslamU1M5Summative.dao;
import com.company.MdAynulIslamU1M5Summative.model.Book;
import com.company.MdAynulIslamU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {

    // @Autowired annotation tells spring to instantiate these impl class so that we can use the getters and setters and the constructor
    // publisher is the parent of book(in book table publisher id is FK)

    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {

        //clean up the test DB
        // The ORDER of DELETING is very important.
        // Since publisher is the parent of book we need to delete book first then publisher

        List<Book> bList = bookDao.getAllBooks();
        for (Book b : bList) {
            bookDao.deleteBook(b.getBookId());
        }

        List<Publisher> pList = publisherDao.getAllPublishers();
        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }

    }

    @Test
    public void addGetDeletePublisher(){

        //populating the publisher
        Publisher publisher = new Publisher();

        publisher.setName("Universal");
        publisher.setStreet("Brook Lane");
        publisher.setCity("Dhaka");
        publisher.setState("DK");
        publisher.setPostalCode("1204");
        publisher.setPhone("01715523585");
        publisher.setEmail("universal_book@ub.org");

        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1=publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher1,publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());
        publisher1=publisherDao.getPublisher(publisher.getPublisherId());

        assertNull(publisher1);

    }


    @Test
    public void updatePublisher(){

        Publisher publisher = new Publisher();

        publisher.setName("Universal");
        publisher.setStreet("Brook Lane");
        publisher.setCity("Dhaka");
        publisher.setState("DK");
        publisher.setPostalCode("1204");
        publisher.setPhone("01715523585");
        publisher.setEmail("universal_book@ub.org");

        publisher = publisherDao.addPublisher(publisher); // added publisher

        publisher.setName("Pearson");
        publisher.setStreet("River Side");
        publisher.setCity("Upper Saddle");
        publisher.setState("NJ");
        publisher.setPostalCode("07546");
        publisher.setPhone("01674324534");
        publisher.setEmail("pearson_books@pb.org");

        publisherDao.updatePublisher(publisher); // updated publisher


        //passing the updated publisher into a different object
        Publisher publisher1=publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher1,publisher);
    }


    @Test
    public void getAllPublisher(){

        //First publisher
        Publisher publisher = new Publisher();

        publisher.setName("Universal");
        publisher.setStreet("Brook Lane");
        publisher.setCity("Dhaka");
        publisher.setState("DK");
        publisher.setPostalCode("1204");
        publisher.setPhone("01715523585");
        publisher.setEmail("universal_book@ub.org");

        publisher = publisherDao.addPublisher(publisher); // first publisher added


        //second publisher

        publisher=new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("River Side");
        publisher.setCity("Upper Saddle");
        publisher.setState("NJ");
        publisher.setPostalCode("07546");
        publisher.setPhone("01674324534");
        publisher.setEmail("pearson_books@pb.org");

        publisher = publisherDao.addPublisher(publisher); // second publisher added

        //passing two publisher into a List
        List<Publisher> publisherList=publisherDao.getAllPublishers();

        assertEquals(publisherList.size(),2);
    }

}
