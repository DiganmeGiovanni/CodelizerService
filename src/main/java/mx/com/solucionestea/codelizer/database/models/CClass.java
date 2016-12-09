package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
public class CClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "cfile_id")
    private CFile cFile;

    @OneToMany(mappedBy = "cClass", cascade = CascadeType.ALL)
    private Collection<CMethod> methods;


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

    public CFile getcFile() {
        return cFile;
    }

    public void setcFile(CFile cFile) {
        this.cFile = cFile;
    }

    public Collection<CMethod> getMethods() {
        return methods;
    }

    public void setMethods(Collection<CMethod> methods) {
        this.methods = methods;
    }
}
