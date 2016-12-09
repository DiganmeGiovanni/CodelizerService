package mx.com.solucionestea.codelizer.database.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Entity
public class PModule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String path;
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
