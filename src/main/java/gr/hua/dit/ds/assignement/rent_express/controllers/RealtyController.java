package gr.hua.dit.ds.assignement.rent_express.controllers;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Realty;
import gr.hua.dit.ds.assignement.rent_express.services.OwnerService;
import gr.hua.dit.ds.assignement.rent_express.services.RealtyService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("realty")
public class RealtyController {

    private RealtyService realtyService;
    private OwnerService ownerService;

    public RealtyController(RealtyService realtyService, OwnerService ownerService) {
        this.realtyService = realtyService;
        this.ownerService = ownerService;
    }

    @GetMapping("")
    public String showRealties(Model model){
        model.addAttribute("realties", realtyService.getRealties());
        return "realty/realties";
    }

    @GetMapping("/{id}")
    public String showRealty(@PathVariable Integer id, Model model){
        model.addAttribute("realties", realtyService.getRealty(id));
        return "realty/realties";
    }

    @GetMapping("/new")
    public String addRealty(Model model){
        Realty realty = new Realty();
        model.addAttribute("realty", realty);
        return "realty/realty";
    }

    @PostMapping("/new")
    public String saveRealty(@ModelAttribute("owner") Realty realty, Model model){
        realtyService.saveRealty(realty);
        model.addAttribute("realties",realtyService.getRealties());
        return "realty/realties";
    }

//    @GetMapping("/assign/{id}")
//    public String showAssignOwnerToRealty(@PathVariable Integer realtyId, Model model){
//        Realty realty = realtyService.getRealty(realtyId);
//        List <Owner> owners = ownerService.getOwners();
//        model.addAttribute("realty", realty);
//        model.addAttribute("owners", owners);
//        return "realty/assignowner";
//    }
//
//    //unassignOwnerToRealty
//
//    @PostMapping("/assign/{id}")
//    public String assignOwnerToRealty(@PathVariable int realtyId, @RequestParam(value = "owner", required = true) int ownerId, Model model){
//        Owner owner = ownerService.getOwner(ownerId);
//        Realty realty = realtyService.getRealty(realtyId);
//        realtyService.assignOwnerToRealty(realtyId,ownerId);
//        model.addAttribute("realties",realtyService.getRealties());
//        return "realty/realties";
//    }
}
