package br.com.estudo.jpa.filters;

public interface PaginationFilter extends Filter {

	public int pageNumber();
	public int totalOfPages();
	
	
}
