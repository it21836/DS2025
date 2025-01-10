package gr.hua.dit.ds.assignement.rent_express.controllers;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("")
    public String showOwners(Model model){
        model.addAttribute("owners",ownerService.getOwners());
        return "owner/owners";
    }

    @GetMapping("/{id}")
    public String showOwner(@PathVariable Integer id, Model model){
        model.addAttribute("owners",ownerService.getOwner(id));
        return "owner/owners";
    }

    @GetMapping("/new")
    public String addOwner(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner",owner);
        return "owner/owner";
    }

    @PostMapping("/new")
    public String saveOwner(@ModelAttribute("realty") Owner owner, Model model){
        ownerService.saveOwner(owner);
        model.addAttribute("owners",ownerService.getOwners());
        return "owner/owners";
    }
}
