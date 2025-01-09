package gr.hua.dit.ds.assignement.rent_express.services;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Realty;
import gr.hua.dit.ds.assignement.rent_express.repositories.OwnerRepository;
import gr.hua.dit.ds.assignement.rent_express.repositories.RealtyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtyService {

    private RealtyRepository realtyRepository;
    private OwnerRepository ownerRepository;

    public RealtyService(RealtyRepository realtyRepository, OwnerRepository ownerRepository) {
        this.realtyRepository = realtyRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public List<Realty> getRealties(){
        return realtyRepository.findAll();
    }

    @Transactional
    public Realty getRealty(Integer id){
        return realtyRepository.findById(id).get();
    }

    @Transactional
    public void saveRealty(Realty realty){
        realtyRepository.save(realty);
    }

    @Transactional
    public void assignOwnerToRealty(Integer realtyId, Integer ownerId){
        Realty realty = realtyRepository.findById(realtyId).get();
        Owner owner = ownerRepository.findById(ownerId).get();
        realty.setOwner(owner);
        owner.getRealties().add(realty);
        ownerRepository.save(owner);
        realtyRepository.save(realty);
    }
}
