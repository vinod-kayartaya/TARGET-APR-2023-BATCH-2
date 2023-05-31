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
- A HTTP verb defines the action to be performed on the resource
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
