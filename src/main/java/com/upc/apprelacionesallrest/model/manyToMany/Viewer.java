package com.upc.apprelacionesallrest.model.manyToMany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Viewer")
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//LAZZY en session @Transactional
    @JoinTable(
            name = "followed_streams",
            joinColumns = @JoinColumn(name = "viewer_id"),
            inverseJoinColumns = @JoinColumn(name = "stream_id")
    )
    //Columna followedStream propietaria
    private List<Stream> followedStreams = new ArrayList<>();

    public Viewer(String nickname) {
        this.nickname = nickname;
    }

    public Viewer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Stream> getFollowedStreams() {
        return followedStreams;
    }

    public void setFollowedStreams(List<Stream> followedStreams) {
        this.followedStreams = followedStreams;
    }
}
