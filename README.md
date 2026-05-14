# dnext-opentmf-v4-models

> ## ⚠️ Superseded — please migrate
>
> This project has been superseded by **`org.opentmf.model:dnext-v4-models`**.
> All developers are encouraged to switch to `dnext-v4-models` as soon as possible.
>
> Differences:
> - **Generated, not hand-written.** `dnext-v4-models` is a generated project, so it
>   contains **all** Dnext model classes — not just the subset that was manually
>   placed in this project.
> - **Jackson 3.** `dnext-v4-models` registers extensions using Jackson 3, whereas this
>   project uses Jackson 2. The newer `dnext-v4-models` is therefore intended for
>   **Spring Boot 4** deployments.

## About this project

This is **not** a generated project. Its classes are hand written by manually
extending the `opentmf-v4-models` classes. As the Dnext models continue to grow,
this project would require additional manual updates to keep up — which is one of
the reasons it has been superseded by the generated `dnext-v4-models`.

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

See [CHANGELOG.md](CHANGELOG.md) for the full version history.