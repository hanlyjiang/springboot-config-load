# https配置

https://blog.csdn.net/blackbutton_cc/article/details/99956259

## 证书生成
```shell script

SERVER_ALIAS=server
CLIENT_ALIAS=client
STORETYPE=JKS
#STORETYPE=PKCS12
SERVER_KEYSTORE=server.jks
CLIENT_KEYSTORE=client.jks


# 生成服务端keystore
# -genkey = -genkeypair
keytool -genkey -alias $SERVER_ALIAS -keyalg RSA \
    -keystore server.jks \
    -validity 360 -storepass 123456 -storetype $STORETYPE \
    -keysize 2048 \
    -keypass 123456 \
    -dname "CN=localhost, OU=localhost, O=localhost, L=CD, ST=CD, C=CN"

# 导出服务端证书
keytool -exportcert -keystore $SERVER_KEYSTORE -alias $SERVER_ALIAS -file server.cer 
# 导出服务端证书的pem版本（在android中作为string使用）
keytool -keystore -rfc $CLIENT_KEYSTORE -export -alias client -file client.cer

# 生成客户端证书
keytool -genkey -alias $CLIENT_ALIAS   \
    -keyalg RSA   \
    -keystore client.jks -validity 360 \
    -storepass 123456 -storetype $STORETYPE  \
    -keypass 123456 \
    -keysize 2048 -dname "CN=client, OU=client, O=client, L=CD, ST=CD, C=CN"

# 导出客户端证书
keytool -keystore $CLIENT_KEYSTORE -export -alias client -file client.cer


# 导入客户端证书到服务端keystore
keytool -import -alias $CLIENT_ALIAS -file client.cer -keystore $SERVER_KEYSTORE
# 导入服务端证书到客户端keystore
keytool -import -alias $SERVER_ALIAS -file server.cer -keystore $CLIENT_KEYSTORE

keytool -list -keystore  $SERVER_KEYSTORE
keytool -list -keystore  $CLIENT_KEYSTORE
```

## 修改配置
```properties
server.port=8443

server.ssl.enabled=true
server.ssl.key-store-type=JKS
server.ssl.key-store=classpath:server.jks
server.ssl.key-store-password=123456
server.ssl.key-alias=server

server.ssl.trust-store=classpath:server.jks
server.ssl.trust-store-password=123456
server.ssl.trust-store-provider=SUN
server.ssl.trust-store-type=JKS
server.ssl.client-auth=need

作者：南瓜慢说
链接：https://juejin.cn/post/6844904147968327693
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## Android 端处理



## 其他
### 导出服务端证书请求
```shell script
keytool -certreq -file server.csr -v -keypass 123456 -keystore server.p12 -alias server
```


## 使用openssl导出私钥:
> 参考： https://security.stackexchange.com/questions/3779/how-can-i-export-my-private-key-from-a-java-keytool-keystore
````shell script
# 转换成pkcs12证书格式
keytool -importkeystore -srckeystore server.jks -destkeystore server.p12 -deststoretype pkcs12
# 导出私钥
openssl pkcs12 -in server.p12  -nokeys -out server.cert.pem
# 导出未加密的私钥:
openssl pkcs12 -in server.p12  -nodes -nocerts -out server.key.pem
````


# 查看：
```shell script
keytool -genkey -alias foo -keystore server.p12 -dname cn=test -storepass 123456 -keypass 123456
```

