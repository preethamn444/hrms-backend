package net.project.hrms.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import net.project.hrms.Service.PersonalService;
	import net.project.hrms.dto.PersonalDto;

	
	@RestController
	@CrossOrigin("*")
	@RequestMapping(value ="/admin")

	public class PersonalController {
		
		@Autowired
		PersonalService service;
		
		@PostMapping (value ="/save")
		public ResponseEntity<String> savePersonal(@RequestBody PersonalDto pdto){
			System.out.println("entered");
			long status = service.savePersonal(pdto);
			if(status ==200) 
				return new ResponseEntity<String>("saved Personal",HttpStatus.OK);
			else
				return new ResponseEntity<String>("saved not Personal",HttpStatus.BAD_REQUEST);
			
		}
				
		@PostMapping (value ="/getbyid")
		public PersonalDto getById(@RequestBody PersonalDto pdto){
			System.out.println("entered");
			PersonalDto dto = service.getById(pdto);
			if(dto != null) {
			return dto;
			}else {
				return null;
			}
		}
		
		@DeleteMapping (value ="/deletebyid")
		public PersonalDto deleteById(@RequestBody PersonalDto pdto){
			System.out.println("entered");
			PersonalDto dto = service.deleteById(pdto);
			if(dto != null) {
			return dto;
			}else {
				return null;
			}
			
		}
		
		@GetMapping (value ="/findall")
		public List<PersonalDto> findAll(){
			System.out.println("entered");
			 List<PersonalDto> dto = service.findAll();
				return dto;

		}

	}



