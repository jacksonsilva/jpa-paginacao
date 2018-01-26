package br.com.estudo.jpa.filters;

public class UsuarioFilters implements PaginationFilter {

	private int _pageNumber;
	private int _totalOfPages;
	
	public void setPageNumber(int pageNumber) {
		this._pageNumber = pageNumber;
	}

	public void setTotalOfPages(int totalOfPages) {
		this._totalOfPages = totalOfPages;
	}

	@Override
	public int pageNumber() {
		return this._pageNumber;
	}

	@Override
	public int totalOfPages() {
		return this._totalOfPages;
	}

	
	
}
