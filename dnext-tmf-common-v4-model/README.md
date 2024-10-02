# dnext-tmf-common-model

This artifact holds the shared Dnext extended model classes for the TMF APIs.

## Usage
This library is included from any Dnext extended tmf model classes. So, it should not be necessary to define a meven dependency within your project. However, for certain cases, where only the extended shared model classes are enough for your use-case, the following can be performed:


### 1. Add Maven Dependency
```xml
<dependencyManagement>
  <dependency>
    <groupId>com.pia.commons</groupId>
    <artifactId>pia-commons-versions</artifactId>
    <version>RELEASE</version>
    <type>pom</type>
    <scope>import</scope>
  </dependency>
</dependencyManagement>
```
#### Add dnext-tmf-common-v4-model Module
```xml
<dependency>
    <groupId>com.pia.commons</groupId>
    <artifactId>dnext-tmf-common-v4-model</artifactId>
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
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    return objectMapper;
  }
}
```

## Version History
### 4.1.0.0
- Initial Version
### 4.0.0.1
- Depends on the recent TMF v4 model classes.
### 4.0.0.2
- Appends v4 into module names.
- Depends on the recent TMF v4 model classes.
