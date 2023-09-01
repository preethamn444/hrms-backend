package net.project.hrms.repository;	

	import java.util.List;
	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import net.project.hrms.dto.PersonalDto;
	import net.project.hrms.entity.PersonalEntity;

	public interface PersonalRepository extends JpaRepository<PersonalEntity, Long> {
		
		PersonalEntity save(PersonalEntity PersonalEntity);
		
		Optional<PersonalEntity> findById(long id);
		
		@Query(value ="select * from hrms_db.personal where isactive=?", nativeQuery = true)
		List<PersonalDto> findAllByIsActive(byte isactive);
		

}
