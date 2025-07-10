# Bank-Account-Management-System1
The Bank-Account-Management-System is a console-based application built using Core Java, JDBC, and PostgreSQL. It allows users to perform CRUD (Create, Read, Update, Delete) operations on customer records stored in a PostgreSQL database. The application is menu-driven, providing a simple and intuitive interface for managing customer data.

## Features
- **Add customer**: Add a new  customer record to the database.
- **View All customer**: Fetch and display all  customer records.
- **Update  customer**: Update an existing  customer details (e.g., id, accountname, accountholder, balance).
- **Delete customer**: Delete an  customer record.


## Technologies Used
- **Core Java**: For implementing the application logic and OOPs concepts.
- **JDBC (Java Database Connectivity)**: For connecting to and interacting with the PostgreSQL database.
- **PostgreSQL**: For storing and managing employee data.
- **Maven**: For project dependency management and building the project.

## Dependencies

The project uses the following dependencies:

- **PostgreSQL JDBC Driver**: For connecting to the PostgreSQL database.
  ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.6.0</version>
  </dependency>
  ```
  ## Prerequisites
. create PostgreSQL database with the following table:
   ```sql
 CREATE TABLE bank_account (
        id SERIAL PRIMARY KEY,
	    account_number VARCHAR(20),
	    holder_name VARCHAR(100),
	    balance NUMERIC
   );
   ```

## Contact
- **Your Name** : Priyanka Phadatare 
- **Email**: priyankaphadatare162@gmail.com  
- **GitHub**: [PriyankaPhadatare](https://github.com/PriyankaPhadatare)

---
** Bank-Account-Management-System**! 🚀
