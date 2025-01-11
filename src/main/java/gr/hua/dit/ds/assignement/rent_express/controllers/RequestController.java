package gr.hua.dit.ds.assignement.rent_express.controllers;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Realty;
import gr.hua.dit.ds.assignement.rent_express.entities.Renter;
import gr.hua.dit.ds.assignement.rent_express.entities.Request;
import gr.hua.dit.ds.assignement.rent_express.services.RealtyService;
import gr.hua.dit.ds.assignement.rent_express.services.RenterService;
import gr.hua.dit.ds.assignement.rent_express.services.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("request")
public class RequestController {

    private RequestService requestService;
    private RenterService renterService;
    private RealtyService realtyService;

    public RequestController(RealtyService realtyService, RenterService renterService, RequestService requestService) {
        this.realtyService = realtyService;
        this.renterService = renterService;
        this.requestService = requestService;
    }

    @GetMapping("")
    public String showRequests(Model model){
        model.addAttribute("requests", requestService.getRequests());
        return "request/requests";
    }

    @GetMapping("/{id}")
    public String showRequest(@PathVariable Integer id, Model model){
        model.addAttribute("requests", requestService.getRequest(id));
        return "request/requests";
    }

    @GetMapping("/new")
    public String addRequest(Model model){
        Request request = new Request();
        model.addAttribute("request", request);
        return "request/request";
    }

    @PostMapping("/new")
    public String saveRequest(@ModelAttribute("renter") Request request, Model model){
        requestService.saveRequest(request);
        model.addAttribute("requests",requestService.getRequests());
        return "request/requests";
    }

//    @GetMapping("/assign/{id}")
//    public String showAssignRenterToRequest(@PathVariable Integer requestId, Model model){
//        Request request = requestService.getRequest(requestId);
//        List<Renter> renters = renterService.getRenters();
//        model.addAttribute("request", request);
//        model.addAttribute("renters", renters);
//        return "request/assignrenter";
//    }
//
//    //unassignRenterToRequest
//
//    @PostMapping("/assign/{id}")
//    public String assignRealtyToRequest(@PathVariable int requestId, @RequestParam(value = "realty", required = true) int realtyId, Model model){
//        Realty realty = realtyService.getRealty(realtyId);
//        Request request = requestService.getRequest(requestId);
//        requestService.assignRealtyToRequest(realtyId,requestId);
//        model.addAttribute("request",requestService.getRequests());
//        return "request/requests";
//    }
}
