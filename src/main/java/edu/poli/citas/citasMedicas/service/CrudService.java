package edu.poli.citas.citasMedicas.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, k> {

	public List<T> getList();

	public Optional<T> getById(k id);

	public T create(T dto);

	public T update(T dto, k id) throws Exception;

	public void delete(k id)throws Exception;

}
