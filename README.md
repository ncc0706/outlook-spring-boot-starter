# Outlook spring boot starter


## Usage

```xml
<dependency>
    <groupId>io.github.ncc0706</groupId>
    <artifactId>outlook-spring-boot-starter</artifactId>
    <version>0.0.2</version>
</dependency>
```

```java
@Autowired
private ITokenCacheService tokenCacheService;
@GetMapping("token")
public String geToken(){
    return tokenCacheService.getToken();
}
```