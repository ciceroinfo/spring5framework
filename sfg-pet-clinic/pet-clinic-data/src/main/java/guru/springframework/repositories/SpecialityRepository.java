package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
