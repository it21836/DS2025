package gr.hua.dit.ds.assignement.rent_express.services;

import gr.hua.dit.ds.assignement.rent_express.entities.Renter;
import gr.hua.dit.ds.assignement.rent_express.repositories.RenterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {

    private RenterRepository renterRepository;

    public RenterService(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Transactional
    public List<Renter> getRenters(){
        return renterRepository.findAll();
    }

    @Transactional
    public Renter getRenter(Integer id){
        return renterRepository.findById(id).get();
    }

    @Transactional
    public void saveRenter(Renter renter){
        renterRepository.save(renter);
    }
}
