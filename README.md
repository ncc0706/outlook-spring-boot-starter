# Outlook spring boot starter


## Usage

**pom.xml**
```xml
<dependency>
    <groupId>io.github.ncc0706</groupId>
    <artifactId>outlook-spring-boot-starter</artifactId>
    <version>0.0.2</version>
</dependency>
```
**application.yaml**
```yaml
msal:
  client-id: d39dbe926ff
  secret: WcB8Q~hqh36Kdyk
  scope: https://outlook.office365.com/.default
  authority: https://login.microsoftonline.com/73fcd2e73f
```

**java code**
```java
@Autowired
private ITokenCacheService tokenCacheService;

@GetMapping("token")
public String geToken(){
    return tokenCacheService.getToken();
}
```

