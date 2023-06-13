package com.upc.apprelacionesallrest.negocio;

import com.upc.apprelacionesallrest.model.manyToMany.Stream;
import com.upc.apprelacionesallrest.model.manyToMany.Viewer;
import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Cart;
import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.University;
import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Owner;
import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.User;
import com.upc.apprelacionesallrest.repository.manyToMany.StreamRepository;
import com.upc.apprelacionesallrest.repository.manyToMany.ViewerRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.bidirectional.CartRepository;
import com.upc.apprelacionesallrest.repository.oneToMany.unidirectional.UniversityRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.bidirectional.OwnerRepository;
import com.upc.apprelacionesallrest.repository.oneToOne.unidirectional.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Negocio {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ViewerRepository viewerRepository;
    @Autowired
    private StreamRepository streamRepository;

    @Transactional
    public User grabar(User user){
      return userRepository.save(user);
    }

    public List<User> listarUsers() {
        return userRepository.findAll();
    }

    public List<Owner> listOwners() {
        return ownerRepository.findAll();
    }

    public University saveUniversity(University university) {
       return universityRepository.save(university);
    }

    public List<University> listUniversities() {
        return universityRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCar(Long id) throws Exception {
        return cartRepository.findById(id).orElseThrow(() ->new Exception("No existe"));
    }
    @Transactional
    public void registrarViewer(Viewer viewer){
        System.out.println("Ok");
        /*Viewer anaViewer = new Viewer("Ana");
        Stream nataciolStream = new Stream("Natacion Free");
        viewer.getFollowedStreams().add(nataciolStream);*/
        viewerRepository.save(viewer);
    }
    @Transactional
    public void grabarTablaIntermediaManytoMany(Long id_viewer, Long id_stream){
        Viewer xViewer = viewerRepository.findById(id_viewer).get();
        Stream yStream = streamRepository.findById(id_stream).get();
        xViewer.getFollowedStreams().add(yStream);
        yStream.getFollowers().add(xViewer);
        viewerRepository.save(xViewer);
        streamRepository.save(yStream);
    }
}
