package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
@Table(name = "c_methods")
public class CMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;
    private String comment;
    private String encapsulation;

    @NotNull
    private String type;

    @ManyToOne
    @JoinColumn(name = "c_classes_id")
    private CClass cClass;

    @OneToMany(mappedBy = "cMethod", cascade = CascadeType.ALL)
    private Collection<CParameter> parameters;


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

    public String getEncapsulation() {
        return encapsulation;
    }

    public void setEncapsulation(String encapsulation) {
        this.encapsulation = encapsulation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CClass getcClass() {
        return cClass;
    }

    public void setcClass(CClass cClass) {
        this.cClass = cClass;
    }

    public Collection<CParameter> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<CParameter> parameters) {
        this.parameters = parameters;
    }
}
