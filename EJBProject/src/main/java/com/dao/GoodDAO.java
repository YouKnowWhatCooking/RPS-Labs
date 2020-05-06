package com.dao;
import com.models.Good;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface GoodDAO {
    void insertGood(Good good);
    void updateGood(Good good);
    void deleteGood(int id);
    Good getGoodById(int id);
    List<Good> listOfGoods();
}
