# Spring-Boot Simple CRUD API

## Overview

Spring Boot Users C.R.U.D. API, is implemented by the following Tech-Stack:

- Spring-Boot 2.3.1
- Spring-Fox Swagger 2.9.2
- Spring-Fox Swagger UI 2.9.2
- Spring-Security
- Lombok
- Hibernate
- MySQL 8
- Google Guava
- Docker

### Spring Security Login

> The login credentials are as follows:

```text
username: FortySix-nTwo
password: superSecret
```

### NOTE

> In order to run a local MySQL Database instance,
> you will need to use Docker with the following command

```bash
docker run -d -p 3306:3306 --name mysql \
-v ~/mysql/scripts:/docker-entrypoint-initdb.d/ \
-e MYSQL_ROOT_PASSWORD=password \
-e MYSQL_DATABASE=users mysql
```

> in order to execute bash commands within the docker instance,
> within the terminal use the following commands

```bash
docker exec -it mysql bash
# if successful you will see something to the effect of 'root@c86ff80d7524:/#', then enter:
mysql -uroot -p
# Which will prompt you to enter the root password as follows:
password
# if all successful you will be meet with the 'mysql>' command-line
```

> in order to view data stored within the database use the following commands

```bash
# To View all Databases
show databases;
# Select the users Database
use users;
# Show Users Tables
show tables;
# Show Users Columns
show columns from users;
# Show all Stored Users in Table
select * from users;
# To Exit mysql command-line
exit
```

### License

[APACHE](LICENSE)
