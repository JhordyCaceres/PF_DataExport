package model;

import java.util.Date;

public class Person {

    private Integer ID;
    private String NOM;
    private String APEPAT;
    private String APEMAT;
    private String SEXPER;
    private Date FECNAC;
    private String DNI;

    public Person() {
    }

    public Person(Integer ID, String NOM, String APEPAT, String APEMAT, String SEXPER, Date FECNAC, String DNI) {
        this.ID = ID;
        this.NOM = NOM;
        this.APEPAT = APEPAT;
        this.APEMAT = APEMAT;
        this.SEXPER = SEXPER;
        this.FECNAC = FECNAC;
        this.DNI = DNI;
    }

    
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getAPEPAT() {
        return APEPAT;
    }

    public void setAPEPAT(String APEPAT) {
        this.APEPAT = APEPAT;
    }

    public String getAPEMAT() {
        return APEMAT;
    }

    public void setAPEMAT(String APEMAT) {
        this.APEMAT = APEMAT;
    }

    public String getSEXPER() {
        return SEXPER;
    }

    public void setSEXPER(String SEXPER) {
        this.SEXPER = SEXPER;
    }

    public Date getFECNAC() {
        return FECNAC;
    }

    public void setFECNAC(Date FECNAC) {
        this.FECNAC = FECNAC;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}
