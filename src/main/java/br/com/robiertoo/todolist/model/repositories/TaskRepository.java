package br.com.robiertoo.todolist.model.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.robiertoo.todolist.model.entities.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Task SET completed = 1 WHERE id = :id")
	public void completeTask(int id);
	
}
