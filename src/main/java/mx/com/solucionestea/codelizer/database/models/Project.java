package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import java.util.List;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<PModule> pModules;


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

    public List<PModule> getpModules() {
        return pModules;
    }

    public void setpModules(List<PModule> pModules) {
        this.pModules = pModules;
    }
}
