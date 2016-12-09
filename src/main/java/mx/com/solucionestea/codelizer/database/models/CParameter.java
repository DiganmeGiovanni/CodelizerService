package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
public class CParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @ManyToOne
    @JoinColumn(name = "cmethod_id")
    private CMethod cMethod;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
