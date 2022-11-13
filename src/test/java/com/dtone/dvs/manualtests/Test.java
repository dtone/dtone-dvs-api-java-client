package com.dtone.dvs.manualtests;

import java.util.ArrayList;
import java.util.List;

import com.dtone.dvs.DvsApiClient;
import com.dtone.dvs.dto.ApiError;
import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BalanceFilter;
import com.dtone.dvs.dto.BenefitFixed;
import com.dtone.dvs.dto.BenefitRanged;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.BenefitTypes;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.LookupOperatorRequest;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.Page;
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
import com.dtone.dvs.dto.SourceFixed;
import com.dtone.dvs.dto.SourceRanged;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.exception.DvsApiException;
import com.dtone.dvs.util.ProductUtils;

public class Test {
	public static void main(String[] args) throws DvsApiException {
		/*DvsApiClient dvsClient = new DvsApiClient("https://preprod-dvs-api.dtone.com/",
				"6d0480d5-2132-56bb-9f04-fec613de2ac4", "fa838754-c2e0-5118-85ba-be8b835b0774");*/
		
		DvsApiClient dvsClient = new DvsApiClient("https://staging-dvs-api.transferto.dtone.com:8443",
				"73b310ab-9a22-4a85-9060-11dde00347f7", "8d254ee2-17f5-4177-8d44-d9da72412fb1");

		/*services(dvsClient);
		countries(dvsClient);
		operators(dvsClient);
		benefits(dvsClient);
		promotions(dvsClient);
		balances(dvsClient);
		lookupOperatorGet(dvsClient);
		lookupOperatorPost(dvsClient);
		products(dvsClient);
		transactions(dvsClient);*/
		
		docProducts(dvsClient);
		
		

		}

	private static void services(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Services\n----------------------------");
		Page<ApiResponse<List<Service>>> pageableAllServicesApiResponse = dvsClient.getServices();

		System.out.println("Total Pages = " + pageableAllServicesApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllServicesApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllServicesApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllServicesApiResponse.getApiOperation());

		ApiResponse<List<Service>> allServicesApiResponse = pageableAllServicesApiResponse.first();
		List<Service> serviceList = allServicesApiResponse.getResult();

		for (Service service : serviceList) {
			System.out.println(service);
		}
		
		System.out.println("\nService By Id\n----------------------------");
		ApiResponse<Service> serviceApiResponse = dvsClient.getService(Long.valueOf(1));
		Service service = serviceApiResponse.getResult();
		System.out.println(service);
		
		
		System.out.println("\n=======================================\n");
	}

	private static void countries(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Countries\n----------------------------");
		Page<ApiResponse<List<Country>>> pageableAllCountriesApiResponse = dvsClient.getCountries();

		System.out.println("Total Pages = " + pageableAllCountriesApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllCountriesApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllCountriesApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllCountriesApiResponse.getApiOperation());

		ApiResponse<List<Country>> allCountriesApiResponse = pageableAllCountriesApiResponse.first();
		List<Country> countryList = allCountriesApiResponse.getResult();

		for (Country country : countryList) {
			System.out.println(country);
		}
		
		System.out.println("\nCountry By Iso Code\n----------------------------");
		ApiResponse<Country> countryApiResponse = dvsClient.getCountry("AFG");
		Country country = countryApiResponse.getResult();
		System.out.println(country);
		
		System.out.println("\n=======================================\n");
	}

	private static void operators(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Operators\n----------------------------");
		Page<ApiResponse<List<Operator>>> pageableAllOperatorsApiResponse = dvsClient.getOperators();

		System.out.println("Total Pages = " + pageableAllOperatorsApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllOperatorsApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllOperatorsApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllOperatorsApiResponse.getApiOperation());

		ApiResponse<List<Operator>> allOperatorsApiResponse = pageableAllOperatorsApiResponse.first();
		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println(operator);
		}
		
		System.out.println("\nOperator By Id\n----------------------------");
		ApiResponse<Operator> operatorApiResponse = dvsClient.getOperator(Long.valueOf(1));
		Operator operator = operatorApiResponse.getResult();
		System.out.println(operator);
		
		System.out.println("\n=======================================\n");
	}

	private static void benefits(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Benefit Types\n----------------------------");
		Page<ApiResponse<List<BenefitType>>> pageableAllBenefitTypesApiResponse = dvsClient.getBenefitTypes();

		System.out.println("Total Pages = " + pageableAllBenefitTypesApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllBenefitTypesApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllBenefitTypesApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllBenefitTypesApiResponse.getApiOperation());

		ApiResponse<List<BenefitType>> allBenefitTypesApiResponse = pageableAllBenefitTypesApiResponse.first();
		List<BenefitType> benefitTypeList = allBenefitTypesApiResponse.getResult();

		for (BenefitType benefitType : benefitTypeList) {
			System.out.println(benefitType);
		}
		System.out.println("\n=======================================\n");
	}

	private static void promotions(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Promotions\n----------------------------");
		Page<ApiResponse<List<Promotion>>> pageableAllPromotionApiResponse = dvsClient.getPromotions();

		System.out.println("Total Pages = " + pageableAllPromotionApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllPromotionApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllPromotionApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllPromotionApiResponse.getApiOperation());

		ApiResponse<List<Promotion>> allPromotionApiResponse = pageableAllPromotionApiResponse.first();
		List<Promotion> promotionList = allPromotionApiResponse.getResult();

		for (Promotion promotion : promotionList) {
			System.out.println("promotion" + promotion);
			List<Product> products = promotion.getProducts();
			Product p = products.get(0);
			System.out.println("product==" + p.getName());
		}
		
		System.out.println("\nPromotion By Id\n----------------------------");
		ApiResponse<Promotion> promotionApiResponse = dvsClient.getPromotion(Long.valueOf(3846));
		Promotion promotion = promotionApiResponse.getResult();
		System.out.println(promotion);
		
		System.out.println("\\nBalance By Filter\n----------------------------");
		PromotionFilter promotionFilter = new PromotionFilter();
		promotionFilter.setCountryIsoCode("PAK");
		ApiResponse<List<Promotion>> allPromotionsApiResponseByFilter = dvsClient.getPromotions(promotionFilter);
		List<Promotion> promotionListByFilter = allPromotionsApiResponseByFilter.getResult();

		for (Promotion promotionByFilter : promotionListByFilter) {
			System.out.println("promotion" + promotionByFilter);
		}
		
		System.out.println("\n=======================================\n");
	}

	private static void balances(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Balances\n----------------------------");
		Page<ApiResponse<List<Balance>>> pageableAllBalancesApiResponse = dvsClient.getBalances();

		System.out.println("Total Pages = " + pageableAllBalancesApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllBalancesApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllBalancesApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllBalancesApiResponse.getApiOperation());

		ApiResponse<List<Balance>> allBalancesApiResponse = pageableAllBalancesApiResponse.first();
		List<Balance> balanceList = allBalancesApiResponse.getResult();

		for (Balance balance : balanceList) {
			System.out.println("balance" + balance);
		}
		
		System.out.println("\\nBalance By Filter\n----------------------------");
		BalanceFilter balanceFilter = new BalanceFilter("AED");
		ApiResponse<List<Balance>> allBalancesApiResponseByFilter = dvsClient.getBalances(balanceFilter);
		List<Balance> balanceListByFilter = allBalancesApiResponseByFilter.getResult();

		for (Balance balanceByFilter : balanceListByFilter) {
			System.out.println("balance" + balanceByFilter);
		}
		
		System.out.println("\n=======================================\n");
	}

	private static void lookupOperatorGet(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Number Lookup Get\n----------------------------");
		ApiResponse<List<Operator>> allOperatorsApiResponse = dvsClient.lookupOperators("+919962589889");

		System.out.println("Total Pages = " + allOperatorsApiResponse.getTotalPages());
		System.out.println("Total Records = " + allOperatorsApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + allOperatorsApiResponse.getRecordsPerPage());

		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println("Lookup operator =" + operator);
		}
		System.out.println("\n=======================================\n");
	}

	private static void lookupOperatorPost(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Number Lookup Post\n----------------------------");
		ApiResponse<List<Operator>> allOperatorsApiResponse = dvsClient
				.lookupOperators(new LookupOperatorRequest("+919962589889"));

		System.out.println("Total Pages = " + allOperatorsApiResponse.getTotalPages());
		System.out.println("Total Records = " + allOperatorsApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + allOperatorsApiResponse.getRecordsPerPage());

		List<Operator> operatorList = allOperatorsApiResponse.getResult();

		for (Operator operator : operatorList) {
			System.out.println("Lookup operator =" + operator);
		}
		System.out.println("\n=======================================\n");
	}
	
	private static void products(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Products\n----------------------------");
		Page<ApiResponse<List<Product>>> pageableAllProductsApiResponse = dvsClient.getProducts();

		System.out.println("Total Pages = " + pageableAllProductsApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllProductsApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllProductsApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllProductsApiResponse.getApiOperation());

		ApiResponse<List<Product>> allProductsApiResponse = pageableAllProductsApiResponse.first();
		List<Product> productList = allProductsApiResponse.getResult();

		for (Product product : productList) {
			System.out.println("product" + product);
		}
		
		System.out.println("\nProduct By Id\n----------------------------");
		ApiResponse<Product> productApiResponse = dvsClient.getProduct(Long.valueOf(50));
		Product product = productApiResponse.getResult();
		System.out.println(product);
		
		
		System.out.println("\nProduct By Filter\n----------------------------");
		ProductFilter productFilter = new ProductFilter();
		productFilter.setServiceId(Long.valueOf(6));
		ApiResponse<List<Product>> allProductsApiResponseByFilter = dvsClient.getProducts(productFilter);
		List<Product> productListByFilter = allProductsApiResponseByFilter.getResult();

		for (Product productByFilter : productListByFilter) {
			System.out.println("product" + productByFilter);
		}
		
		System.out.println("\n=======================================\n");
	}
	
	private static void transactions(DvsApiClient dvsClient) throws DvsApiException {
		System.out.println("Transactions\n----------------------------");
		Page<ApiResponse<List<Transaction>>> pageableAllTransactionsApiResponse = dvsClient.getTransactions();

		System.out.println("Total Pages = " + pageableAllTransactionsApiResponse.getTotalPages());
		System.out.println("Total Records = " + pageableAllTransactionsApiResponse.getTotalRecords());
		System.out.println("Records Per Page = " + pageableAllTransactionsApiResponse.getRecordsPerPage());
		System.out.println("Api Operation = " + pageableAllTransactionsApiResponse.getApiOperation());

		ApiResponse<List<Transaction>> allTransactionsApiResponse = pageableAllTransactionsApiResponse.first();
		List<Transaction> transactionList = allTransactionsApiResponse.getResult();

		for (Transaction transaction : transactionList) {
			System.out.println("transaction" + transaction);
		}
		
		System.out.println("\nTransaction By Id\n----------------------------");
		ApiResponse<Transaction> transactionApiResponse = dvsClient.getTransaction(Long.valueOf(44696));
		Transaction transaction = transactionApiResponse.getResult();
		System.out.println(transaction);
		
		System.out.println("\nTransaction By Filter\n----------------------------");
		TransactionFilter transactionFilter = new TransactionFilter();
		transactionFilter.setExternalId("da669511-ba9d-4cd5-9573-3f51c4f8dcd7");
		ApiResponse<List<Transaction>> allTransactionsApiResponseByFilter = dvsClient.getTransactions(transactionFilter);
		List<Transaction> transactionListByFilter = allTransactionsApiResponseByFilter.getResult();

		for (Transaction transactionByFilter : transactionListByFilter) {
			System.out.println("transaction" + transactionByFilter);
		}
		
		System.out.println("\n=======================================\n");
	}
	
	
	private static void docProducts(DvsApiClient dvsClient) throws DvsApiException {
		
	        getProducts(dvsClient);
	        
	        getProductsNextAndPrevious(dvsClient);
	        
	        getProductsLast(dvsClient);
	        
	        getProductsCustomPagination(dvsClient);
	        
	        getProductsById(dvsClient);
	        
	        getProductsByFilter(dvsClient);

	}

	private static void getProducts(DvsApiClient dvsApiClient) throws DvsApiException {
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();
		
		int totalPages = pagedProductsResponse.getTotalPages(); 
		int totalRecords = pagedProductsResponse.getTotalRecords();
		int CurrentPage = pagedProductsResponse.getCurrentPage();
		int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
		int nextPage = pagedProductsResponse.getNextPage();
		int previousPage = pagedProductsResponse.getPreviousPage();
		
		
		
		System.out.println(totalPages);
		System.out.println(totalRecords);
		System.out.println(CurrentPage);
		System.out.println(recordsPerPage);
		System.out.println(nextPage);
		System.out.println(previousPage);
		System.out.println("=================");
		
		ApiResponse<List<Product>> productsResponse = pagedProductsResponse.first();
		
		List<Product> productList = productsResponse.getResult();

		for (Product product : productList) {
		    if (ProductUtils.isFixedType(product.getType())) {
				ProductFixed productFixed = (ProductFixed)product;
				
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
		    	ProductRanged productRanged = (ProductRanged)product;
		    	
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
	
	private static void getProductsNextAndPrevious(DvsApiClient dvsApiClient) throws DvsApiException {
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();
		
		int totalPages = pagedProductsResponse.getTotalPages(); 
		int totalRecords = pagedProductsResponse.getTotalRecords();
		int CurrentPage = pagedProductsResponse.getCurrentPage();
		int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
		int nextPage = pagedProductsResponse.getNextPage();
		int previousPage = pagedProductsResponse.getPreviousPage();
		
		System.out.println(totalPages);
		System.out.println(totalRecords);
		System.out.println(CurrentPage);
		System.out.println(recordsPerPage);
		System.out.println(nextPage);
		System.out.println(previousPage);
		System.out.println("=================");
		
		ApiResponse<List<Product>> productsResponse = pagedProductsResponse.first();
		
		while(pagedProductsResponse.hasNext()){
         ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.next();
   
	        List<Product> productListNext = productsApiResponse.getResult();
	         System.out.println("productListNext=" + productListNext);
	         
	         int totalPages2 = pagedProductsResponse.getTotalPages(); 
	 		int totalRecords2 = pagedProductsResponse.getTotalRecords();
	 		int CurrentPage2 = pagedProductsResponse.getCurrentPage();
	 		int recordsPerPage2 = pagedProductsResponse.getRecordsPerPage(); 
	 		int nextPage2 = pagedProductsResponse.getNextPage();
	 		int previousPage2 = pagedProductsResponse.getPreviousPage();
	 		
	 		System.out.println(totalPages2);
	 		System.out.println(totalRecords2);
	 		System.out.println(CurrentPage2);
	 		System.out.println(recordsPerPage2);
	 		System.out.println(nextPage2);
	 		System.out.println(previousPage2);
	 		System.out.println("=================");
	 		
	 		break;
	     }
		
		while(pagedProductsResponse.hasPrevious()){
	         ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.previous();
	   
		        List<Product> productListNext = productsApiResponse.getResult();
		         System.out.println("productListNext=" + productListNext);
		         
		         int totalPages2 = pagedProductsResponse.getTotalPages(); 
		 		int totalRecords2 = pagedProductsResponse.getTotalRecords();
		 		int CurrentPage2 = pagedProductsResponse.getCurrentPage();
		 		int recordsPerPage2 = pagedProductsResponse.getRecordsPerPage(); 
		 		int nextPage2 = pagedProductsResponse.getNextPage();
		 		int previousPage2 = pagedProductsResponse.getPreviousPage();
		 		
		 		System.out.println(totalPages2);
		 		System.out.println(totalRecords2);
		 		System.out.println(CurrentPage2);
		 		System.out.println(recordsPerPage2);
		 		System.out.println(nextPage2);
		 		System.out.println(previousPage2);
		 		System.out.println("=================");
		 		
		 		break;
		     }
		
	}
	
	
	private static void getProductsLast(DvsApiClient dvsApiClient) throws DvsApiException {
		Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();
		
		int totalPages = pagedProductsResponse.getTotalPages(); 
		int totalRecords = pagedProductsResponse.getTotalRecords();
		int CurrentPage = pagedProductsResponse.getCurrentPage();
		int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
		int nextPage = pagedProductsResponse.getNextPage();
		int previousPage = pagedProductsResponse.getPreviousPage();
		
		System.out.println(totalPages);
		System.out.println(totalRecords);
		System.out.println(CurrentPage);
		System.out.println(recordsPerPage);
		System.out.println(nextPage);
		System.out.println(previousPage);
		System.out.println("=================");
		
		ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.last();
		
		List<Product> productListLast = productsApiResponse.getResult();
        System.out.println(productListLast.size());
        System.out.println(productListLast);
        
        
        int totalPages2 = pagedProductsResponse.getTotalPages(); 
        int totalRecords2 = pagedProductsResponse.getTotalRecords();
        int CurrentPage2 = pagedProductsResponse.getCurrentPage();
        int recordsPerPage2 = pagedProductsResponse.getRecordsPerPage(); 
        int nextPage2 = pagedProductsResponse.getNextPage();
        int previousPage2 = pagedProductsResponse.getPreviousPage();
        
        
        
        System.out.println(totalPages2);
        System.out.println(totalRecords2);
        System.out.println(CurrentPage2);
        System.out.println(recordsPerPage2);
        System.out.println(nextPage2);
        System.out.println(previousPage2);
        System.out.println("=================");
		
	}
	
	private static void getProductsCustomPagination(DvsApiClient dvsApiClient) throws DvsApiException {
		ApiResponse<List<Product>> productsApiResponse = dvsApiClient.getProducts(1, 100);

	    boolean success = productsApiResponse.isSuccess();
	    int code = productsApiResponse.getCode();
	    List<ApiError> errorList = productsApiResponse.getErrors();//(Error(String code, String message))
	    List<Product> productList = productsApiResponse.getResult();
	    int totalPages = productsApiResponse.getTotalPages(); 
	    int totalRecords = productsApiResponse.getTotalRecords();
	    int CurrentPage = productsApiResponse.getCurrentPage();
	    int recordsPerPage = productsApiResponse.getRecordsPerPage(); 
	    int nextPage = productsApiResponse.getNextPage();
	    int previousPage = productsApiResponse.getPreviousPage();
		
	}
	
	
	private static void getProductsById(DvsApiClient dvsApiClient) throws DvsApiException {
		ApiResponse<Product> productByIdResponse = dvsApiClient.getProduct(123L);
	    boolean success = productByIdResponse.isSuccess();
	    int code = productByIdResponse.getCode();
	    List<ApiError> errorList = productByIdResponse.getErrors();
	    Product product = productByIdResponse.getResult();
		
	}
	
	
	private static void getProductsByFilter(DvsApiClient dvsApiClient) throws DvsApiException {
		 ProductFilter productFilter = new ProductFilter();
		    List<BenefitTypes> benefitTypes = new ArrayList<BenefitTypes>();
		    benefitTypes.add(BenefitTypes.TALKTIME);
		    benefitTypes.add(BenefitTypes.DATA);
		    productFilter.setBenefitTypes(benefitTypes);
		    productFilter.setType(ProductType.FIXED_VALUE_RECHARGE);
		    productFilter.setServiceId(1231L);
		    productFilter.setCountryIsoCode("UAE");
		    productFilter.setOperatorId(345L);
		    productFilter.setRegion("South");
		    ApiResponse<List<Product>> productsApiResponse = dvsApiClient.getProducts(productFilter);

		    boolean success = productsApiResponse.isSuccess();
		    int code = productsApiResponse.getCode();
		    List<ApiError> errorList = productsApiResponse.getErrors(); //(Error(String code, String message))
		    List<Product> productList = productsApiResponse.getResult();
		    int totalPages = productsApiResponse.getTotalPages(); 
		    int totalRecords = productsApiResponse.getTotalRecords();
		    int CurrentPage = productsApiResponse.getCurrentPage();
		    int recordsPerPage = productsApiResponse.getRecordsPerPage(); 
		    int nextPage = productsApiResponse.getNextPage();
		    int previousPage = productsApiResponse.getPreviousPage();
	}
	
	
	/*private static void docTransactions(DvsApiClient dvsClient) throws DvsApiException {
		//## HTTP POST operation Examples:

				//- Create transaction (Async)

				   // ```
				    TransactionRequest transactionRequest = new TransactionRequest();
				    transactionRequest.setExternalId("<String External Id>");
				    transactionRequest.setProductId(5L);
				    transactionRequest.setAutoConfirm(false);
				    PartyIdentifier creditPartyIdentifier = new PartyIdentifier();
				    creditPartyIdentifier.setMobileNumber("+628123456100");
				    creditPartyIdentifier.setAccountNumber("628123456100");
				    transactionRequest.setCreditPartyIdentifier(creditPartyIdentifier);
				        
				    ApiResponse<Transaction> transactionSyncResponse = dvsApiClient.createTransaction(txnRequest);
				 
				    boolean success = transactionSyncResponse.isSuccess();
				    int code = transactionSyncResponse.getCode();
				    List<Error> errorList = transactionSyncResponse.getErrors();
				    Transaction Transaction = transactionSyncResponse.getResult();
				    Long transactionId = transactionSyncResponse.getResult().getId();
				   // ```
				 
				//- Confirm Transaction:
				 
				    //`ApiResponse<Transaction> confirmTransactionSyncResponse = dvsApiClient.confirmTransaction(transactionId);`
				 
				//- Cancel Transaction:
				 
				   // `ApiResponse<Transaction> cancelTransaction = dvsApiClient.cancelTransaction(transactionId);`

			
	}*/
}