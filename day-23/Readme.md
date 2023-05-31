# ReST

- Representational State Transfer
- Transferring State in different representations (JSON or XML or CSV or any other custom format)

![](./concept1.dio.png)

## REST in simple english

- Uses HTTP protocol
- A web client (such as a JavaScript app) sends a HTTP request (RFC2616) to a server
- The server understands the request (and requested information) and responds to the client in HTTP response format
- The ReST server exposes **resource**, which is nothing but information
  - products, customers, employees, orders, orderDetails, movies, flights, ...
  - Nouns
  - Entities
- A URL (or URI) represents a Resource
  - http://example.com/api/products --> represents a resource "products"
  - http://example.com/api/products/765 --> represents a single member of the resource "products" with id 765
  - http://example.com/api/products/765/supplier --> represents a supplier who supplied the product with id 765
  - http://example.com/api/products/765/pictures --> represents one or more pictures of product with id 765
- A HTTP verb (request METHOD) defines the action to be performed on the resource
  - GET --> Retrieves a representation of the resource identified by the URI
    - GET `http://example.com/api/products` --> gets all products (no payload)
    - GET `http://example.com/api/products/765` --> gets one product with id 765 (no payload)
  - POST --> Creates a new entry in the resource using the data sent by the client
    - POST `http://example.com/api/products` --> client has to send a new product data as payload (request body)
  - PUT --> Replaces the existing item in the resource with the one sent by the client
    - PUT `http://example.com/api/products/765` --> Replaces the old information about product 765 with the data in the payload
  - PATCH --> Does a partial update of an existing resource with the partial data sent by the client
    - PATCH `http://example.com/api/products/765` --> Updates the product 765 with the data sent via payload
  - DELETE --> Deletes the resource represented by the URI
    - DELETE `http://example.com/api/products/765` --> Deletes the product with id 765 (no payload)
- A HTTP Request header can be used to do **content-negotiation**
  - `Accept` --> Clients asks a specific representation of data from the REST server
    - for example, `Accept: application/xml` or `Accept: application/json` or `Accept: text/csv` and so on
  - `Content-Type` --> Client has to use this header to inform the server as what kind of data is being sent by the client
    - for example, `Content-Type: application/xml` or `Content-Type: application/json` or `Content-Type: text/csv` and so on
    - applicable only for POST, PUT and PATCH requests

### Setting up a demo REST server

1. Open a command prompt (or terminal) in the folder where `contact-service.jar` file resides
2. Run the jar file using the `java` command
   - `java -jar contact-service.jar`
   - This runs a Java Spring boot project, and if you stop it (by pressing CTRL+C), the REST server stops.
   - When the app is running, we can access the REST server at `http://localhost:8080/api/contacts`

### Making a HTTP Request and understanding the HTTP Response

- In a HTTP request, the first line is called `request line` consists of 3 parts:
  1. the HTTP verb (GET, POST, PUT, PATCH, DELETE, etc)
  1. path to the resource (/api/contacts)
- The second line onwards are a bunch of key/value pairs separated using colon, called as request headers
  - some of the most common headers include:
    - Host
    - Accept
    - Content-Type
    - Cookie
- After the headers, there must be blank line, if you are sending a payload (request body)

  - applicable only for POST, PUT, PATCH requests

- A HTTP response has the following content
  - first line --> status line
    - contains 3 parts:
      1. HTTP version of the server (HTTP/1.1)
      1. A numeric status code
         - Informational responses (100 – 199)
         - Successful responses (200 – 299)
           - 200 --> OK
           - 201 --> Created
         - Redirection messages (300 – 399)
         - Client error responses (400 – 499)
         - Server error responses (500 – 599)
         - https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#information_responses
      1. (optional) status text
  - the second line onwards are the response headers
  - after the headers, there will be a mandatory blank line
  - after the blank line, we get the response body (or payload)

## JSON

- JavaScript Object Notation
- A standard format for exchanging data between a web client and a web server application
- `{}` represents a JSON object
- `[]` represents a JSON array
- A double quoted string represents a String in JSON
- An object has key/value pairs separated using colon
  ```json
  {
    "name": "Vinod Kumar",
    "age": 49,
    "married": true,
    "phones": ["9731424784", "9844083934"],
    "address": {
      "area": "ISRO Layout",
      "city": "Bangalore",
      "pincode": 560078
    }
  }
  ```

```http
GET /api/contacts
Host: localhost:8080
Accept: application/json
```

or if you want to get in XML format,

```http
GET /api/contacts
Host: localhost:8080
Accept: application/xml
```

Requesting movie information from `omdbapi.com`

```http
GET /?s=iron&apikey=aa9e49f
Host: www.omdbapi.com
Accept: application/json
```

Requesting page from `vinod.co`

```http
GET /posts/enable-cors-in-a-jax-rs-project.md
Host: vinod.co
Accept: text/plain
```

## Examples using the `contact-service` running locally on port 8080

Get all contacts in XML format

```http
GET /api/contacts
Host: localhost:8080
Accept: application/xml
```

Get one contact using the id in XML format

```http
GET /api/contacts/54b2111f-5696-4556-aa0e-04cb4435f9c6
Host: localhost:8080
Accept: application/xml
```

Get one contact using the id in JSON format

```http
GET /api/contacts/54b2111f-5696-4556-aa0e-04cb4435f9c6
Host: localhost:8080
Accept: application/json
```

Get one contact using the id in TEXT format

```http
GET /api/contacts/54b2111f-5696-4556-aa0e-04cb4435f9c6
Host: localhost:8080
Accept: text/plain
```

When we ask for a specific representation that the server is unable to give, the server should respond with a status code of 406

```http
GET /api/contacts/54b2111f-5696-4556-aa0e-04cb4435f9c7
Host: localhost:8080
Accept: text/x-yaml
```

Add a new contact using JSON format

```http
POST /api/contacts
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{
    "firstname": "Vinod",
    "email": "vinod@knowledgeworksindia.com",
    "phone": "9844083934"
}
```

For the above request, the output was:

```http
HTTP/1.1 201
Vary: Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 31 May 2023 14:25:53 GMT
Connection: close

{
  "id": "bc37e428-47f7-490a-a00c-b62b145effed",
  "firstname": "Vinod",
  "lastname": null,
  "gender": null,
  "email": "vinod@knowledgeworksindia.com",
  "phone": "9844083934",
  "address": null,
  "city": null,
  "state": null,
  "country": null,
  "pincode": null,
  "picture": null
}
```

We can verify and get the value back using the id, even in different format (like XML)

```http
GET /api/contacts/bc37e428-47f7-490a-a00c-b62b145effed
Host: localhost:8080
Accept: application/xml
```

If you want to update partial data, the server may provide support for PATCH requests

For example, updating contact with "city" and "state" information

```http
PATCH /api/contacts/bc37e428-47f7-490a-a00c-b62b145effed
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{
    "city": "Bangalore",
    "state": "Karnataka"
}
```

and updating the same with "country"

```http
PATCH /api/contacts/bc37e428-47f7-490a-a00c-b62b145effed
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{
    "country": "India"
}
```
