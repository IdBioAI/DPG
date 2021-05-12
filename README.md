server - Java Spring Boot framework

database - MySQL

# How to run
1. In runnable/config.properties change url, username and password.
2. Screate schema (Server can not create schema automatically)
3. Run runnable/server.jar

### EER DIAGRAM

![](https://gitlab.com/JaroslavVond/dpg-rest-api/-/raw/master/img/dat.png)

# REST API

#### GET all employees

URL: /api/employees

Method: GET

example of response: 
```json
{
    "1": {
        "firstname": "Jaroslav2",
        "depShortcut": "IT3",
        "birth": "1991-03-31",
        "specShortcut": "SPEC3",
        "lastname": "Vondrak"
    },
    "2": {
        "firstname": "Jan",
        "depShortcut": "IT2",
        "birth": "1991-03-31",
        "specShortcut": "SPEC2",
        "lastname": "Novák"
    }
}
```
#### GET employee by ID

URL: /api/employees/{id}

Method: GET

example of response: 
```json
{
    "1": {
        "firstname": "Jaroslav2",
        "depShortcut": "IT3",
        "birth": "1991-03-31",
        "specShortcut": "SPEC3",
        "lastname": "Vondrak"
    }
}
```

#### DELTE employee by ID

URL: /api/deleteEmployees/{id}

Method: DELETE

#### ADD employee

URL: /api/addEmployees/{id}

Method: POST

example of BODY: 
```json
{
    "firstname":"Jan", 
    "lastname":"Novák",
    "birth":"1997-02-12",
    "idDepartment":1,
    "idSpecialization":3
}
```

#### EDIT employee

URL: /api/editEmployees/{id}

Method: PUT

example of BODY: 
```json
{
    "firstname":"Honza", 
    "lastname":"Novák",
    "birth":"1997-02-12",
    "idDepartment":5,
    "idSpecialization":2
}
```

#### GET departments

URL: /api/departments

Method: GET

example of response: 
```json
{
    "1": {
        "shortcut": "IT",
        "title": "tech"
    },
    "2": {
        "shortcut": "IT2",
        "title": "tech2"
    }
}
```

#### GET departments by ID

URL: /api/departments/{id}

Method: GET

example of response: 
```json
{
    "2": {
        "shortcut": "IT2",
        "title": "tech2"
    }
}
```

#### DELETE department

URL: /api/deleteDepartment/{id}

Method: DELETE

#### ADD department

URL: /api/addDepartment

Method: POST

example of BODY: 
```json
{
        "shortcut": "IT3",
        "title": "tech3"
}
```

#### EDIT department

URL: /api/editDepartment/{id}

Method: PUT

example of BODY: 
```json
{
        "shortcut": "IT3",
        "title": "tech"
}
```

#### GET specialization

URL: /api/specialization

Method: GET

example of response: 
```json
{
    "2": {
        "shortcut": "SPEC2",
        "title": "special2"
    },
    "3": {
        "shortcut": "SPEC3",
        "title": "special3"
    }
}
```

#### GET specialization by ID

URL: /api/specialization/{id}

Method: GET

example of response: 
```json
{
    "2": {
        "shortcut": "SPEC2",
        "title": "special2"
    }
}
```

#### DELETE specialization

URL: /api/deleteSpecialization/{id}

Method: DELETE

#### ADD specialization

URL: /api/addSpecialization

Method: POST

example of BODY: 
```json
{
        "shortcut": "SPEC3",
        "title": "special3"
}
```

#### EDIT specialization

URL: /api/editSpecialization/{id}

Method: PUT

example of BODY: 
```json
{
        "shortcut": "SPEC3",
        "title": "special"
}
```
