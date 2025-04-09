# dnext-opentmf-633-v4-model

This artifact holds the Dnext extended model classes for the TMF-633 Service Catalog Management .

## Usage
In order to use this model library, and teach Jackson to consider the extended model classes, the following two things needs to be done:

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
#### Add dnext-opentmf-633-v4-model Module
```xml
<dependency>
  <groupId>org.opentmf.dnext</groupId>
  <artifactId>dnext-opentmf-633-v4-model</artifactId>
</dependency>
```

### 2. Configure the ObjectMapper
Within your ObjectMapper java config code, you need to register the extended classes to Jackson so that ObjectMapper can recognize them.

```java
@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    var objectMapper = JacksonUtil.getDefaultObjectMapper();
    DnextTmf633JacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
## Version History
### 4.0.0.5
- Initial version
