package gr.hua.dit.ds.assignement.rent_express.services;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Request;
import gr.hua.dit.ds.assignement.rent_express.repositories.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    @Transactional
    public Owner getOwner(Integer id){
        return ownerRepository.findById(id).get();
    }

    @Transactional
    public void saveOwner(Owner owner){
        ownerRepository.save(owner);
    }

}
