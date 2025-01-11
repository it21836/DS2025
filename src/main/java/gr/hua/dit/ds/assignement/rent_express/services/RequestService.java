package gr.hua.dit.ds.assignement.rent_express.services;

import gr.hua.dit.ds.assignement.rent_express.entities.Realty;
import gr.hua.dit.ds.assignement.rent_express.entities.Request;
import gr.hua.dit.ds.assignement.rent_express.repositories.RealtyRepository;
import gr.hua.dit.ds.assignement.rent_express.repositories.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private RequestRepository requestRepository;
    private RealtyRepository realtyRepository;

    public RequestService(RequestRepository requestRepository, RealtyRepository realtyRepository) {
        this.requestRepository = requestRepository;
        this.realtyRepository = realtyRepository;
    }

    @Transactional
    public List<Request> getRequests(){
        return requestRepository.findAll();
    }

    @Transactional
    public Request getRequest(Integer id){
        return requestRepository.findById(id).get();
    }

    @Transactional
    public void saveRequest(Request request){
        requestRepository.save(request);
    }

//    @Transactional
//    public void assignRealtyToRequest(Integer realtyId, Integer requestId){
//        Realty realty = realtyRepository.findById(realtyId).get();
//        Request request = requestRepository.findById(requestId).get();
//        request.setRealty(realty);
//        realty.getRentRequests().add(request);
//        realtyRepository.save(realty);
//        requestRepository.save(request);
//    }
}
