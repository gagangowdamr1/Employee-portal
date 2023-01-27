package com.Employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.employeemgt.dto.LeaveDTO;
//import com.employeemgt.form.LeaveForm;
//import com.employeemgt.service.LeaveService;

//public class LeaveController {@Autowired
//	public LeaveService service;
//	
//	@GetMapping("/leave")
//	public String  LeavePage(@ModelAttribute("form")Leavedetails form) {
//		
//		return "leave";
//	}
//
//	@PostMapping("/addLeave")
//	public String add(@Valid @ModelAttribute("form")Leavedetails form,  BindingResult bindingResult, Model model) throws Exception {
//
//		System.out.println("form: "+form);
//		try {
//		if (bindingResult.hasErrors()) {
//			System.out.println("bindingResult : "+bindingResult);
//			return "leave";
//		}else {
//			LeaveDTO bean = form.getDTO();
//			if(form.getId()>0) {
//				service.update(bean);
//				model.addAttribute("success", "Leave Updated successfully");
//			}else {
//				service.add(bean);
//				model.addAttribute("success", "Leave Added successfully");	
//			}
//			return "leave";
//		}}catch (Exception e) {
//			// TODO: handle exception
//			model.addAttribute("error", e.getMessage());
//			e.printStackTrace();
//			return "leave";
//		}
//	} 
//	
//	@GetMapping("/leaveList")
//	public String list(@ModelAttribute("form")LeaveForm form, Model model){
//	List<LeaveDTO> list =	service.list();
//	model.addAttribute("list", list);
//	return "leaveList";
//		
//	}
//	
//	@GetMapping("/leaveEdit")	
//	public String update(@ModelAttribute("form")LeaveForm form, Model model, @RequestParam("id") long id ){
//		LeaveDTO bean = service.findLeaveById(id);
//		form.populate(bean);
//		model.addAttribute("bean",bean);		
//		return "leave";
//	}
//	
//	@GetMapping("/leaveDelete")	
//	public String delete(@ModelAttribute("form")LeaveForm form, Model model, @RequestParam("id") long id ) throws Exception{
//		service.delete(id);	
//		List<LeaveDTO> list =	service.list();
//		model.addAttribute("list", list);
//		model.addAttribute("success", "Leave Deleted successfully");
//		return "leaveList";
//	}
//	
//	
	
	
	
	
	
//}



