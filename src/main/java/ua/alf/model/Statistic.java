package ua.alf.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:09
 */
@Entity
public class Statistic {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Language language;
    @Column
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column
    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", language=" + language +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
