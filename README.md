# SynchroBD-RabbitMQ  

## Overview
This project aims to synchronize data across multiple databases in a distributed system. It utilizes Java, JDBC for database connectivity, and RabbitMQ for data exchange via queues. The system consists of multiple Base Offices (BO) linked to different databases and a Head Office (HO) where all data from the BOs is aggregated.

## Features
- **Database Connectivity**: Utilizes JDBC to connect to MySQL databases in the Base Offices.
- **Message Queue**: RabbitMQ is used for asynchronous data exchange between Base Offices and the Head Office.
- **Data Synchronization**: Ensures that data from all Base Offices is synchronized and aggregated in the Head Office database.
- **Fault Tolerance**: Even when the Head Office is not connected, data is queued and synchronized upon reconnection.

## Components
1. **Base Office (BO)**:
   - Connects to its respective database.
   - Listens for changes and publishes them to RabbitMQ.
   
2. **Head Office (HO)**:
   - Listens for messages from Base Offices on RabbitMQ.
   - Aggregates data from all Base Offices and updates its database.
   - Ensures data consistency and integrity.

## Installation
1. **Prerequisites**:
   - Java Development Kit (JDK)
   - RabbitMQ server
   - MySQL server

2. **Clone the Repository**:
   ```bash git clone https://github.com/NaouresBzeouich/SynchroBD-RabbitMQ.git

## Configuration 
   - Configure database connection by adding jdbc modules in your project dependency.
   - Ensure RabbitMQ server details are correctly configured.
   - write your user name , url and password of the database connection in jdbcInset , jdbcRetreive and jdbcDelete classes to make sure that the connection is well done 
   - write your user name , url of your RabbitMQ Management in send and receive classes .
   - make sure that the queue name 'QUEUE_NAME' refers to the right Queue name you want to exchange into .

## Usage
   - Start the Base Offices in each location with access to their respective databases.
   - Ensure RabbitMQ server is running.
   - Start the Head Office to begin data synchronization.
   - Monitor logs for synchronization status and error handling.

## Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or create a pull request.
