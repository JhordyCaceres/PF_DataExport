package dao;

import java.util.List;

public interface DAO<T> {

    /**
     *
     * @return
     * @throws java.lang.Exception
     */
    List<T> all() throws Exception;

    /**
     *
     * @param modelo
     * @throws java.lang.Exception
     */
    void create(T modelo) throws Exception;

    /**
     *
     * @param modelo
     * @throws java.lang.Exception
     */
    void modify(T modelo) throws Exception;

    /**
     *
     * @param id
     * @throws java.lang.Exception
     */
    void delete(Object id) throws Exception;
}
