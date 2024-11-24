# Employee Management Microservice

This microservice is built using **Spring Boot** to manage employee data stored in the **Oracle HR Schema**. It provides RESTful endpoints for fetching, adding, and deleting employee data. 

---

## Features

- Fetch all employees.
- Fetch an employee by their ID.
- Fetch employees by department ID.
- Fetch employees by manager ID.
- Add a new employee to the database.
- Delete an employee by their ID.
- Test endpoint to verify the service is running.

---

## Technologies Used

- **Spring Boot**: For building the microservice.
- **Oracle Database**: For data storage (HR Schema).
- **Spring Data JPA**: For database interactions.
- **Java**: Programming language.

---

## API Endpoints

### Base URL: `/api/v1/employee`

### 1. **Fetch All Employees**
- **Endpoint**: `GET /all`
- **Description**: Retrieves a list of all employees.
- **Sample Request**:
  ```http
  GET /api/v1/employee/all
  ```
  - **Sample Response**:
  ```json
  
  ```

  ### 2. **Fetch an Employee by ID**
- **Endpoint**: `GET /{empId}`
- **Description**: Retrieves the details of an employee by their unique ID.
- **Sample Request**:
  ```http
  GET /api/v1/employee/101
  ```
  - **Sample Response**:
  ```json
  
  ```

  ### 3. **Fetch Employees by Department ID**
- **Endpoint**: `GET /by-department`
- **Description**: Retrieves all employees working in a specific department.
- **Sample Request**:
  ```http
  GET /api/v1/employee/by-department?deptId=10
  ```
  - **Sample Response**:
  ```json
  
  ```

  ### 4. **Fetch Employees by Manager ID**
- **Endpoint**: `GET /by-manager`
- **Description**: Retrieves all employees managed by a specific manager.
- **Sample Request**:
  ```http
  GET /api/v1/employee/by-manager?managerId=1001
  ```
  - **Sample Response**:
  ```json
  
  ```

  ### 5. **Add a New Employee**
- **Endpoint**: `POST /add`
- **Description**: Adds a new employee to the database.
- **Sample Request**:
  ```http
  POST /api/v1/employee/add
Content-Type: application/json
{
    "employeeId": 1101,
    "firstName": "test",
    "lastName": "tester",
    "email": "testEmail",
    "phoneNumber": "515.123.4567",
    "hireDate": "2024-11-22",
    "jobId": "AD_PRES",
    "salary": 24000,
    "commissionPct": null,
    "managerId": null,
    "departmentId": 90
}

  ```
  - **Sample Response**:
  ```json
  
  ```

  ### 6. **Delete an Employee by ID**
- **Endpoint**: `DELETE /delete/{empId}`
- **Description**: Deletes an employee from the database by their unique ID.
- **Sample Request**:
  ```http
  DELETE /api/v1/employee/delete/104
  ```
  - **Sample Response**:
  ```json
  
  ```
