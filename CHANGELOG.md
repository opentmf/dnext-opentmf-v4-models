# Changelog

All notable changes to this project are documented in this file.

## [1.1.1] - 2026-05-14
- Adds dnext-opentmf-639-v4-model (TMF-639 Resource Inventory extensions).
- Documents module boundary rules in the README (common vs TMF-specific; no inter-sibling `dnext-opentmf-*` dependencies) and optional Enforcer guidance.
- Declares `opentmf-product-v4-model` and `opentmf-service-v4-model` on `dnext-opentmf-common-v4-model`; `dnext-opentmf-639-v4-model` depends only on `opentmf-639-v4-model` plus common for those cross-domain types.
- Bumps Spring Boot to 3.5.14, and updates many dependency versions

## [1.1.0] - 2025-04-09
- The initial open-source version
- Updates to Spring Boot 3.4.4

## [1.0.9]
- Adds DNextProductOffering with the extended field "rules".
- Updates to Spring Boot 3.4.3

## [1.0.8]
- Fixed removing is from the boolean properties and added jsonProperty for DnextProductSpecificationCharacteristicValueUse and DnextProductSpecificationCharacteristic.

## [1.0.7]
- Removed is from the boolean properties and added jsonProperty for DnextProductSpecificationCharacteristicValueUse and DnextProductSpecificationCharacteristic.
- Updates Spring Boot version to 3.4.2

## [1.0.6]
- Adds DNextProductSpecificationCharacteristic and DnextProductSpecificationCharacteristicValueUse classes for dnext-opentmf-620-v4-model.
- Updates Spring Boot version to 3.4.1

## [1.0.5]
- Adds dnext-opentmf-633-v4-model service catalog model.
- Adds cancellationType to DNext's TMF-641 CancelServiceOrder extended classes.
- Centralize the fulfillmentSpecification extension and remove the obsoleted old format.

## [1.0.4]
- Updates to use the new versions of tmf-v4-models v3 and spring-boot 3.4.0

## [1.0.3]
- Fixes DNextServiceOrderItem missing Getter Setter
- Adds orderCharacteristic to DNextServiceOrder

## [1.0.2]
- Appends v4 into module names.
- Depends on the recent TMF v4 model classes.

## [1.0.1]
- Starts Using new TMF-v4 Clients versions
- Adds new classes to dnext-opentmf-641-v4-models

## [1.0.0]
- Initial Version
