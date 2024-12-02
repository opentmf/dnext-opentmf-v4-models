# dnext-tmf-models

Contains the Dnext extended model classes for certain TMF modules.

The project is a multi-module project, that holds the commonly used classes in its dnext-tmf-common-model module and the corresponding model classes into their own dnext-tmf-XYZ-model libraries.

Currently, it holds Dnext extended model classes for the following TMF APIs:
- [TMF-620](dnext-tmf-620-v4-model/README.md) Product Catalog Management
- [TMF-622](dnext-tmf-622-v4-model/README.md) Product Ordering Management
- [TMF-638](dnext-tmf-638-v4-model/README.md) Service Inventory Management
- [TMF-641](dnext-tmf-641-v4-model/README.md) Service Ordering Management
- [TMF-663](dnext-tmf-663-v4-model/README.md) Shopping Cart Management
- [TMF-666](dnext-tmf-666-v4-model/README.md) Account Management
- [TMF common](dnext-tmf-common-v4-model/README.md) classes shared by the above extended Dnext TMF APIs.

## Usage
```xml
<dependencies>
  <dependency>
    <groupId>com.pia.commons</groupId>
    <artifactId>dnext-tmf-638-v4-model</artifactId>
  </dependency>
  <dependency>
    <groupId>com.pia.commons</groupId>
    <artifactId>dnext-tmf-641-v4-model</artifactId>
  </dependency>
</dependencies>
```

## Requirements

- Java 17
- Calling registerExtensions static Java method(s) for the desired library/libraries.
  - **Note:** _registerExtensions will be calling the hierarchical registerExtensions methods in the inherited libraries. Hence, calling only one registerExtensions per tmf library is enough._

## Version History
### 1.0.0
- Initial Version
### 1.0.1
- Starts Using new TMF-v4 Clients versions
- Adds new classes to dnext-tmf-641-models
### 1.0.2
- Appends v4 into module names.
- Depends on the recent TMF v4 model classes.
### 1.0.3
- Fixes DNextServiceOrderItem missing Getter Setter
- Adds orderCharacteristic to DNextServiceOrder
### 1.0.4
- Updates to use the new versions of tmf-v4-models v3 and spring-boot 3.4.0
