package com.dtone.dvs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.BenefitTypes;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.PartyIdentifier;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.ProductFilter;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.PromotionFilter;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.dto.TransactionResponse;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.util.ErrorCodes;

@Ignore
public class DvsApiClientTest {

	private static final String BASE_URL = "<Base URL>";

	private static final String API_KEY = "<API Key>";

	private static final String API_SECRET = "<API Secret>";

	private static final DvsApiClient dvApiClient = new DvsApiClient(BASE_URL, API_KEY, API_SECRET);

	private static final DvsApiClient dvsApiClientUnAuthorized = new DvsApiClient(BASE_URL, "invalidapikey",
			"invalidapisecret");

	private static final DvsApiClient dvsApiClient404 = new DvsApiClient(BASE_URL + "/unavailable/", API_KEY,
			API_SECRET);

	@After
	public void tearDown() {
		System.out.println("\n\n");
	}

	@Test
	public void testUnauthorized() throws DvsApiException {
		ApiResponse<Service> serviceApiResponse = dvsApiClientUnAuthorized.getService(1L);

		assertEquals(HttpStatus.SC_UNAUTHORIZED, serviceApiResponse.getCode());
		assertEquals(serviceApiResponse.getErrors().get(0).getCode(), ErrorCodes.UNAUTHORIZED.getCode());
		assertEquals(serviceApiResponse.getErrors().get(0).getMessage(), ErrorCodes.UNAUTHORIZED.getMessage());
	}

	@Test
	public void test404() throws DvsApiException {
		ApiResponse<Service> serviceApiResponse = dvsApiClient404.getService(1L);

		assertEquals(HttpStatus.SC_NOT_FOUND, serviceApiResponse.getCode());
		assertEquals(serviceApiResponse.getErrors().get(0).getCode(), ErrorCodes.RESOURCE_NOT_FOUND.getCode());
	}

	@Test
	public void testServiceAPIs() throws DvsApiException {
		Page<ApiResponse<List<Service>>> pagedServicesResponse = dvApiClient.getServices();

		assertTrue(pagedServicesResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedServicesResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedServicesResponse.first().getCode() == HttpStatus.SC_OK) {
			List<Service> services = pagedServicesResponse.first().getResult();
			assertTrue(services.size() > 0);
			Service service = services.get(0);

			ApiResponse<Service> serviceByIdResponse = dvApiClient.getService(service.getId());
			assertEquals(service.getName(), serviceByIdResponse.getResult().getName());

			ApiResponse<List<Service>> servicesResponse2 = dvApiClient.getServices(1, 100);
			assertEquals(HttpStatus.SC_OK, servicesResponse2.getCode());
			assertTrue(servicesResponse2.getResult().size() > 0);
		}

		if (pagedServicesResponse.getTotalPages() > 1) {
			ApiResponse<List<Service>> servicesResponse = pagedServicesResponse.next();
			assertTrue(servicesResponse.getResult().size() > 0);

			ApiResponse<List<Service>> servicesResponse2 = dvApiClient.getServices(1, 100);
			assertEquals(HttpStatus.SC_OK, servicesResponse2.getCode());
			assertTrue(servicesResponse2.getResult().size() > 50);
		}

		ApiResponse<Service> serviceByIdResponse = dvApiClient.getService(100000000L);
		assertEquals(HttpStatus.SC_NOT_FOUND, serviceByIdResponse.getCode());
		assertEquals(ErrorCodes.SERVICE_NOT_FOUND.getCode(), serviceByIdResponse.getErrors().get(0).getCode());
	}

	@Test
	public void testProductAPIs() throws DvsApiException {

		System.out.println("Products\n");
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvApiClient.getProducts();

		assertTrue(pagedProductsResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedProductsResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedProductsResponse.first().getCode() == HttpStatus.SC_OK) {
			List<Product> products = pagedProductsResponse.first().getResult();
			assertTrue(products.size() > 0);

			Product product = products.get(0);

			ApiResponse<Product> productByIdResponse = dvApiClient.getProduct(product.getId());
			assertEquals(product.getName(), productByIdResponse.getResult().getName());

			ApiResponse<List<Product>> productsResponse2 = dvApiClient.getProducts(1, 100);
			assertEquals(HttpStatus.SC_OK, productsResponse2.getCode());
			assertTrue(productsResponse2.getResult().size() > 0);

			ProductFilter productFilter = new ProductFilter();
			productFilter.setServiceId(productByIdResponse.getResult().getService().getId());
			ApiResponse<List<Product>> productsResponseFilter = dvApiClient.getProducts(productFilter);
			assertEquals(HttpStatus.SC_OK, productsResponseFilter.getCode());
			assertTrue(productsResponseFilter.getResult().size() > 0);

			ApiResponse<List<Product>> productsResponseFilterPage = dvApiClient.getProducts(productFilter, 1, 100);
			assertEquals(HttpStatus.SC_OK, productsResponseFilterPage.getCode());
			assertTrue(productsResponseFilterPage.getResult().size() > 0);
		}

		if (pagedProductsResponse.getTotalPages() > 1) {
			assertEquals(1, pagedProductsResponse.getCurrentPage());
			assertEquals(50, pagedProductsResponse.getRecordsPerPage());
			assertEquals(0, pagedProductsResponse.getPreviousPage());
			assertEquals(2, pagedProductsResponse.getNextPage());
			assertTrue(pagedProductsResponse.getTotalPages() > 0);
			assertTrue(pagedProductsResponse.getTotalRecords() > 0);

			assertTrue(pagedProductsResponse.hasNext());

			ApiResponse<List<Product>> productsResponse = pagedProductsResponse.next();
			assertTrue(productsResponse.getResult().size() > 0);
			assertEquals(2, pagedProductsResponse.getCurrentPage());

			assertTrue(pagedProductsResponse.hasPrevious());

			ApiResponse<List<Product>> productsResponseLast = pagedProductsResponse.last();
			assertTrue(productsResponseLast.getResult().size() > 0);
			assertEquals(pagedProductsResponse.getCurrentPage(), pagedProductsResponse.getTotalPages());

			ApiResponse<List<Product>> productsResponseFirst = pagedProductsResponse.first();
			assertTrue(productsResponseFirst.getResult().size() > 0);
			assertEquals(1, pagedProductsResponse.getCurrentPage());

			ApiResponse<List<Product>> productsResponse2 = dvApiClient.getProducts(1, 100);
			assertEquals(HttpStatus.SC_OK, productsResponse2.getCode());
			assertTrue(productsResponse2.getResult().size() > 50);
		}

		ApiResponse<Product> productByIdResponse = dvApiClient.getProduct(100000000L);
		assertEquals(HttpStatus.SC_NOT_FOUND, productByIdResponse.getCode());
		assertEquals(ErrorCodes.PRODUCT_NOT_AVAILABLE.getCode(), productByIdResponse.getErrors().get(0).getCode());

		ProductFilter productFilter = new ProductFilter();
		List<BenefitTypes> benefitTypes = new ArrayList<BenefitTypes>();
		benefitTypes.add(BenefitTypes.TALKTIME);
		benefitTypes.add(BenefitTypes.DATA);
		benefitTypes.add(BenefitTypes.SMS);
		benefitTypes.add(BenefitTypes.PAYMENT);
		benefitTypes.add(BenefitTypes.CREDITS);
		productFilter.setBenefitTypes(benefitTypes);
		ApiResponse<List<Product>> productsResponseFilter = dvApiClient.getProducts(productFilter);

		if (productsResponseFilter.getCode() == HttpStatus.SC_OK) {
			List<Product> products = productsResponseFilter.getResult();
			assertTrue(products.size() > 0);
		}
	}

	@Test
	public void testOperatorAPIs() throws DvsApiException {
		System.out.println("Operators\n");

		Page<ApiResponse<List<Operator>>> pagedOperatorsResponse = dvApiClient.getOperators();

		assertEquals(HttpStatus.SC_OK, pagedOperatorsResponse.first().getCode());
		assertTrue(pagedOperatorsResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedOperatorsResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedOperatorsResponse.first().getCode() == HttpStatus.SC_OK) {

			ApiResponse<List<Operator>> operatorsResponse2 = dvApiClient.getOperators(1, 100);
			assertEquals(HttpStatus.SC_OK, operatorsResponse2.getCode());
			assertTrue(operatorsResponse2.getResult().size() > 0);

			List<Operator> operators = pagedOperatorsResponse.first().getResult();
			assertTrue(operators.size() > 0);
			Operator operator = operators.get(0);

			ApiResponse<Operator> operatorByIdResponse = dvApiClient.getOperator(operator.getId());
			assertEquals(operator.getName(), operatorByIdResponse.getResult().getName());

			ApiResponse<List<Operator>> operatorByCountryIsoCodeResponse = dvApiClient
					.getOperators(operator.getCountry().getIsoCode());
			assertTrue(operatorByCountryIsoCodeResponse.getResult().size() > 0);

			if (operatorByCountryIsoCodeResponse.getResult().size() > 50) {
				ApiResponse<List<Operator>> operatorByCountryIsoCodeResponse2 = dvApiClient
						.getOperators(operator.getCountry().getIsoCode(), 1, 100);
				assertTrue(operatorByCountryIsoCodeResponse2.getResult().size() > 0);
			}

			// TODO: Need to check if the mobile number can be retrieved from some response
			// and use here
			ApiResponse<List<Operator>> operatorsByMobileNumber = dvApiClient.lookupOperators("+628123456100");
			assertEquals(HttpStatus.SC_OK, operatorsByMobileNumber.getCode());

			ApiResponse<List<Operator>> operatorsByMobileNumber2 = dvApiClient.lookupOperators("+628123456100", 1, 100);
			assertEquals(HttpStatus.SC_OK, operatorsByMobileNumber2.getCode());
		}

		if (pagedOperatorsResponse.getTotalPages() > 1) {
			ApiResponse<List<Operator>> nextOperatorsResponse = pagedOperatorsResponse.next();
			assertTrue(nextOperatorsResponse.getResult().size() > 0);

			ApiResponse<List<Operator>> operatorsResponse2 = dvApiClient.getOperators(1, 100);
			assertEquals(HttpStatus.SC_OK, operatorsResponse2.getCode());
			assertTrue(operatorsResponse2.getResult().size() > 50);
		}

		ApiResponse<Operator> operatorByIdResponse = dvApiClient.getOperator(100000000L);
		assertEquals(HttpStatus.SC_NOT_FOUND, operatorByIdResponse.getCode());
		assertEquals(ErrorCodes.OPERATOR_NOT_FOUND.getCode(), operatorByIdResponse.getErrors().get(0).getCode());

	}

	@Test
	public void testCountryAPIs() throws DvsApiException {
		System.out.println("Countries\n");

		Page<ApiResponse<List<Country>>> pagedCountriesResponse = dvApiClient.getCountries();

		assertTrue(pagedCountriesResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedCountriesResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedCountriesResponse.first().getCode() == HttpStatus.SC_OK) {
			List<Country> countries = pagedCountriesResponse.first().getResult();
			assertTrue(countries.size() > 0);
			Country country = countries.get(0);

			ApiResponse<Country> countryByIsoCodeResponse = dvApiClient.getCountry(country.getIsoCode());
			assertEquals(country.getName(), countryByIsoCodeResponse.getResult().getName());

			ApiResponse<List<Country>> countriesResponse2 = dvApiClient.getCountries(1, 100);
			assertEquals(HttpStatus.SC_OK, countriesResponse2.getCode());
			assertTrue(countriesResponse2.getResult().size() > 0);
		}

		if (pagedCountriesResponse.getTotalPages() > 1) {
			ApiResponse<List<Country>> countriesResponse = pagedCountriesResponse.next();
			assertTrue(countriesResponse.getResult().size() > 0);

			ApiResponse<List<Country>> countriesResponse2 = dvApiClient.getCountries(1, 100);
			assertEquals(HttpStatus.SC_OK, countriesResponse2.getCode());
			assertTrue(countriesResponse2.getResult().size() > 50);
		}
	}

	@Test
	public void testBenefitTypeAPIs() throws DvsApiException {
		System.out.println("BenefitTypes\n");
		Page<ApiResponse<List<BenefitType>>> pagedBenefitTypesResponse = dvApiClient.getBenefitTypes();
		assertTrue(pagedBenefitTypesResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedBenefitTypesResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedBenefitTypesResponse.first().getCode() == HttpStatus.SC_OK) {
			assertTrue(pagedBenefitTypesResponse.first().getResult().size() > 0);

			ApiResponse<List<BenefitType>> bnefitTypesResponse2 = dvApiClient.getBenefitTypes(1, 100);
			assertEquals(HttpStatus.SC_OK, bnefitTypesResponse2.getCode());
			assertTrue(bnefitTypesResponse2.getResult().size() > 0);
		}

		if (pagedBenefitTypesResponse.getTotalPages() > 1) {
			ApiResponse<List<BenefitType>> benefitTypesResponse2 = dvApiClient.getBenefitTypes(1, 100);
			assertEquals(HttpStatus.SC_OK, benefitTypesResponse2.getCode());
			assertTrue(benefitTypesResponse2.getResult().size() > 50);
		}
	}

	@Test
	public void testPromotionAPIs() throws DvsApiException {
		System.out.println("Promotions\n");

		Page<ApiResponse<List<Promotion>>> pagedPromotionsResponse = dvApiClient.getPromotions();
		assertTrue(pagedPromotionsResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedPromotionsResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedPromotionsResponse.first().getCode() == HttpStatus.SC_OK) {
			assertTrue(pagedPromotionsResponse.first().getResult().size() > 0);

			Promotion promotion = pagedPromotionsResponse.first().getResult().get(0);

			ApiResponse<List<Promotion>> promotionsFiltersResponse = dvApiClient
					.getPromotions(new PromotionFilter(null, null, promotion.getProducts().get(0).getId()));
			assertTrue(promotionsFiltersResponse.getCode() == HttpStatus.SC_OK
					|| promotionsFiltersResponse.getCode() == HttpStatus.SC_NOT_FOUND);

			ApiResponse<List<Promotion>> promotionsFiltersResponse2 = dvApiClient
					.getPromotions(new PromotionFilter(promotion.getOperator().getCountry().getIsoCode(), null, null));
			assertEquals(HttpStatus.SC_OK, promotionsFiltersResponse2.getCode());
			assertTrue(promotionsFiltersResponse2.getResult().size() > 0);

			ApiResponse<List<Promotion>> promotionsFiltersResponse3 = dvApiClient
					.getPromotions(new PromotionFilter(null, promotion.getOperator().getId(), null));
			assertEquals(HttpStatus.SC_OK, promotionsFiltersResponse3.getCode());
			assertTrue(promotionsFiltersResponse3.getResult().size() > 0);

			ApiResponse<List<Promotion>> promotionsFiltersResponse4 = dvApiClient
					.getPromotions(new PromotionFilter(promotion.getOperator().getCountry().getIsoCode(),
							promotion.getOperator().getId(), promotion.getProducts().get(0).getId()));
			assertTrue(promotionsFiltersResponse4.getCode() == HttpStatus.SC_OK
					|| promotionsFiltersResponse4.getCode() == HttpStatus.SC_NOT_FOUND);
		} else {
			assertEquals(HttpStatus.SC_NOT_FOUND, pagedPromotionsResponse.first().getCode());
			assertNotNull(pagedPromotionsResponse.first().getErrors());
			assertEquals(ErrorCodes.PROMOTION_NOT_FOUND.getCode(),
					pagedPromotionsResponse.first().getErrors().get(0).getCode());
		}

		if (pagedPromotionsResponse.getTotalPages() > 1) {
			ApiResponse<List<Promotion>> promotionsResponse2 = dvApiClient.getPromotions(1, 100);
			assertEquals(HttpStatus.SC_OK, promotionsResponse2.getCode());
			assertTrue(promotionsResponse2.getResult().size() > 50);
		}
	}

	@Test
	public void testTransactionAPIs() throws DvsApiException {
		System.out.println("Transactions\n");

		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvApiClient.getProducts();

		if (pagedProductsResponse.first().getCode() == HttpStatus.SC_OK) {
			List<Product> products = pagedProductsResponse.first().getResult();

			Product product = products.get(0);
			Long productId = product.getId();

			// Transaction Sync
			TransactionRequest txnRequest = getTransactionRequest(productId);
			ApiResponse<TransactionResponse> transactionSyncResponse = dvApiClient.createTransaction(txnRequest, true);

			if (HttpStatus.SC_CREATED == transactionSyncResponse.getCode()) {
				// External Id already used
				ApiResponse<TransactionResponse> transactionSyncResponse2 = dvApiClient.createTransaction(txnRequest,
						true);
				txnRequest.setExternalId(transactionSyncResponse.getResult().getExternalId());
				assertEquals(HttpStatus.SC_BAD_REQUEST, transactionSyncResponse2.getCode());
				assertEquals(ErrorCodes.TXN_EXTERNAL_ID_ALREADY_USED.getCode(),
						transactionSyncResponse2.getErrors().get(0).getCode());

				// Confirm Transaction
				ApiResponse<TransactionResponse> confirmTransactionSyncResponse = dvApiClient
						.confirmTransaction(transactionSyncResponse.getResult().getId(), true);
				assertEquals(HttpStatus.SC_ACCEPTED, confirmTransactionSyncResponse.getCode());

				// Transaction already confirmed
				ApiResponse<TransactionResponse> confirmTransactionSyncResponse2 = dvApiClient
						.confirmTransaction(transactionSyncResponse.getResult().getId(), true);
				assertEquals(HttpStatus.SC_BAD_REQUEST, confirmTransactionSyncResponse2.getCode());
				assertTrue(ErrorCodes.TXN_ALREADY_CONFIRMED.getCode()
						.equals(confirmTransactionSyncResponse2.getErrors().get(0).getCode())
						|| ErrorCodes.TXN_CANNOT_BE_CONFIRMED.getCode()
								.equals(confirmTransactionSyncResponse2.getErrors().get(0).getCode()));

				// Transaction cannot be cancelled
				ApiResponse<TransactionResponse> cancelTransactionResponse = dvApiClient
						.cancelTransaction(transactionSyncResponse.getResult().getId());
				assertEquals(HttpStatus.SC_BAD_REQUEST, cancelTransactionResponse.getCode());
				assertEquals(ErrorCodes.TXN_CANNOT_BE_CANCELLED.getCode(),
						cancelTransactionResponse.getErrors().get(0).getCode());

				ApiResponse<List<TransactionResponse>> transactionSyncResponses = dvApiClient
						.getTransactions(new TransactionFilter(transactionSyncResponse.getResult().getExternalId()));
				assertEquals(HttpStatus.SC_OK, transactionSyncResponses.getCode());
				assertTrue(transactionSyncResponses.getResult().size() > 0);

				if (transactionSyncResponses.getResult().size() > 50) {
					ApiResponse<List<TransactionResponse>> transactionSyncResponses2 = dvApiClient.getTransactions(
							new TransactionFilter(transactionSyncResponse.getResult().getExternalId()), 1, 100);
					assertEquals(HttpStatus.SC_OK, transactionSyncResponses2.getCode());
					assertTrue(transactionSyncResponses2.getResult().size() > 50);
				}

				// Get Transactions Sync
				ApiResponse<List<TransactionResponse>> transactionsResponse = dvApiClient
						.getTransactions(new TransactionFilter(transactionSyncResponse.getResult().getExternalId()));
				assertEquals(HttpStatus.SC_OK, transactionsResponse.getCode());
				assertTrue(transactionsResponse.getResult().size() > 0);

				// Get Transaction By Id
				ApiResponse<TransactionResponse> transactionByIdResponse = dvApiClient
						.getTransaction(transactionsResponse.getResult().get(0).getId());
				assertEquals(HttpStatus.SC_OK, transactionByIdResponse.getCode());

				// Transaction Not Found
				ApiResponse<TransactionResponse> transactionByIdResponse2 = dvApiClient.getTransaction(100000000L);
				assertEquals(HttpStatus.SC_NOT_FOUND, transactionByIdResponse2.getCode());
				assertEquals(ErrorCodes.TXN_NOT_FOUND.getCode(), transactionByIdResponse2.getErrors().get(0).getCode());
			} else {
				System.out.println("transactionSyncResponse=" + transactionSyncResponse);
				assertEquals(HttpStatus.SC_BAD_REQUEST, transactionSyncResponse.getCode());
				assertEquals(ErrorCodes.INSUFFICIENT_BALANCE.getCode(),
						transactionSyncResponse.getErrors().get(0).getCode());
			}
			// Transaction Async
			ApiResponse<TransactionResponse> transactionAsyncResponse = dvApiClient
					.createTransaction(getTransactionRequest(productId), false);
			assertEquals(HttpStatus.SC_CREATED, transactionAsyncResponse.getCode());

			if (HttpStatus.SC_CREATED == transactionAsyncResponse.getCode()) {
				// Confirm Transaction Async
				ApiResponse<TransactionResponse> confirmTransactionAsyncResponse = dvApiClient
						.confirmTransaction(transactionAsyncResponse.getResult().getId(), false);
				assertEquals(HttpStatus.SC_ACCEPTED, confirmTransactionAsyncResponse.getCode());

				// Get Transactions Async
				ApiResponse<List<TransactionResponse>> transactionAsyncResponses = dvApiClient
						.getTransactions(new TransactionFilter(transactionAsyncResponse.getResult().getExternalId()));
				assertEquals(HttpStatus.SC_OK, transactionAsyncResponses.getCode());
				assertTrue(transactionAsyncResponses.getResult().size() > 0);

				if (transactionAsyncResponses.getResult().size() > 50) {
					ApiResponse<List<TransactionResponse>> transactionAsyncResponses2 = dvApiClient.getTransactions(
							new TransactionFilter(transactionAsyncResponse.getResult().getExternalId()), 1, 100);
					assertEquals(HttpStatus.SC_OK, transactionAsyncResponses2.getCode());
					assertTrue(transactionAsyncResponses2.getResult().size() > 50);
				}
			} else {
				assertEquals(HttpStatus.SC_BAD_REQUEST, transactionSyncResponse.getCode());
				assertEquals(ErrorCodes.INSUFFICIENT_BALANCE.getCode(),
						transactionSyncResponse.getErrors().get(0).getCode());
			}

			// Cancel Transaction
			ApiResponse<TransactionResponse> transactionSyncResponseToCancel = dvApiClient
					.createTransaction(getTransactionRequest(productId), true);

			if (HttpStatus.SC_CREATED == transactionSyncResponseToCancel.getCode()) {
				ApiResponse<TransactionResponse> cancelTransactionResponse = dvApiClient
						.cancelTransaction(transactionSyncResponseToCancel.getResult().getId());
				assertEquals(HttpStatus.SC_ACCEPTED, cancelTransactionResponse.getCode());

				ApiResponse<TransactionResponse> cancelTransactionResponse2 = dvApiClient
						.cancelTransaction(transactionSyncResponseToCancel.getResult().getId());
				assertEquals(HttpStatus.SC_BAD_REQUEST, cancelTransactionResponse2.getCode());
				assertEquals(ErrorCodes.TXN_ALREADY_CANCELLED.getCode(),
						cancelTransactionResponse2.getErrors().get(0).getCode());

				ApiResponse<TransactionResponse> confirmTransactionSyncResponse = dvApiClient
						.confirmTransaction(transactionSyncResponseToCancel.getResult().getId(), true);
				assertEquals(HttpStatus.SC_BAD_REQUEST, confirmTransactionSyncResponse.getCode());

				// To be enabled once the defect is fixed
				// assertEquals(ErrorCodes.TXN_CANNOT_BE_CONFIRMED.getCode(),
				// confirmTransactionSyncResponse.getErrors().get(0).getCode());

				TransactionRequest txnRequest2 = getTransactionRequest(productId);
				txnRequest2.setExternalId(" ");
				ApiResponse<TransactionResponse> transactionSyncResponse2 = dvApiClient.createTransaction(txnRequest2,
						true);
				assertEquals(HttpStatus.SC_BAD_REQUEST, transactionSyncResponse2.getCode());
			}
		}

	}

	@Test
	public void testBalanceAPIs() throws DvsApiException {
		System.out.println("Balances\n");
		Page<ApiResponse<List<Balance>>> pagedBalancesResponse = dvApiClient.getBalances();
		assertTrue(pagedBalancesResponse.first().getCode() == HttpStatus.SC_OK
				|| pagedBalancesResponse.first().getCode() == HttpStatus.SC_NOT_FOUND);

		if (pagedBalancesResponse.first().getCode() == HttpStatus.SC_OK) {
			assertTrue(pagedBalancesResponse.first().getResult().size() > 0);

			ApiResponse<List<Balance>> balancesResponse2 = dvApiClient.getBalances(1, 100);
			assertEquals(HttpStatus.SC_OK, balancesResponse2.getCode());
			assertTrue(balancesResponse2.getResult().size() > 0);
		}

		if (pagedBalancesResponse.getTotalPages() > 1) {
			ApiResponse<List<Balance>> balancesResponse2 = dvApiClient.getBalances(1, 100);
			assertEquals(HttpStatus.SC_OK, balancesResponse2.getCode());
			assertTrue(balancesResponse2.getResult().size() > 50);
		}
	}

	private TransactionRequest getTransactionRequest(Long productId) {
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setProductId(productId);
		transactionRequest.setExternalId(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		transactionRequest.setAutoConfirm(false);

		PartyIdentifier creditPartyIdentifier = new PartyIdentifier();
		creditPartyIdentifier.setMobileNumber("+971501817077");
		creditPartyIdentifier.setAccountNumber("628123456100");
		transactionRequest.setCreditPartyIdentifier(creditPartyIdentifier);
		return transactionRequest;
	}

}
