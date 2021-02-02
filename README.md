# Microservice blueprint
## Purpose
It's a simple Spring Boot service, which can generate API code from an OpenAPI3 definition.

## Build
### Prerequisites
* JDK
* Gradle

### Execution
This project is using Gradle as its build tool. \
You can build the application by executing `gradle clean build`

### Generating Java code from the API definiton
This is done automatically during the build, before the _compile_ phase. \
There are a few things you should keep in mind:
* The API definition should be stored in the _src/main/resources/openapi-def.yaml_ file in OpenAPI 3.0 format
* You should update the _apiPackageName_ property in the _build.gradle_ file according to your project's package naming. There are no further modification required in the gradle build.
* The generated Java code containing the API specification for Spring is located within the _src-api_ folder
* You must never modify the generated code manually, as it will be overwritten with each build

As a bonus: you can use the _src/main/resources/openapi-def.yaml_ file to generate a new collection in Postman.

## Implementing the logic behind the API
There should be one Java interface with it's name ending with _Delegate_ (e.g. _DefaultApiDelegate_) in your api package within the generated sources (_src-api_). \
Create a managed bean (_@Component_) and implement this _*Delegate_ interface in your "normal" source directory (_src_, and never in _src-api_!). \
That's it! \
The implementation is nicely de-coupled from the specification.