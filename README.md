# doc-sys: A Document System API Service

doc-sys is a RESTful API service made on SpringBoot that provides three post mappings for managing documents. With this API, you can easily convert PDF files to byte arrays or files, or convert byte arrays back to PDF files.

## Getting Started
To get started with doc-sys, you will need to have Java and Maven installed on your machine. You can then clone this repository and run the application using Maven.

```bash
git clone https://github.com/your-username/doc-sys.git
cd doc-sys
mvn spring-boot:run
```
The application will start on port 8080 by default. You can then use a tool like cURL or Postman to interact with the API.

## API Endpoints
doc-sys provides the following post mappings:

### Convert PDF to Byte Array
#### Endpoint: /pdfToByteArray

#### Description: Consumes a PDF file and returns a byte array.

Example Usage:

```bash
curl -X POST -H "Content-Type: application/pdf" --data-binary "@example.pdf" http://localhost:8080/pdfToByteArray
```
Example Response:

```csharp
[37, 80, 68, 70, 45, 49, 46, 52, 13, 37, 226, 227, 207, 211, 13, 10, 49, 32, 48, 32, 111, 98, 106, 13, 10, ...]
```
### Convert PDF to Byte Array File
#### Endpoint: /pdfToByteArrayFile

#### Description: Consumes a PDF file and returns a byte array file in file.bin format.

Example Usage:

``` bash
curl -X POST -H "Content-Type: application/pdf" --data-binary "@example.pdf" http://localhost:8080/pdfToByteArrayFile -o example.bin
```

Example Response:

```python
example.bin
```
### Convert Byte Array to PDF
#### Endpoint: /byteArrayToPdf

#### Description: Consumes a byte array and returns a PDF file as file.pdf.

Example Usage:

```bash
curl -X POST -H "Content-Type: application/octet-stream" --data-binary "@example.bin" http://localhost:8080/byteArrayToPdf -o example.pdf
```
Example Response:

```
example.pdf
```

## Contributing
If you find a bug or have an idea for a new feature, please open an issue or submit a pull request. We welcome contributions from the community!

## License
doc-sys is released under the MIT License. See LICENSE for details.
