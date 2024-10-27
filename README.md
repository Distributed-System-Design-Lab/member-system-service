```bash
mvn -P platform install
docker build -t papakao/peoplesystem-keycloak:latest .
docker push papakao/peoplesystem-keycloak:latest
```