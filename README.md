# dnext-tmf-models

Contains the Dnext extended model classes for certain TMF modules.

The project is a multi-module project, that holds the commonly used classes in its dnext-tmf-common-model module and the corresponding model classes into their own dnext-tmf-XYZ-model libraries.

Currently, it holds Dnext extended model classes for the following TMF APIs:
- [TMF-622](dnext-tmf-622-model/README.md) Product Ordering Management
- [TMF-638](dnext-tmf-638-model/README.md) Service Inventory Management
- [TMF-641](dnext-tmf-641-model/README.md) Service Ordering Management
- [TMF common](dnext-tmf-common-model/README.md) classes shared by the above extended Dnext TMF APIs.

## Latest Versions Diagram

![](src/main/config/model/tmf-models.jpg)

## Requirements

- Java 17
- Calling registerExtensions static Java method(s) for the desired library/libraries.
  - **Note:** _registerExtensions will be calling the hierarchical registerExtensions methods in the inherited libraries. Hence, calling only one registerExtensions per tmf library is enough._

## Version History
### 1.0.0
- Initial Version