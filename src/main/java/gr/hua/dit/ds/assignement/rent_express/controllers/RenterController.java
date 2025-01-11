package gr.hua.dit.ds.assignement.rent_express.controllers;

import gr.hua.dit.ds.assignement.rent_express.entities.Renter;
import gr.hua.dit.ds.assignement.rent_express.services.RenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("renter")
public class RenterController {

    private RenterService renterService;

    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping("")
    public String showRenters(Model model){
        model.addAttribute("renters",renterService.getRenters());
        return "renter/renters";
    }

    @GetMapping("/{id}")
    public String showRenter(@PathVariable Integer id, Model model){
        model.addAttribute("renters",renterService.getRenter(id));
        return "renter/renters";
    }

    @GetMapping("/new")
    public String addRenter(Model model){
        Renter renter = new Renter();
        model.addAttribute("renter",renter);
        return "renter/renter";
    }

    @PostMapping("/new")
    public String saveRenter(@ModelAttribute("request") Renter renter, Model model){
        renterService.saveRenter(renter);
        model.addAttribute("renters",renterService.getRenters());
        return "renter/renters";
    }
}
