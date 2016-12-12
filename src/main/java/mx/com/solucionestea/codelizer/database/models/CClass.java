package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 *
 * Created by giovanni on 8/12/16.
 */
@Entity
@Table(name = "c_classes")
public class CClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "c_files_id")
    private CFile cFile;

    @OneToMany(mappedBy = "cClass", cascade = CascadeType.ALL)
    private Collection<CMethod> methods;


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
