# dnext-opentmf-639-v4-model

This artifact holds the Dnext extended model classes for the TMF-639 Resource Inventory Management API.

## Usage

In order to use this model library, and teach Jackson to consider the extended model classes, the following two things need to be done:

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

#### Add dnext-opentmf-639-v4-model Module

```xml
<dependency>
  <groupId>org.opentmf.dnext</groupId>
  <artifactId>dnext-opentmf-639-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper

Within your ObjectMapper Java config code, register the extended classes so Jackson recognizes them.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    DnextTmf639JacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```

## Version History

### 4.0.0.0

- Initial version: extended `LogicalResource` and `PhysicalResource` with audit fields; Jackson config chains TMF-639, Dnext common mix-ins, and subtype registration.

### 4.0.0.1

- Extended `ResourceCreate` / `ResourceUpdate` with DNext fields (`resourceOrderItem`, `productOrderItem`, `serviceOrderItem`, `relatedEntity`, `aclRelatedParty`, `extensions`, `statusReason`) via `DnextResourceCreate` / `DnextResourceUpdate` and `DnextRelatedResourceOrderItem` / `DnextIdentifierRange`.
- Ported bulk and snapshot payloads: `DnextBulkResourceCreate`, `DnextBulkCharacteristic`, `DnextBulkResourceCharacteristicUpdate`, `DnextBulkResourceStatusUpdate`, `DnextResourceSnapshot`, `DnextResourceSnapshotCreate`.
