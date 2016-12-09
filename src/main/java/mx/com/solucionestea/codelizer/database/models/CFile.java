package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Entity
@Table(name = "CFile")
public class CFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    private String path;

    @ManyToOne
    @JoinColumn(name = "cmodule_id")
    private CModule cModule;

    @OneToMany(mappedBy = "cFile", cascade = CascadeType.ALL)
    private Collection<CClass> classes;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CModule getcModule() {
        return cModule;
    }

    public void setcModule(CModule cModule) {
        this.cModule = cModule;
    }

    public Collection<CClass> getClasses() {
        return classes;
    }

    public void setClasses(Collection<CClass> classes) {
        this.classes = classes;
    }
}
