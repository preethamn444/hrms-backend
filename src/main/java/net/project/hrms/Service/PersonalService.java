package net.project.hrms.Service;

	import java.util.List;
	import java.util.Optional;
	import java.util.stream.Collectors;

	import org.modelmapper.ModelMapper;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import net.project.hrms.dto.PersonalDto;
	import net.project.hrms.entity.PersonalEntity;
	import net.project.hrms.repository.PersonalRepository;

	@Service 
	
	public class PersonalService {
		
		@Autowired
		PersonalRepository personalRepository;
		
		public int savePersonal(PersonalDto pdto){
			
			PersonalEntity se = new PersonalEntity();
			se.setFirstName(pdto.getFirstName());
			se.setLastName(pdto.getLastName());
			se.setEmailId(pdto.getEmailId());
			se.setGender(pdto.getGender());
			se.setAge(pdto.getAge());
			se.setDob(pdto.getDob());
			se.setMob_num(pdto.getMob_num());
			
		if(pdto.getId() !=1) {
			se.setId(pdto.getId());
			}
		
			PersonalEntity responseDb = personalRepository.save(se);
			if(responseDb!=null) {
				return 200;
			}else {
				return 500;
			}
		
		}
		
		public PersonalDto getById(PersonalDto pdto){
			
			Optional<PersonalEntity> responseDb = personalRepository.findById(pdto.getId());
			
			System.out.println(responseDb.get());
			PersonalDto ptdo = new PersonalDto();
			
			if(responseDb.isEmpty() == false) {
				PersonalEntity st = responseDb.get();
				
				st.setFirstName(pdto.getFirstName());
				st.setLastName(pdto.getLastName());
				st.setEmailId(pdto.getEmailId());
				st.setGender(pdto.getGender());
				st.setAge(pdto.getAge());
				st.setDob(pdto.getDob());
				st.setMob_num(pdto.getMob_num());
				ptdo.setIsActive(st.getIsActive());
				return ptdo;
				
			}else {
				return null;
			}
		}
		
		
	public PersonalDto deleteById(PersonalDto pdto){
		ModelMapper modelmapper = new ModelMapper();
			
			Optional<PersonalEntity> responseDb = personalRepository.findById(pdto.getId());		
			System.out.println(responseDb.get());
			//EmployeeDto tdo = new EmployeeDto();
			
			if(responseDb.isEmpty() == false) {
				PersonalEntity st = responseDb.get();
				st.setIsActive((byte)0);
				personalRepository.save(st);
				PersonalDto dto = modelmapper.map(st, PersonalDto.class);
				 return dto;
			}else {
				return null;
			}
		}

		public List<PersonalDto> findAll(){
			ModelMapper modelmapper = new ModelMapper();
			
			List<PersonalDto> pdto ;
			List<PersonalEntity> etlist = personalRepository.findAll();
			if(etlist != null) {
				pdto = etlist.stream().map(employeeentity -> modelmapper.map(employeeentity, PersonalDto.class)).collect(Collectors.toList());
			}else {
				return null;
			}
			
			return pdto;

		}	
		

	}



