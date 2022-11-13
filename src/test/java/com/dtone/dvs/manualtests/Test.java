package com.dtone.dvs.manualtests;

import java.util.List;

import com.dtone.dvs.DvsApiClient;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BalanceFilter;
import com.dtone.dvs.dto.BenefitFixed;
import com.dtone.dvs.dto.BenefitRanged;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.CalculationMode;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.LookupOperatorRequest;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
import com.dtone.dvs.dto.PartyIdentifier;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.ProductFilter;
import com.dtone.dvs.dto.ProductFixed;
import com.dtone.dvs.dto.ProductPricesFixed;
import com.dtone.dvs.dto.ProductPricesRanged;
import com.dtone.dvs.dto.ProductRanged;
import com.dtone.dvs.dto.ProductType;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.PromotionFilter;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.Source;
import com.dtone.dvs.dto.SourceFixed;
import com.dtone.dvs.dto.SourceRanged;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.util.ProductUtils;

public class Test {
	public static void main(String[] args) throws DvsApiException {
		String baseUrl = null;
		String apiKey = null;
		String apiSecret = null;

		DvsApiClient dvsApiClient = new DvsApiClient(baseUrl, apiKey, apiSecret);

		services(dvsApiClient);
		countries(dvsApiClient);
		operators(dvsApiClient);
		benefits(dvsApiClient);
		promotions(dvsApiClient);
		balances(dvsApiClient);
		lookupOperatorGet(dvsApiClient);
		lookupOperatorPost(dvsApiClient);

		products(dvsApiClient);
		getProducts(dvsApiClient);
		productsNextAndPrevious(dvsApiClient);
		productsLast(dvsApiClient);
		productsCustomPagination(dvsApiClient);

		createTransactionsAutoTrue(dvsApiClient);
		createTransactionsRangedDestinationAutoTrue(dvsApiClient);
		createTransactionsRangedSourceAutoTrue(dvsApiClient);
		createTransactionsAutoFalse(dvsApiClient);
		confirmTransactions(dvsApiClient);
		cancelTransactions(dvsApiClient);
		transactions(dvsApiClient);

	}

	private static void services(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Services\n----------------------------");
		Page<ApiResponse<List<Service>>> pageableAllServicesApiResponse = dvsClient.getServices();

		System.out.println("Page Info=" + pageableAllServicesApiResponse.getPageInfo());

		ApiResponse<List<Service>> allServicesApiResponse = pageableAllServicesApiResponse.first();
		List<Service> serviceList = allServicesApiResponse.getResult();

		for (Service service : serviceList) {
			System.out.println("Service=" + service);
		}

		System.out.println("\nService By Id\n----------------------------");
		ApiResponse<Service> serviceApiResponse = dvsClient.getService(Long.valueOf(1));
		Service service = serviceApiResponse.getResult();
		System.out.println("Service=" + service);

		System.out.println("\n=======================================\n");
	}

	private static void countries(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Countries\n----------------------------");
		Page<ApiResponse<List<Country>>> pageableAllCountriesApiResponse = dvsClient.getCountries();

		System.out.println("Page Info=" + pageableAllCountriesApiResponse.getPageInfo());

		ApiResponse<List<Country>> allCountriesApiResponse = pageableAllCountriesApiResponse.first();
		List<Country> countryList = allCountriesApiResponse.getResult();

		for (Country country : countryList) {
			System.out.println("Country = " + country);
		}

		System.out.println("\nCountry By Iso Code\n----------------------------");
		ApiResponse<Country> countryApiResponse = dvsClient.getCountry("AFG");
		Country country = countryApiResponse.getResult();
		System.out.println("Country = " + country);

		System.out.println("\n=======================================\n");
	}

	private static void operators(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Operators\n----------------------------");
		Page<ApiResponse<List<Operator>>> pageableAllOperatorsApiResponse = dvsClient.getOperators();

		System.out.println("Page Info=" + pageableAllOperatorsApiResponse.getPageInfo());

		ApiResponse<List<Operator>> allOperatorsApiResponse = pageableAllOperatorsApiResponse.first();
		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println("Operator = " + operator);
		}

		System.out.println("\nOperator By Id\n----------------------------");
		ApiResponse<Operator> operatorApiResponse = dvsClient.getOperator(Long.valueOf(1));
		Operator operator = operatorApiResponse.getResult();
		System.out.println("Operator = " + operator);

		System.out.println("\n=======================================\n");
	}

	private static void benefits(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Benefit Types\n----------------------------");
		Page<ApiResponse<List<BenefitType>>> pageableAllBenefitTypesApiResponse = dvsClient.getBenefitTypes();

		System.out.println("Page Info=" + pageableAllBenefitTypesApiResponse.getPageInfo());

		ApiResponse<List<BenefitType>> allBenefitTypesApiResponse = pageableAllBenefitTypesApiResponse.first();
		List<BenefitType> benefitTypeList = allBenefitTypesApiResponse.getResult();

		for (BenefitType benefitType : benefitTypeList) {
			System.out.println("BenefitType = " + benefitType);
		}
		System.out.println("\n=======================================\n");
	}

	private static void promotions(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Promotions\n----------------------------");
		Page<ApiResponse<List<Promotion>>> pageableAllPromotionApiResponse = dvsClient.getPromotions();

		System.out.println("Page Info=" + pageableAllPromotionApiResponse.getPageInfo());

		ApiResponse<List<Promotion>> allPromotionApiResponse = pageableAllPromotionApiResponse.first();
		List<Promotion> promotionList = allPromotionApiResponse.getResult();

		for (Promotion promotion : promotionList) {
			System.out.println("Promotion = " + promotion);
		}

		System.out.println("\nPromotion By Id\n----------------------------");
		ApiResponse<Promotion> promotionApiResponse = dvsClient.getPromotion(Long.valueOf(2510));
		Promotion promotion = promotionApiResponse.getResult();
		System.out.println("Promotion = " + promotion);

		System.out.println("\\Promotion By Filter\n----------------------------");
		PromotionFilter promotionFilter = new PromotionFilter();
		promotionFilter.setCountryIsoCode("PAK");
		ApiResponse<List<Promotion>> allPromotionsApiResponseByFilter = dvsClient.getPromotions(promotionFilter);
		List<Promotion> promotionListByFilter = allPromotionsApiResponseByFilter.getResult();

		for (Promotion promotionByFilter : promotionListByFilter) {
			System.out.println("Promotion = " + promotionByFilter);
		}

		System.out.println("\n=======================================\n");
	}

	private static void balances(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Balances\n----------------------------");
		Page<ApiResponse<List<Balance>>> pageableAllBalancesApiResponse = dvsClient.getBalances();

		System.out.println("Page Info=" + pageableAllBalancesApiResponse.getPageInfo());

		ApiResponse<List<Balance>> allBalancesApiResponse = pageableAllBalancesApiResponse.first();
		List<Balance> balanceList = allBalancesApiResponse.getResult();

		for (Balance balance : balanceList) {
			System.out.println("Balance=" + balance);
		}

		System.out.println("\nBalance By Filter\n----------------------------");
		BalanceFilter balanceFilter = new BalanceFilter("AED");
		ApiResponse<List<Balance>> allBalancesApiResponseByFilter = dvsClient.getBalances(balanceFilter);
		List<Balance> balanceListByFilter = allBalancesApiResponseByFilter.getResult();

		for (Balance balanceByFilter : balanceListByFilter) {
			System.out.println("Balance=" + balanceByFilter);
		}

		System.out.println("\n=======================================\n");
	}

	private static void lookupOperatorGet(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Number Lookup Get\n----------------------------");
		ApiResponse<List<Operator>> allOperatorsApiResponse = dvsClient.lookupOperators("+919962589889");

		System.out.println("Page Info=" + allOperatorsApiResponse.getPageInfo());

		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println("Operator =" + operator);
		}
		System.out.println("\n=======================================\n");
	}

	private static void lookupOperatorPost(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Number Lookup Post\n----------------------------");
		ApiResponse<List<Operator>> allOperatorsApiResponse = dvsClient
				.lookupOperators(new LookupOperatorRequest("+919962589889"));

		System.out.println("Page Info=" + allOperatorsApiResponse.getPageInfo());

		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println("Operator=" + operator);
		}
		System.out.println("\n=======================================\n");
	}

	private static void products(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Products\n----------------------------");
		Page<ApiResponse<List<Product>>> pageableAllProductsApiResponse = dvsClient.getProducts();

		System.out.println("Page Info=" + pageableAllProductsApiResponse.getPageInfo());

		ApiResponse<List<Product>> allProductsApiResponse = pageableAllProductsApiResponse.first();
		List<Product> productList = allProductsApiResponse.getResult();

		for (Product product : productList) {
			System.out.println("Product=" + product);
		}

		System.out.println("\nProduct By Id\n----------------------------");
		ApiResponse<Product> productApiResponse = dvsClient.getProduct(Long.valueOf(115));
		Product product = productApiResponse.getResult();
		System.out.println("Product=" + product);

		System.out.println("\nProduct By Filter\n----------------------------");
		ProductFilter productFilter = new ProductFilter();
		productFilter.setServiceId(Long.valueOf(6));
		ApiResponse<List<Product>> allProductsApiResponseByFilter = dvsClient.getProducts(productFilter);
		List<Product> productListByFilter = allProductsApiResponseByFilter.getResult();

		for (Product productByFilter : productListByFilter) {
			System.out.println("Product=" + productByFilter);
		}

		System.out.println("\n=======================================\n");
	}

	private static void transactions(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Transactions\n----------------------------");
		Page<ApiResponse<List<Transaction>>> pageableAllTransactionsApiResponse = dvsClient.getTransactions();

		System.out.println("Page Info=" + pageableAllTransactionsApiResponse.getPageInfo());

		ApiResponse<List<Transaction>> allTransactionsApiResponse = pageableAllTransactionsApiResponse.first();
		List<Transaction> transactionList = allTransactionsApiResponse.getResult();

		for (Transaction transaction : transactionList) {
			System.out.println("Transaction=" + transaction);
		}

		System.out.println("\nTransaction By Id\n----------------------------");
		ApiResponse<Transaction> transactionApiResponse = dvsClient.getTransaction(Long.valueOf(44696));
		Transaction transaction = transactionApiResponse.getResult();
		System.out.println("Transaction=" + transaction);

		System.out.println("\nTransaction By Filter\n----------------------------");
		TransactionFilter transactionFilter = new TransactionFilter();
		transactionFilter.setExternalId("da669511-ba9d-4cd5-9573-3f51c4f8dcd7");
		ApiResponse<List<Transaction>> allTransactionsApiResponseByFilter = dvsClient
				.getTransactions(transactionFilter);
		List<Transaction> transactionListByFilter = allTransactionsApiResponseByFilter.getResult();

		for (Transaction transactionByFilter : transactionListByFilter) {
			System.out.println("Transaction=" + transactionByFilter);
		}

		System.out.println("\nTransaction By Filter and Paging\n----------------------------");
		TransactionFilter transactionFilterPaging = new TransactionFilter();
		transactionFilter.setFromDate("2022-11-12T00:00:00Z");
		transactionFilter.setFromDate("2022-11-13T00:00:00Z");
		transactionFilter.setOperatorId(2808L);
		transactionFilter.setCountryIsoCode("IND");
		transactionFilter.setCreditPartyMobileNumber("+919962589100");
		transactionFilter.setProductType(ProductType.FIXED_VALUE_RECHARGE.toString());
		transactionFilter.setStatusId(70000L);
		ApiResponse<List<Transaction>> allTransactionsApiResponseByFilterPaging = dvsClient
				.getTransactions(transactionFilterPaging, 1, 100);
		List<Transaction> transactionListByFilterPaging = allTransactionsApiResponseByFilterPaging.getResult();

		System.out.println("Page Info=" + allTransactionsApiResponseByFilterPaging.getPageInfo());

		for (Transaction transactionByFilterPaging : transactionListByFilterPaging) {
			System.out.println("Transaction=" + transactionByFilterPaging);
		}

		System.out.println("\n=======================================\n");
	}

	private static void getProducts(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("Get Products\n----------------------------");
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();

		ApiResponse<List<Product>> productsResponse = pagedProductsResponse.first();

		printProductResponse(productsResponse);

		System.out.println("\n=======================================\n");
	}

	private static void productsNextAndPrevious(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("ProductsNextAndPrevious\n----------------------------");
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();

		System.out.println("PageInfo=" + pagedProductsResponse.getPageInfo());

		ApiResponse<List<Product>> productsResponse = pagedProductsResponse.first();

		while (pagedProductsResponse.hasNext()) {
			ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.next();

			List<Product> productListNext = productsApiResponse.getResult();
			System.out.println("productListNext=" + productListNext);
			System.out.println("PageInfo=" + pagedProductsResponse.getPageInfo());

			break;
		}

		while (pagedProductsResponse.hasPrevious()) {
			ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.previous();

			List<Product> productListNext = productsApiResponse.getResult();
			System.out.println("productListPrevious=" + productListNext);
			System.out.println("PageInfo=" + pagedProductsResponse.getPageInfo());
			break;
		}

		System.out.println("\n=======================================\n");

	}

	private static void productsLast(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("ProductsLast\n----------------------------");
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();

		ApiResponse<List<Product>> productsApiResponseFirst = pagedProductsResponse.first();
		System.out.println("Firstpage =" + productsApiResponseFirst.getPageInfo());

		ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.last();

		List<Product> productListLast = productsApiResponse.getResult();
		System.out.println(productListLast.size());
		System.out.println(productListLast);

		System.out.println("Lastpage =" + productsApiResponse.getPageInfo());
		System.out.println("\n=======================================\n");

	}

	private static void productsCustomPagination(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("ProductsCustomPagination\n----------------------------");
		ApiResponse<List<Product>> productsApiResponse = dvsApiClient.getProducts(1, 3);

		System.out.println(productsApiResponse.getPageInfo());
		printProductResponse(productsApiResponse);
		System.out.println("\n=======================================\n");

	}

	private static void createTransactionsAutoTrue(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("CreateTransactionsAutoTrue\n----------------------------");
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setExternalId("DVSSDK200" + System.currentTimeMillis());
		transactionRequest.setProductId(20153L);
		transactionRequest.setAutoConfirm(true);

		transactionRequest.setCallbackUrl("https://callbackurl.com");

		transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+919962589100"));

		ApiResponse<Transaction> transactionSyncResponse = dvsApiClient.createTransaction(transactionRequest);

		System.out.println(transactionSyncResponse);
		System.out.println("\n=======================================\n");

	}

	private static void createTransactionsRangedDestinationAutoTrue(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("createTransactionsRangedDestinationAutoTrue\n----------------------------");
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setExternalId("DVSSDK200" + System.currentTimeMillis());
		transactionRequest.setProductId(11187L);
		transactionRequest.setAutoConfirm(true);
		transactionRequest.setCalculationMode(CalculationMode.DESTINATION_AMOUNT);
		transactionRequest.setCallbackUrl("https://callbackurl.com");
		transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+93415151100"));
		transactionRequest.setDestination(new Source("CURRENCY", "AFN", Double.valueOf(15.0)));

		ApiResponse<Transaction> transactionSyncResponse = dvsApiClient.createTransaction(transactionRequest);

		System.out.println(transactionSyncResponse);
		System.out.println("\n=======================================\n");

	}

	private static void createTransactionsRangedSourceAutoTrue(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("createTransactionsRangedSourceAutoTrue\n----------------------------");
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setExternalId("DVSSDK200" + System.currentTimeMillis());
		transactionRequest.setProductId(11187L);
		transactionRequest.setAutoConfirm(true);
		transactionRequest.setCalculationMode(CalculationMode.SOURCE_AMOUNT);
		transactionRequest.setCallbackUrl("https://callbackurl.com");
		transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+93415151100"));
		transactionRequest.setSource(new Source("CURRENCY", "AED", Double.valueOf(15.0)));

		ApiResponse<Transaction> transactionSyncResponse = dvsApiClient.createTransaction(transactionRequest);

		System.out.println(transactionSyncResponse);
		System.out.println("\n=======================================\n");

	}

	private static void createTransactionsAutoFalse(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("CreateTransactionsAutoFalse\n----------------------------");
		TransactionRequest transactionRequest = new TransactionRequest();
		transactionRequest.setExternalId("DVSSDK200" + System.currentTimeMillis());
		transactionRequest.setProductId(20153L);
		transactionRequest.setAutoConfirm(false);

		transactionRequest.setCallbackUrl("https://callbackurl.com");

		transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+919962589100"));

		ApiResponse<Transaction> transactionSyncResponse = dvsApiClient.createTransaction(transactionRequest);

		System.out.println(transactionSyncResponse);
		System.out.println("\n=======================================\n");

	}

	private static void confirmTransactions(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("ConfirmTransactions\n----------------------------");
		ApiResponse<Transaction> confirmTransactionResponse = dvsApiClient.confirmTransaction(44703L);

		System.out.println(confirmTransactionResponse);
		System.out.println("\n=======================================\n");

	}

	private static void cancelTransactions(DvsApiClient dvsApiClient) throws DvsApiException {
		System.out.println("CancelTransactions\n----------------------------");
		ApiResponse<Transaction> cancelTransactionResponse = dvsApiClient.cancelTransaction(44704L);

		System.out.println(cancelTransactionResponse);
		System.out.println("\n=======================================\n");

	}

	private static void printProductResponse(ApiResponse<List<Product>> productsResponse) {
		List<Product> productList = productsResponse.getResult();

		for (Product product : productList) {
			System.out.println(product);
			if (ProductUtils.isFixedType(product.getType())) {
				ProductFixed productFixed = (ProductFixed) product;

				Long id = productFixed.getId();
				List<BenefitFixed> benefitList = productFixed.getBenefits();
				SourceFixed source = productFixed.getSource();
				SourceFixed destination = productFixed.getDestination();
				ProductPricesFixed prices = productFixed.getPrices();

				System.out.println("Fixed");
				System.out.println(id);
				System.out.println(benefitList);
				System.out.println(source);
				System.out.println(destination);
				System.out.println(prices);
				System.out.println("-----------------------------------------------------");

			} else {
				ProductRanged productRanged = (ProductRanged) product;

				Long id = productRanged.getId();
				List<BenefitRanged> benefitList = productRanged.getBenefits();
				SourceRanged source = productRanged.getSource();
				SourceRanged destination = productRanged.getDestination();
				ProductPricesRanged prices = productRanged.getPrices();

				System.out.println("Ranged");
				System.out.println(id);
				System.out.println(benefitList);
				System.out.println(source);
				System.out.println(destination);
				System.out.println(prices);
				System.out.println("-----------------------------------------------------");
			}
		}
	}

}