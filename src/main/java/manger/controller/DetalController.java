package manger.controller;

import manger.model.Detal;
import manger.service.DetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetalController {
    private DetalService detalService;

    @Autowired(required = true)
    @Qualifier(value = "detalService")
    public void setDetalService(DetalService detalService) {
        this.detalService = detalService;
    }

    @RequestMapping(value = "detals", method = RequestMethod.GET)
    public String listDetals(Model model){
        //if(this.detalService.listNow().size() == 0) this.detalService.listDetals();
        model.addAttribute("detal", new Detal());

        //model.addAttribute("listDetals", this.detalService.listDetals());
        model.addAttribute("listDetals", this.detalService.listDetals());

        //model.addAttribute("selectAll", this.detalService.listNow());
        model.addAttribute("compAmount", this.detalService.compAmount());
        //model.addAttribute("selectNoNeed", this.detalService.listNoNeed());
        return  "detals";
    }

    @RequestMapping(value = "/detals/add", method = RequestMethod.POST)
    public String addDetal(@ModelAttribute("detal") Detal detal){
        if(detal.getId() == 0){
            this.detalService.addDetal(detal);
            System.out.println("мурыжимая деталька1 " + detal.getId());
        } else {
            System.out.println("мурыжимая деталька2 " + detal.getId());
            this.detalService.updateDetal(detal);
        }
        detalService.listNow();
        return  "redirect:/detals";
    }

    @RequestMapping("/remove/{id}")
    public  String removeDetal(@PathVariable("id") int id){
        this.detalService.removeDetal(id);
        return "redirect:/detals";
    }

    @RequestMapping("edit/{id}")
    public String editDetal(@PathVariable("id") int id, Model model){
        model.addAttribute("detal", this.detalService.getDetalById(id));
        //model.addAttribute("listDetals", this.detalService.listDetals());
        System.out.println("мурыжимая деталька_exp");
        return  "detals";
    }

    @RequestMapping("detaldata/{id}")
    public String detalData(@PathVariable("id") int id, Model model){
        model.addAttribute("detal", this.detalService.getDetalById(id));
        return "detaldata";
    }

    @RequestMapping("next")
    public String nextList() {
        this.detalService.listNext();
        return "redirect:/detals";
    }

    @RequestMapping("previous")
    public String previousList() {
        this.detalService.listPrev();
        return "redirect:/detals";
    }

    @RequestMapping(value = "/detals/search", method = RequestMethod.POST)
    public String getDetalByName(@ModelAttribute("detal") Detal detal, Model model) {
        model.addAttribute("detal", detalService.getDetalByName(detal.getName()));
        return "redirect:/detals";
    }

    @RequestMapping(value = "/detals/selectNeed", method = RequestMethod.GET)
    public String listNeed(Model model) {
        this.detalService.listNeed();
        return "redirect:/detals";
    }
    @RequestMapping(value = "/detals/selectNoNeed", method = RequestMethod.GET)
    public String listNoNeed(Model model) {
        this.detalService.listNoNeed();
        return "redirect:/detals";
    }
    @RequestMapping(value = "/detals/selectAll", method = RequestMethod.GET)
    public String listAll(Model model) {
        this.detalService.listAll();
        return "redirect:/detals";
    }
}
