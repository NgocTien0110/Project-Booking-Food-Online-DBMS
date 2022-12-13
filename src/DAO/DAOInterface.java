package DAO;

import java.util.ArrayList;

public interface DAOInterface<T>{
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
