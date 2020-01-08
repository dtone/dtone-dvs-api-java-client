# DT One DVS Client Library

![Logo](https://dvs-api-doc.dtone.com/images/dtone.png)

Language: Java

Latest Release: v1.0.0

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

- Add the following dependency in your `pom.xml`

    ```
    <dependency>
        <groupId>com.dtone.dvs</groupId>
        <artifactId>dvs-apiclient</artifactId>
        <version>1.0</version>
    </dependency>
    ```

- Create an instance from DtoneHttpClient with your basic auth keys.
  
      ```
      import com.dtone.dvs.DvsApiClient;
      
      DvsClient dvsClient = new DvsClient(String baseUrl,
              String apiKey, String apiSecret)
      ```

## Available APIs

- Service APIs (Only GET operations)

    `Page<ApiResponse<List<Service>>> getServices() throws DvsApiException`

    `ApiResponse<List<Service>> getServices(int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Service> getService(Long serviceId) throws DvsApiException`

- Country APIs (Only GET operations)

    `Page<ApiResponse<List<Country>>> getCountries() throws DvsApiException`

    `ApiResponse<List<Country>> getCountries(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<Country> getCountry(String countryIsoCode) throws DvsApiException`
    
- Operator APIs (Only GET operations)

    `Page<ApiResponse<List<Operator>>> getOperators() throws DvsApiException`

    `ApiResponse<List<Operator>> getOperators(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Operator>> getOperators(String countryIsoCode) throws DvsApiException`

    `ApiResponse<List<Operator>> getOperators(String countryIsoCode, int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Operator> getOperator(Long operatorId) throws DvsApiException`
    
    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber) throws DvsApiException`
    
    `ApiResponse<List<Operator>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage) throws DvsApiException`

- Benefit Type APIs (Only GET operations)

    `Page<ApiResponse<List<BenefitType>>> getBenefitTypes() throws DvsApiException`

    `ApiResponse<List<BenefitType>> getBenefitTypes(int pageNumber, int recordsPerPage) throws DvsApiException`
    
- Promotion APIs (Only GET operations)

    `Page<ApiResponse<List<Promotion>>> getPromotions() throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter) throws DvsApiException`
    
    `ApiResponse<List<Promotion>> getPromotions(PromotionFilter promotionFilter, int pageNumber, int recordsPerPage) throws DvsApiException`

    `ApiResponse<Promotion> getPromotion(Long promotionId) throws DvsApiException`
    
- Product APIs (Only GET operations)

    `Page<ApiResponse<List<Product>>> getProducts() throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(ProductFilter productFilter) throws DvsApiException`
    
    `ApiResponse<List<Product>> getProducts(ProductFilter productFilter, int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<Product> getProduct(Long productId) throws DvsApiException`
    
- Transaction APIs (Only GET & POST operations)

    `ApiResponse<TransactionResponse> createTransaction(TransactionRequest transactionRequest, boolean synchronous) throws DvsApiException`
    
    `ApiResponse<TransactionResponse> confirmTransaction(Long transactionId, boolean synchronous) throws DvsApiException`
    
    `ApiResponse<TransactionResponse> cancelTransaction(Long transactionId) throws DvsApiException`
    

    `ApiResponse<TransactionResponse> getTransaction(Long transactionId) throws DvsApiException`
    
    `ApiResponse<List<TransactionResponse>> getTransactions(TransactionFilter transactionFilter) throws DvsApiException`
    
    `ApiResponse<List<TransactionResponse>> getTransactions(TransactionFilter transactionFilter, int pageNumber, int recordsPerPage) throws DvsApiException`
    
- Balance APIs (Only GET operations)

    `Page<ApiResponse<List<Balance>>> getBalances() throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(int pageNumber, int recordsPerPage) throws DvsApiException`
    
    `ApiResponse<List<Balance>> getBalances(BalanceFilter balanceFilter) throws DvsApiException`
    
## Prerequisites

- Java 1.8

## Checkout SDK from Github
`ssh://git@git.transferto.com:10022/java/dtone-dvs-api-java-client.git`

`cd dtone-dvs-api-java-client/`

## Production Java applications

For Java applications use the latest released version of the SDK releases:

1. Download the jar from the [here]("https://dtoe.com/dtone-dvs-api-java-client.jar")
2. Add the jar to the classpath of your project

## Using the SDK

1. Create an instance from DvsApiClient with your basic auth keys.

    ```
    DvsApiClient dvsApiClient = new DvsApiClient(String baseUrl, String apiKey, String apiSecret)
    ```
        
2. Call the available methods in the dvsApiClient instance.

## HTTP GET operation Examples:

- List of products with inbuilt pagination:

    - All APIs which support pagination, return Page instance.
        ```
        DvsApiClient dvsApiClient = new DvsApiClient("https://dvsapi.com", "apiKey", "apiSecret");
        
        Page<ApiResponse<List<Product>>> pagedProductsResponse = dvsApiClient.getProducts();
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

        int totalPages = pagedProductsResponse.getTotalPages(); 
        int totalRecords = pagedProductsResponse.getTotalRecords();
        int CurrentPage = pagedProductsResponse.getCurrentPage();
        int recordsPerPage = pagedProductsResponse.getRecordsPerPage(); 
        int nextPage = pagedProductsResponse.getNextPage();
        int previousPage = pagedProductsResponse.getPreviousPage();
        ```


- List of products with custom pagination

    ```
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

    ```
    ApiResponse<Product> productByIdResponse = dvsApiClient.getProduct(123L);
    boolean success = productByIdResponse.isSuccess();
    int code = productByIdResponse.getCode();
    List<Error> errorList = productByIdResponse.getErrors();
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
 
    ```
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
[DTOne](http://dtone.com)
