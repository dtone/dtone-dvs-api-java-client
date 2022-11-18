# Change Log

## [2.0.0] - 2022-11-13
### Added
- New POST API to lookup operators.
- Campaign APIs - disabled.
- 'regions' to Country.
- 'tags', 'pin' to get products API.
- 'addressText', 'addressCity', 'addressCountryIsoCode' and 'addressPostalCode' to party identifier.
- filters 'productType', 'serviceId', 'countryIsoCode', 'operatorId', 'statusId', 'creditPartyMobileNumber', 'creditPartyAccountNumber', 'fromDate' and toDate to get transaction api.
- Product type RANGED_VALUE_PAYMENT

### Changed
- Enhanced statement APIs - disabled.
- Get products API response based on product type.
- Get transactions API response based on product type.
- Updated documentation.
- Enhanced java doc.
- Refactored.

### Removed
- Config allowing unknown fields in the API response.
- Product type FIXED_VALUE_PAYMENT.
- Sync post transactions API.
- Sync confirm transactions API.

## [1.1.0] - 2021-07-26
### Changed
- Incorporate DVS API changes after Feb 2020

## [1.0.0] - 2019-12-08
### Added
- API Discovery, Transactions, Account and Lookup interfaces
- Pagination support
- Discovery filters support
