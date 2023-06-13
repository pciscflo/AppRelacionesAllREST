package com.upc.apprelacionesallrest.model.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Stream")
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    //mappedBy indica que la relación es bidireccional y que la columna "followedStreams"
    // en la clase View es la propietaria de la relación.
    @ManyToMany(mappedBy = "followedStreams",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Viewer> followers = new ArrayList<>();

    public Stream(String name) {
        this.name = name;
    }

    public Stream() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Viewer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Viewer> followers) {
        this.followers = followers;
    }

}
