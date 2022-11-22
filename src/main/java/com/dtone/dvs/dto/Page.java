package com.dtone.dvs.dto;

import com.dtone.dvs.DvsApiClient;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.util.Constants;

@SuppressWarnings("unchecked")
public class Page<T> {

	private final DvsApiClient dvsClient;
	private T first;
	private String apiOperation;

	private int totalPages;
	private int totalRecords;
	private int currentPage;
	private int recordsPerPage;
	private int nextPage;
	private int previousPage;

	public Page(String apiOperation, String url, String apiKey, String apiSecret, T apiResponse) {
		this.apiOperation = apiOperation;
		this.dvsClient = new DvsApiClient(url, apiKey, apiSecret);
		this.first = apiResponse;
	}

	public Page(String apiOperation, int totalPages, int totalRecords, int currentPage, int recordsPerPage,
			int nextPage, int previousPage) {
		this.dvsClient = null;
		this.apiOperation = apiOperation;
		this.totalPages = totalPages;
		this.totalRecords = totalRecords;
		this.currentPage = currentPage;
		this.recordsPerPage = recordsPerPage;
		this.nextPage = nextPage;
		this.previousPage = previousPage;
	}

	/**
	 * Get first page
	 * 
	 * @return the first page
	 */
	public T first() throws DvsApiException {
		if (getCurrentPage() <= 1) {
			return first;
		} else {
			setCurrentPage(1);
			return getApiResponse();
		}
	}

	/**
	 * Has next page
	 * 
	 * @return if next page is available
	 */
	public boolean hasNext() {
		return totalPages > currentPage;
	}

	/**
	 * Has previous page
	 * 
	 * @return if previous page is available
	 */
	public boolean hasPrevious() {
		return currentPage > 1;
	}

	/**
	 * Get next page
	 * 
	 * @return the next page
	 */
	public T next() throws DvsApiException {
		setCurrentPage(getCurrentPage() + 1);
		return getApiResponse();
	}

	/**
	 * Get previous page
	 * 
	 * @return the previous page
	 */
	public T previous() throws DvsApiException {
		setCurrentPage(getCurrentPage() - 1);
		return getApiResponse();
	}

	/**
	 * Get last page
	 * 
	 * @return the last page
	 */
	public T last() throws DvsApiException {
		setCurrentPage(getTotalPages());
		return getApiResponse();
	}

	private T getApiResponse() throws DvsApiException {
		T t = null;

		switch (this.apiOperation) {
		case Constants.PRODUCTS:
			t = (T) dvsClient.getProducts(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.SERVICES:
			t = (T) dvsClient.getServices(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.OPERATORS:
			t = (T) dvsClient.getOperators(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.PROMOTIONS:
			t = (T) dvsClient.getPromotions(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.BENEFIT_TYPES:
			t = (T) dvsClient.getBenefitTypes(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.BALANCES:
			t = (T) dvsClient.getBalances(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.COUNTRIES:
			t = (T) dvsClient.getCountries(getCurrentPage(), getRecordsPerPage());
			break;
		default:

		}

		return t;
	}

	/**
	 * Get page information
	 * 
	 * @return the page information
	 */
	public PageInfo getPageInfo() {
		return new PageInfo(totalPages, totalRecords, currentPage, recordsPerPage, nextPage, previousPage);
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

	public String getApiOperation() {
		return apiOperation;
	}

	public void setApiOperation(String apiOperation) {
		this.apiOperation = apiOperation;
	}

	@Override
	public String toString() {
		return "Page [apiOperation=" + apiOperation + ", totalPages=" + totalPages + ", totalRecords=" + totalRecords
				+ ", currentPage=" + currentPage + ", recordsPerPage=" + recordsPerPage + ", nextPage=" + nextPage
				+ ", previousPage=" + previousPage + "]";
	}
}
