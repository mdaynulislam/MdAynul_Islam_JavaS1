package com.company.U2M3Summative.dao;
import com.company.U2M3Summative.model.TShirt;

import java.util.List;

public interface TShirtsDao {
    //CRUD

    TShirt addTShirt(TShirt tShirt);

    TShirt getTShirt(int tShirtId);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tShirt);

    void deleteTShirt(int tShirtId);

    //get T-shirt by by color

    List<TShirt> getTShirtsByColor(String color);

    //get T Shirt by Size

    List<TShirt> getTShirtBySize(String size);
}
