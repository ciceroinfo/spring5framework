package guru.springframework.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.model.Owner;
import guru.springframework.services.OwnerService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner fingByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}