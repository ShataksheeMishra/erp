package com.shatakshee.erp.repo;

import com.shatakshee.erp.dto.EligibleOrganisationDTO;
import com.shatakshee.erp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
public interface StudentRepo extends JpaRepository<Student, Integer>{
    Optional<Student> findByEmail(String email);
    @Query("""
    SELECT DISTINCT new com.shatakshee.erp.dto.EligibleOrganisationDTO(
        o.name, o.address, p.profile, p.description,
        p.minimum_grade, sp.name, d.program
    )
    FROM Student s
    JOIN Placement_Filter pf ON s.domain = pf.domain AND s.specialisation = pf.specialisation
    JOIN Placement p ON pf.placement.placement_id = p.placement_id
    JOIN Organisation o ON p.organisation.id = o.id
    JOIN Specialisation sp ON pf.specialisation.specialisation_id = sp.specialisation_id
    JOIN Domains d ON pf.domain.domain_id = d.domain_id
    WHERE s.cgpa >= p.minimum_grade
""")
    List<EligibleOrganisationDTO> findEligibleOrganisations(@Param("studentId") int studentId);

}
