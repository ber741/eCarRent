package mum.edu.cs.cs425.project.ecarrent.services;

import java.time.LocalDate;
import java.util.List;

import mum.edu.cs.cs425.project.ecarrent.model.Category;

public interface ISearchService {
	
	List<Category> findAvailableCategories(LocalDate start, LocalDate end);

}
