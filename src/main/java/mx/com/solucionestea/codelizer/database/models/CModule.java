package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Entity
@Table(name = "CModule")
public class CModule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pmodule_id")
    private PModule pModule;

    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private Analysis analysis;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cModule")
    private Collection<CFile> cFiles;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Collection<CFile> getcFiles() {
        return cFiles;
    }

    public void setcFiles(Collection<CFile> cFiles) {
        this.cFiles = cFiles;
    }
}
