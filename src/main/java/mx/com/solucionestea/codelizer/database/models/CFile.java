package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Entity
@Table(name = "c_files")
public class CFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "file_name")
    private String fileName;
    private String path;

    @ManyToOne
    @JoinColumn(name = "p_modules_id")
    private PModule pModule;

    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private Analysis analysis;

    @OneToMany(mappedBy = "cFile", cascade = CascadeType.ALL)
    private Collection<CClass> classes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public PModule getpModule() {
        return pModule;
    }

    public void setpModule(PModule pModule) {
        this.pModule = pModule;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public Collection<CClass> getClasses() {
        return classes;
    }

    public void setClasses(Collection<CClass> classes) {
        this.classes = classes;
    }
}
