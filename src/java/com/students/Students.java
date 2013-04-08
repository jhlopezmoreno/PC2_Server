/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.students;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author s7263
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByIdbooster", query = "SELECT s FROM Students s WHERE s.idbooster = :idbooster"),
    @NamedQuery(name = "Students.findByFirstname", query = "SELECT s FROM Students s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Students.findByLastname", query = "SELECT s FROM Students s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Students.findByBirthday", query = "SELECT s FROM Students s WHERE s.birthday = :birthday")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbooster")
    private Integer idbooster;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public Students() {
    }

    public Students(Integer idbooster) {
        this.idbooster = idbooster;
    }

    public Integer getIdbooster() {
        return idbooster;
    }

    public void setIdbooster(Integer idbooster) {
        this.idbooster = idbooster;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbooster != null ? idbooster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.idbooster == null && other.idbooster != null) || (this.idbooster != null && !this.idbooster.equals(other.idbooster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.students.Students[ idbooster=" + idbooster + " ]";
    }
    
}
