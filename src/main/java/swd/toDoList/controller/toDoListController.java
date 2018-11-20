package swd.toDoList.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import swd.toDoList.bean.Listitem;
import swd.toDoList.dao.ListitemRepository;

@Controller
public class toDoListController {
	@Autowired
	private ListitemRepository listitemrepository;
	
	//Show all listitems
	//******************************************
	@RequestMapping(value = "/listitems", method = RequestMethod.GET)
	public String listitemList(Model model) {
		model.addAttribute("listitemlist", listitemrepository.findAll());
		return "listitems";
	}
	//Find a listitem by id
	//******************************************
	@RequestMapping(value="/listitem/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Listitem> findListitemRest(@PathVariable("id") Long id) {
			return listitemrepository.findById(id);
	}
	
	//Add a listitem with GET
	//******************************************
	@RequestMapping(value = "/addlistitem", method = RequestMethod.GET)
	public String addlistitem(Model model) {
		model.addAttribute("listitem", new Listitem());
		return "addlistitem";
	}
	//Add a listitem POST
	//******************************************
	@RequestMapping(value = "/addlistitem", method = RequestMethod.POST)
	public String save(Listitem listitem, Model model) {
		listitemrepository.save(listitem);
		model.addAttribute("toiminto", "Listitem saved.");
		model.addAttribute("listitem", new Listitem());
		return "addlistitem";
	}
	//Delete a listitem
	//******************************************
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	//@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteListitem(@PathVariable("id") Long id, Model model) {
		listitemrepository.deleteById(id);
		return "redirect:/listitems";
	}
	//Edit listitem 
	//******************************************
	@RequestMapping(value = "/editlistitem/{id}")
	public String addListitem(@PathVariable("id") Long id, Model model){
		model.addAttribute("listitem", listitemrepository.findById(id));
		return "editlistitem";
	}
	//Edit listitem POST
	//******************************************
	@RequestMapping(value = "/editlistitem", method = RequestMethod.POST)
	public String editlistite(Listitem listitem, Model model) {
		listitemrepository.save(listitem);
		model.addAttribute("toiminto", "Listitem edited.");
		model.addAttribute("listitem", listitem);
		return "editlistitem";
	}
	//Edit listitem with GET
	//******************************************
	@RequestMapping(value = "/editlistitem", method = RequestMethod.GET)
	public String editlistitem(Model model) {
		model.addAttribute("listitem", new Listitem());
		return "editlistitem";
	}

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
