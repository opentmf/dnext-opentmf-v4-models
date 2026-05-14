# dnext-opentmf-v4-models

Contains the Dnext extended model classes for certain TMF modules.

The project is a multi-module project, that holds the commonly used classes in its dnext-opentmf-common-v4-model module and the corresponding model classes into their own dnext-opentmf-XYZ-model libraries.

Currently, it holds Dnext extended model classes for the following TMF APIs:
- [TMF-620](dnext-opentmf-620-v4-model/README.md) Product Catalog Management
- [TMF-622](dnext-opentmf-622-v4-model/README.md) Product Ordering Management
- [TMF-638](dnext-opentmf-638-v4-model/README.md) Service Inventory Management
- [TMF-639](dnext-opentmf-639-v4-model/README.md) Resource Inventory Management
- [TMF-641](dnext-opentmf-641-v4-model/README.md) Service Ordering Management
- [TMF-663](dnext-opentmf-663-v4-model/README.md) Shopping Cart Management
- [TMF-666](dnext-opentmf-666-v4-model/README.md) Account Management
- [TMF common](dnext-opentmf-common-v4-model/README.md) classes shared by the above extended Dnext TMF APIs.

## Usage
### 1. Add Maven Dependency
#### Import OpenTMF Commons Dependencies
```xml
<dependencyManagement>
  <dependency>
    <groupId>org.opentmf</groupId>
    <artifactId>opentmf-versions</artifactId>
    <version>RELEASE</version>
    <type>pom</type>
    <scope>import</scope>
  </dependency>
</dependencyManagement>
```
#### Add dnext-opentmf-xyz-v4-model Modules
```xml
<dependencies>
  <dependency>
    <groupId>org.opentmf.dnext</groupId>
    <artifactId>dnext-opentmf-638-v4-model</artifactId>
  </dependency>
  <dependency>
    <groupId>org.opentmf.dnext</groupId>
    <artifactId>dnext-opentmf-639-v4-model</artifactId>
  </dependency>
  <dependency>
    <groupId>org.opentmf.dnext</groupId>
    <artifactId>dnext-opentmf-641-v4-model</artifactId>
  </dependency>
</dependencies>
```

## Module boundaries

- **`dnext-opentmf-NNN-v4-model` modules must not depend on each other.** Each TMF extension module may depend on **`dnext-opentmf-common-v4-model`** and on OpenTMF artifacts (for example `opentmf-639-v4-model`), but not on another `dnext-opentmf-MMM-v4-model`.
- **`dnext-opentmf-common-v4-model`** is for types that **more than one** TMF module would actually reuse. Types that are only used within one TMF area (for example extended resource create/update used only with TMF-639) stay in that module’s library.
- TMF extension modules should still list only their own `opentmf-NNN-v4-model` plus **`dnext-opentmf-common-v4-model`** in the POM; **`dnext-opentmf-common-v4-model`** also declares **`opentmf-product-v4-model`** and **`opentmf-service-v4-model`** so cross-domain OpenTMF types (for example on resource create/update) are available transitively without duplicating those dependencies on every TMF module, at the cost of every common consumer inheriting those two jars.

To catch accidental sibling dependencies in CI, add a Maven Enforcer `bannedDependencies` rule on the parent reactor (exclude each `org.opentmf.dnext:dnext-opentmf-NNN-v4-model` except `dnext-opentmf-common-v4-model`).

## Requirements

- Java 17
- Calling registerExtensions static Java method(s) for the desired library/libraries.
  - **Note:** _registerExtensions will be calling the hierarchical registerExtensions methods in the inherited libraries. Hence, calling only one registerExtensions per tmf library is enough._

## Version History
### 1.0.0
- Initial Version
### 1.0.1
- Starts Using new TMF-v4 Clients versions
- Adds new classes to dnext-opentmf-641-v4-models
### 1.0.2
- Appends v4 into module names.
- Depends on the recent TMF v4 model classes.
### 1.0.3
- Fixes DNextServiceOrderItem missing Getter Setter
- Adds orderCharacteristic to DNextServiceOrder
### 1.0.4
- Updates to use the new versions of tmf-v4-models v3 and spring-boot 3.4.0
### 1.0.5
- Adds dnext-opentmf-633-v4-model service catalog model.
- Adds cancellationType to DNext's TMF-641 CancelServiceOrder extended classes.
- Centralize the fulfillmentSpecification extension and remove the obsoleted old format.
### 1.0.6
- Adds DNextProductSpecificationCharacteristic and DnextProductSpecificationCharacteristicValueUse classes for dnext-opentmf-620-v4-model.
- Updates Spring Boot version to 3.4.1
### 1.0.7
- Removed is from the boolean properties and added jsonProperty for DnextProductSpecificationCharacteristicValueUse and DnextProductSpecificationCharacteristic.
- Updates Spring Boot version to 3.4.2
### 1.0.8
- Fixed removing is from the boolean properties and added jsonProperty for DnextProductSpecificationCharacteristicValueUse and DnextProductSpecificationCharacteristic.
### 1.0.9
- Adds DNextProductOffering with the extended field "rules".
- Updates to Spring Boot 3.4.3
### 1.1.0
- The initial open-source version
- Updates to Spring Boot 3.4.4
### 1.1.1
- Adds dnext-opentmf-639-v4-model (TMF-639 Resource Inventory extensions).

### 1.1.2
- Documents module boundary rules in the README (common vs TMF-specific; no inter-sibling `dnext-opentmf-*` dependencies) and optional Enforcer guidance.

### 1.1.3
- Declares `opentmf-product-v4-model` and `opentmf-service-v4-model` on `dnext-opentmf-common-v4-model`; `dnext-opentmf-639-v4-model` depends only on `opentmf-639-v4-model` plus common for those cross-domain types.