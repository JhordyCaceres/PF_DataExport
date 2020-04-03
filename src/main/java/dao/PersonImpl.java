package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Person;

public class PersonImpl extends Connection implements DAO<Person> {

    @Override
    public List<Person> all() {
        List list = new ArrayList();
        String query = "SELECT * FROM PERSONA";
        ResultSet rs;
        try {
            rs = this.conectar().createStatement().executeQuery(query);
            while (rs.next()) {
                Person model = new Person();
                model.setID(rs.getInt("IDPER"));
                model.setDNI(rs.getString("DNIPER"));
                model.setNOM(rs.getString("NOMPER"));
                model.setAPEPAT(rs.getString("APEPATPER"));
                model.setAPEMAT(rs.getString("APEMATPER"));
                model.setSEXPER(rs.getString("SEXPER"));
                model.setFECNAC(rs.getDate("FECNACPER"));
                list.add(model);
            }
        } catch (SQLException ex) {
            System.out.println("dao.PersonImpl.all()");
        }
        return list;
    }

    @Override
    public void create(Person modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(Person modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
