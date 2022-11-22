package com.dtone.dvs.dto;

public class PageInfo {
	private int totalPages;
	private int totalRecords;
	private int currentPage;
	private int recordsPerPage;
	private int nextPage;
	private int previousPage;

	public PageInfo(int totalPages, int totalRecords, int currentPage, int recordsPerPage, int nextPage,
			int previousPage) {
		this.totalPages = totalPages;
		this.totalRecords = totalRecords;
		this.currentPage = currentPage;
		this.recordsPerPage = recordsPerPage;
		this.nextPage = nextPage;
		this.previousPage = previousPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	@Override
	public String toString() {
		return "PageInfo [totalPages=" + totalPages + ", totalRecords=" + totalRecords + ", currentPage=" + currentPage
				+ ", recordsPerPage=" + recordsPerPage + ", nextPage=" + nextPage + ", previousPage=" + previousPage
				+ "]";
	}

}
