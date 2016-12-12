package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
@Table(name = "c_parameters")
public class CParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    private String comment;

    @NotNull
    private String type;

    @ManyToOne
    @JoinColumn(name = "c_methods_id")
    private CMethod cMethod;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CMethod getcMethod() {
        return cMethod;
    }

    public void setcMethod(CMethod cMethod) {
        this.cMethod = cMethod;
    }
}
