package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Invoice;
import model.InvoiceCrud;

@Controller
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private InvoiceCrud uc;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String listaInvoices(ModelMap mp){
        mp.put("invoices", uc.findAll());
        return "crud/lista";
    }

    @RequestMapping(value="/nuevo", method=RequestMethod.GET)
    public String add(ModelMap mp){
        mp.put("invoice", new Invoice());
        return "crud/nuevo";
    }

    @RequestMapping(value="/crear", method=RequestMethod.POST)
    public String create(@Valid Invoice invoice,
                        BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "/crud/nuevo";
        }else{
            uc.save(invoice);
            mp.put("invoice", invoice);
            return "crud/creado";
        }
    }

    @RequestMapping(value="/creado", method = RequestMethod.POST)
    public String created(@RequestParam("invoice") Invoice invoice){
        return "/crud/creado";
    }

}