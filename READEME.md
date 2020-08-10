# Spring-Boot Simple CRUD API

## Overview

Spring Boot Users C.R.U.D. API, is implemented by the following Tech-Stack:

- Spring-Boot 2.3.1
- Spring-Fox Swagger 2.9.2
- Spring-Fox Swagger UI 2.9.2
- Lombok
- Hibernate
- MySQL 8
- Docker

### NOTE

In order to run a local MySQL Database instance you will need to use Docker with the following command

```bash
docker run -d -p 3306:3306 --name my-mysql \
-v ~/mysql/scripts:/docker-entrypoint-initdb.d/ \
-e MYSQL_ROOT_PASSWORD=supersecret \
-e MYSQL_DATABASE=users mysql
```

### License

[APACHE](LICENSE)
