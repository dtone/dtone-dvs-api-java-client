# DT One DVS Client Library

![Logo](https://dvs-api-doc.dtone.com/images/dtone.png)

Language: Java

Latest Release: v2.0.0

An Open Source Client Library for Java applications to integrate and interact with
the Digital Value Services (DVS) API of [DT One](https://dtone.com)

This library takes care of handling the API requests/responses to allow developers to
focus on the business logic offered by the integration with DT One's DVS API. The goal of this
client is to ensure that the integration with DT One is seamless and hassle-free. Drop us a line in
the issue tracker if you feel that it can be improved!

## Features
- Ready-to-use interfaces to consume DT One's [DVS API](https://dvs-api-doc.dtone.com/)
- Pagination and Filtering support on API Responses
- Common response object
- Unit and functional testing with mocked responses from the API.

## Domain Objects
This library deals with the following list of domain objects from the DVS API:
 - Services
 - Countries
 - Operators
 - Benefit Types
 - Promotions
 - Products
 - Transactions
 - Balances

## Installation & Usage

- Requires Java 1.8 or later

- The library is available to be installed as a Maven Dependency or Standalone Java ARchive. Please [contact us](https://www.dtone.com/contact-us) if you are looking for a different option.

    1. Maven Dependency

        - Ensure that you have generated an access token from [github](https://github.com/settings/tokens)

            Github packages (where we've hosted our library's package) requires authentication
            (https://help.github.com/en/github/managing-packages-with-github-packages/about-github-packages#about-tokens)

        - Add your username and access token to `~/.m2/settings.xml`

         ```xml
         <settings>
           <servers>
               <server>
                   <id>github</id>
                   <username>{GithubUsername}</username>
                   <password>{GithubToken}</password>
               </server>
           </servers>
         </settings>
         ```

       - Add the following dependency in your `pom.xml`

           ```
           <dependency>
               <groupId>com.dtone.dvs</groupId>
               <artifactId>dvs-apiclient</artifactId>
               <version>1.0</version>
           </dependency>
           ```

       - Ensure that DT One maven repository is included in your `pom.xml`

           ```
           <repositories>
               <repository>
                   <id>github</id>
                   <name>Github DTOne Apache Maven Packages</name>
                   <url>https://maven.pkg.github.com/dtone/dtone-dvs-api-java-client</url>
               </repository>
           </repositories>
           ```
    2. Standalone JAR
        - Feel free to download the latest JAR with the dependencies directly from the repository [here](https://github.com/dtone/dtone-dvs-api-java-client/tree/master/release)
        and add the jar to the classpath of your project.
  
- Create an instance from DtoneHttpClient with your basic auth keys.
  
      ```
      import com.dtone.dvs.DvsApiClient;
      
      DvsClient dvsClient = new DvsClient(String baseUrl,
              String apiKey, String apiSecret)
      ```

- Start calling the DVS API!

## Available endpoints

- Service (Only GET operations)

    `Page<ApiResponse<List<Service>>> getServices() throws DvsApiException`

    `ApiResponse<List<Service>> getServices(int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Service> getService(Long serviceId) throws DvsApiException`

- Country (Only GET operations)

    `Page<ApiResponse<List<Country>>> getCountries() throws DvsApiException`

    `ApiResponse<List<Country>> getCountries(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<Country> getCountry(String countryIsoCode) throws DvsApiException`
    
- Operator (Only GET operations)

    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber) throws DvsApiException`
    
    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest) throws DvsApiException`

    `ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest, int pageNumber, int recordsPerPage) throws DvsApiException`

- Lookup operators for a mobile number (Only GET and POST operations)

    `GET ApiResponse<List<Operator>> lookupOperators(String mobileNumber) throws DvsApiException`
    
    `GET ApiResponse<List<Operator>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage) throws DvsApiException`

    `POST ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest) throws DvsApiException`

    `POST ApiResponse<List<Operator>> lookupOperators(LookupOperatorRequest lookupOperatorRequest, int pageNumber, int recordsPerPage) throws DvsApiException`

- Benefit Type (Only GET operations)

    `Page<ApiResponse<List<BenefitType>>> getBenefitTypes() throws DvsApiException`

    `ApiResponse<List<BenefitType>> getBenefitTypes(int pageNumber, int recordsPerPage) throws DvsApiException`
    
- Promotion (Only GET operations)

    `Page<ApiResponse<List<Promotion>>> getPromotions() throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter) throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter, int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Promotion> getPromotion(Long promotionId) throws DvsApiException`
    
- Product (Only GET operations)

    `Page<ApiResponse<List<Product>>> getProducts() throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(ProductFilter productFilter) throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(ProductFilter productFilter, int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<Product> getProduct(Long productId) throws DvsApiException`
    
- Transaction (Only GET & POST operations)

    `POST ApiResponse<Transaction> createTransaction(TransactionRequest transactionRequest) throws DvsApiException`
    
    `POST ApiResponse<Transaction> confirmTransaction(Long transactionId) throws DvsApiException`
    
    `POST ApiResponse<Transaction> cancelTransaction(Long transactionId) throws DvsApiException`

    `GET Page<ApiResponse<List<Transaction>>> getTransactions() throws DvsApiException`

    `GET ApiResponse<List<Transaction>> getTransactions(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `GET ApiResponse<List<Transaction>> getTransactions(TransactionFilter transactionFilter) throws DvsApiException`
    
    `GET ApiResponse<List<Transaction>> getTransactions(TransactionFilter transactionFilter, int pageNumber, int recordsPerPage) throws DvsApiException`

    `GET ApiResponse<Transaction> getTransaction(Long transactionId) throws DvsApiException`
    
- Balance (Only GET operations)

    `Page<ApiResponse<List<Balance>>> getBalances() throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(BalanceFilter balanceFilter) throws DvsApiException`

- List of products with inbuilt pagination:

    - All APIs which support pagination, return Page instance.
        ```
        DvsApiClient dvsApiClient = new DvsApiClient("https://dvsapi.com", "apiKey", "apiSecret");
        
        Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();

        int totalPages = pagedProductsResponse.getTotalPages();
        int totalRecords = pagedProductsResponse.getTotalRecords();
        int CurrentPage = pagedProductsResponse.getCurrentPage();
        int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
        int nextPage = pagedProductsResponse.getNextPage();
        int previousPage = pagedProductsResponse.getPreviousPage();

        // Alternatively, page info can be retrieved as PageInfo instance as below.
        PageInfo pageInfo = pagedProductsResponse.getPageInfo();
		        
        ApiResponse<List<Product>> productsResponse = pagedProductsResponse.first();
        
        List<Product> productList = productsResponse.getResult();

        for (Product product : productList) {
            Boolean isFixedTypeProduct = ProductUtils.isFixedType(product.getType());
			if (Boolean.TRUE.equals(isFixedTypeProduct)) {
                ProductFixed productFixed = (ProductFixed)product;
                
                Long id = productFixed.getId();
                List<BenefitFixed> benefitList = productFixed.getBenefits();
                SourceFixed source = productFixed.getSource();
                SourceFixed destination = productFixed.getDestination();
                ProductPricesFixed prices = productFixed.getPrices();
            } else {
                ProductRanged productRanged = (ProductRanged)product;
                
                Long id = productRanged.getId();
                List<BenefitRanged> benefitList = productRanged.getBenefits();
                SourceRanged source = productRanged.getSource();
                SourceRanged destination = productRanged.getDestination();
                ProductPricesRanged prices = productRanged.getPrices();
            }
        }
        ```

    - Fetch the first page records

        ```
        ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.first();
    
        List<Product> productList = productsApiResponse.getResult();
        ```

    - Fetch the next page records
        ```
        while(pagedProductsResponse.hasNext()){
            ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.next();
      
            List<Product> productList = productsApiResponse.getResult();
        }
        ```

    - Fetch the previous page records
    
        ```
        if(pagedProductsResponse.hasPrevious()){
            ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.previous();
      
            List<Product> productList = productsApiResponse.getResult();
        }
        ```

    - Fetch the last page records

        ```
        ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.last();
      
        List<Product> productList = productsApiResponse.getResult();
        ```

- List of products with custom pagination

    ```
    ApiResponse<List<Product>> productsApiResponse = dvsApiClient.getProducts(1, 100);

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


    //  Alternatively, page info can be retrieved as PageInfo instance as below.
    PageInfo pageInfo = productsApiResponse.getPageInfo();
    ```

- Get a product by id

    ```
    ApiResponse<Product> productByIdResponse = dvsApiClient.getProduct(123L);
    boolean success = productByIdResponse.isSuccess();
    int code = productByIdResponse.getCode();
    List<ApiError> errorList = productByIdResponse.getErrors();
    Product product = productByIdResponse.getResult();
    ```

- Get list of products with filters

    ```
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

    ApiResponse<List<Product>> getProducts(ProductFilter productFilter);

    boolean success = productsApiResponse.isSuccess()
    int code = productsApiResponse.getCode();

    List<ApiError> errorList = productsApiResponse.getErrors(); //(Error(String code, String message))

    List<Product> productList = productsApiResponse.getResult();

    PageInfo pageInfo = productsApiResponse.getPageInfo();
    ```

## HTTP POST operation Examples:
- Create Transaction with Auto Confirmation
    - Create transaction (auto_confirm = true)

        ```
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setExternalId("<String External Id>");
        transactionRequest.setAutoConfirm(true);
        transactionRequest.setProductId(20153L);
        transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+919962589100"));
        transactionRequest.setCallbackUrl("<Callback URL>");
            
        ApiResponse<Transaction> transactionAsyncResponse = dvsApiClient.createTransaction(transactionRequest);
     
        boolean success = transactionAsyncResponse.isSuccess();
        int code = transactionAsyncResponse.getCode();
        List<ApiError> errorList = transactionAsyncResponse.getErrors();
        Transaction Transaction = transactionAsyncResponse.getResult();

        Transaction transaction = transactionSyncResponse.getResult();
		Product product = transaction.getProduct();
		if(null != product) {
			Boolean isFixedTypeProduct = ProductUtils.isFixedType(product.getType());
			if (Boolean.TRUE.equals(isFixedTypeProduct)) {
				TransactionFixed transaction = (TransactionFixed)transaction;
				List<BenefitFixed> benefit = transaction.getBenefits();
				Long transactionId = transaction.getId();
			} else {
				TransactionRanged transaction = (TransactionRanged)transaction;
				List<BenefitRanged> benefit = transaction.getBenefits();
				Long transactionId = transaction.getId();
			}
		}
        ```
- Create Transaction with Manual Confirmation/Cancellation:
    - Create transaction (auto_confirm = false)
    
        ```
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setExternalId("<String External Id>");
        transactionRequest.setAutoConfirm(true);
        transactionRequest.setProductId(20153L);
        transactionRequest.setCreditPartyIdentifier(new PartyIdentifier("+919962589100"));
        transactionRequest.setCallbackUrl("<Callback URL>");
            
        ApiResponse<Transaction> transactionAsyncResponse = dvsApiClient.createTransaction(transactionRequest);
     
        boolean success = transactionAsyncResponse.isSuccess();
        int code = transactionAsyncResponse.getCode();
        List<ApiError> errorList = transactionAsyncResponse.getErrors();
        Transaction Transaction = transactionAsyncResponse.getResult();
        Long transactionId = transactionAsyncResponse.getResult().getId();
        ```
     
    - Confirm Transaction:
     
        `ApiResponse<Transaction> confirmTransactionResponse = dvsApiClient.confirmTransaction(transactionId);`
     
    - Cancel Transaction:
     
        `ApiResponse<Transaction> cancelTransactionResponse = dvsApiClient.cancelTransaction(transactionId);`

## Basic Troubleshooting and frequently asked questions:

- Should an application create more than one DvsApiClient?
    
    There should be no need to do that in a single application.
    
- Is it mandatory to set all values in a filter instance?
    
    No

## License
[DTOne](http://dtone.com)
