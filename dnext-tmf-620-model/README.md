# dnext-tmf-620-model

This artifact holds the Dnext extended model classes for the TMF-620 Product Catalog Management .

## Usage
In order to use this model library, and teach Jackson to consider the extended model classes, the following two things needs to be done:

### 1. Add Maven Dependency
```xml
<dependency>
    <groupId>com.pia.commons</groupId>
    <artifactId>dnext-tmf-620-model</artifactId>
    <version>${version}</version>
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
    DnextTmf620JacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```
## Version History
### 4.0.0.0
- Initial version