package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
public class CMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String access;

    @NotNull
    private String type;

    @ManyToOne
    @JoinColumn(name = "cclass_id")
    private CClass cClass;

    @OneToMany(mappedBy = "cMethod", cascade = CascadeType.ALL)
    private Collection<CParameter> parameters;


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

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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
