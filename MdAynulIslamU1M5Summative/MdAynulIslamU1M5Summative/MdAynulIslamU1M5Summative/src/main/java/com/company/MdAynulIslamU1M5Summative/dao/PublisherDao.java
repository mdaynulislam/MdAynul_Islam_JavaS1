package com.company.MdAynulIslamU1M5Summative.dao;

import com.company.MdAynulIslamU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    //create, read, readAll, update, delete

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);

}
