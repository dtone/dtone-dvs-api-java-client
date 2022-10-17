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
- ~~Unit and functional testing with mocked responses from the API.~~ TODO
- Asynchronous calls

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

- Requires Java 17 or later

- The library is available to be installed as a Maven Dependency or Standalone Java Archive.

    1. Maven Dependency

       - Add the following dependency in your `pom.xml`

           ```xml
           <dependency>
               <groupId>com.vincejv</groupId>
               <artifactId>dvs-apiclient</artifactId>
               <version>2.1.3</version> <!-- replace with latest version -->
           </dependency>
           ```
    2. Standalone JAR
        - Feel free to download the latest JAR with the dependencies directly from maven central [here](https://repo.maven.apache.org/maven2/com/vincejv/dvs-apiclient/)
        and add the jar to the classpath of your project.
  
- Create an instance from `DvsApiClientAsync` with your basic auth keys.
    ```java
    import com.dtone.dvs.DvsApiClient;
    
    DvsApiClientAsync dvsClient = new DvsApiClientAsync(String baseUrl,
            String apiKey, String apiSecret)
    ```
- Start calling the DVS API!

## Available endpoints
#### Note: For v2 custom build, documentation has to be updated, all calls return `CompletableFuture`

- Service (Only GET operations)

    `Page<ApiResponse<List<Service>>> getServices() throws DvsApiException`

    `ApiResponse<List<Service>> getServices(int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Service> getService(Long serviceId) throws DvsApiException`

- Country (Only GET operations)

    `Page<ApiResponse<List<Country>>> getCountries() throws DvsApiException`

    `ApiResponse<List<Country>> getCountries(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<Country> getCountry(String countryIsoCode) throws DvsApiException`
    
- Operator (Only GET operations)

    `Page<ApiResponse<List<Operator>>> getOperators() throws DvsApiException`

    `ApiResponse<List<Operator>> getOperators(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Operator>> getOperators(String countryIsoCode) throws DvsApiException`

    `ApiResponse<List<Operator>> getOperators(String countryIsoCode, int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Operator> getOperator(Long operatorId) throws DvsApiException`
    
    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber) throws DvsApiException`
    
    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage) throws DvsApiException`

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

    `ApiResponse<TransactionResponse> createTransaction(TransactionRequest transactionRequest, boolean synchronous) throws DvsApiException`
    
    `ApiResponse<TransactionResponse> confirmTransaction(Long transactionId, boolean synchronous) throws DvsApiException`
    
    `ApiResponse<TransactionResponse> cancelTransaction(Long transactionId) throws DvsApiException`
    

    `ApiResponse<TransactionResponse> getTransaction(Long transactionId) throws DvsApiException`
    
    `ApiResponse<List<TransactionResponse>> getTransactions(TransactionFilter transactionFilter) throws DvsApiException`
    
    `ApiResponse<List<TransactionResponse>> getTransactions(TransactionFilter transactionFilter, int pageNumber, int recordsPerPage) throws DvsApiException`
    
- Balance (Only GET operations)

    `Page<ApiResponse<List<Balance>>> getBalances() throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(BalanceFilter balanceFilter) throws DvsApiException`

- List of products with inbuilt pagination:

    - All APIs which support pagination, return Page instance.
        ```java
        DvsApiClient dvsApiClient = new DvsApiClient("https://dvsapi.com", "apiKey", "apiSecret");
        
        Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();
        ```

    - Fetch the first page records

        ```java
        ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.first();
    
        List<Product> productList = productsApiResponse.getResult();
        ```

    - Fetch the next page records
        ```java
        while(pagedProductsResponse.hasNext()){
            ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.next();
      
            List<Product> productList = productsApiResponse.getResult();
        }
        ```

    - Fetch the previous page records
    
        ```java
        if(pagedProductsResponse.hasPrevious()){
            ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.previous();
      
            List<Product> productList = productsApiResponse.getResult();
        }
        ```

    - Fetch the last page records

        ```java
        ApiResponse<List<Product>> productsApiResponse = pagedProductsResponse.last();
      
        List<Product> productList = productsApiResponse.getResult();

        int totalPages = pagedProductsResponse.getTotalPages(); 
        int totalRecords = pagedProductsResponse.getTotalRecords();
        int CurrentPage = pagedProductsResponse.getCurrentPage();
        int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
        int nextPage = pagedProductsResponse.getNextPage();
        int previousPage = pagedProductsResponse.getPreviousPage();
        ```

- List of products with custom pagination

    ```java
    ApiResponse<List<Product>> productsApiResponse = dvsApiClient.getProducts(1, 100);

    boolean success = productsApiResponse.isSuccess()
    int code = productsApiResponse.getCode();
    List<Error> errorList = productsApiResponse.getErrors(); //(Error(String code, String message))
    List<Product> productList = productsApiResponse.getResult();
    int totalPages = productsApiResponse.getTotalPages(); 
    int totalRecords = productsApiResponse.getTotalRecords();
    int CurrentPage = productsApiResponse.getCurrentPage();
    int recordsPerPage = productsApiResponse.getRecordsPerPage(); 
    int nextPage = productsApiResponse.getNextPage();
    int previousPage = productsApiResponse.getPreviousPage();
    ```

- Get a product by id

    ```java
    ApiResponse<Product> productByIdResponse = dvsApiClient.getProduct(123L);
    boolean success = productByIdResponse.isSuccess();
    int code = productByIdResponse.getCode();
    List<Error> errorList = productByIdResponse.getErrors();
    Product product = productByIdResponse.getResult();
    ```

- Get list of products with filters

    ```java
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
    List<Error> errorList = productsApiResponse.getErrors(); //(Error(String code, String message))
    List<Product> productList = productsApiResponse.getResult();
    int totalPages = productsApiResponse.getTotalPages(); 
    int totalRecords = productsApiResponse.getTotalRecords();
    int CurrentPage = productsApiResponse.getCurrentPage();
    int recordsPerPage = productsApiResponse.getRecordsPerPage(); 
    int nextPage = productsApiResponse.getNextPage();
    int previousPage = productsApiResponse.getPreviousPage();
    ```

## HTTP POST operation Examples:

- Create transaction (Sync/Async)

    A transaction can be posted in 2 modes.
    1. Synchronous
    2. Asynchronous
 
    ```java
    boolean synchronous = true;
    TransactionRequest transactionRequest = new TransactionRequest();
    transactionRequest.setExternalId("<String External Id>");
    transactionRequest.setProductId(5L);
    transactionRequest.setAutoConfirm(false);
    PartyIdentifier creditPartyIdentifier = new PartyIdentifier();
    creditPartyIdentifier.setMobileNumber("+628123456100");
    creditPartyIdentifier.setAccountNumber("628123456100");
    transactionRequest.setCreditPartyIdentifier(creditPartyIdentifier);
        
    ApiResponse<TransactionResponse> transactionSyncResponse = dvsApiClient.createTransaction(txnRequest, synchronous);
 
    boolean success = transactionSyncResponse.isSuccess();
    int code = transactionSyncResponse.getCode();
    List<Error> errorList = transactionSyncResponse.getErrors();
    TransactionResponse transactionResponse = transactionSyncResponse.getResult();
    Long transactionId = transactionSyncResponse.getResult().getId();
 
- Confirm Transaction:
 
    `ApiResponse<TransactionResponse> confirmTransactionSyncResponse = dvsApiClient.confirmTransaction(transactionId, synchronous);`
 
- Cancel Transaction:
 

    `ApiResponse<TransactionResponse> cancelTransactionResponse = dvsApiClient.cancelTransaction(transactionId);`

## Basic Troubleshooting and frequently asked questions:

- Should an application create more than one DvsApiClient?
    
    There should be no need to do that in a single application.
    
- Is it mandatory to set all values in a filter instance?
    
    No

## License
- [DTOne](http://dtone.com)
- [MIT](https://github.com/vincejv/dtone-dvs-api-java-client/blob/master/LICENSE.txt)
