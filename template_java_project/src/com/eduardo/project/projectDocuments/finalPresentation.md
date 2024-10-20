Introduction

The Crop Pest Management System is designed to help farmers and agricultural professionals manage pest infestations affecting two key crops: corn and wheat. The goal of this system is to provide users with a convenient, cloud-based tool for tracking, adding, and updating pest information, improving pest control measures and crop yields.

    Who does your project serve? Our project primarily serves farmers, agricultural consultants, and researchers, offering them a platform to monitor pests and their effects on crops.

    What was the problem you set out to solve? We aimed to provide an easy-to-use, efficient solution for pest management. The traditional methods of tracking pests, such as pen and paper or isolated software solutions, lacked the integration and flexibility needed for modern pest monitoring.

    What aspects did you choose to focus on? Our primary focus was on building an intuitive user interface with responsive forms, backed by a serverless cloud-based backend using AWS Lambda, DynamoDB, and API Gateway for scalability. The system allows users to:
        Add new pests to either corn or wheat pest lists.
        Retrieve and view pest data for decision-making.
        Update pest information in case of new findings or corrections.

Demo!

In this section, we’ll demonstrate our working site.

    How to navigate:
    We'll show how users can easily access the main webpage where they can:
        Add a pest to the corn or wheat list.
        View a list of all pests currently affecting their crops.
        Update any pest information in real time.

Planned Demo Flow:

    Add Pest: Demonstrate filling out the form and adding a new pest for corn or wheat.
    View Pests: Show how to fetch and display a list of current pests in both corn and wheat categories.
    Update Pest: Illustrate updating the name of a pest and seeing the updated information reflected immediately.

New Skills/Technologies

Throughout this project, we incorporated a variety of new technologies and skills, including:

    HTML Forms: For capturing user inputs related to pest management.
    CSS: To ensure the frontend design is clean and responsive.
    JavaScript (Axios): Used for sending API requests to the backend.
    AWS Lambda: For handling serverless backend logic.
    API Gateway: As a gateway for our serverless functions.
    DynamoDB: To store pest-related data in a flexible NoSQL database.
    Bootstrap: To create a responsive, mobile-friendly user interface.
    Sequence Diagrams & Data Flow: Creating UML diagrams to visualize system interactions.

Challenges

Every project comes with its own set of challenges, both expected and unexpected.

    Expected Challenges:
        Integrating frontend (HTML and JavaScript) with AWS Lambda and DynamoDB through API Gateway required careful planning of data flow and error handling.
        Structuring the DynamoDB tables in a way that supports both corn and wheat pests while ensuring scalability for future additions (e.g., more crops).

    Unexpected Challenges:
        Managing cross-origin resource sharing (CORS) when making API requests from the frontend to the serverless backend.
        Debugging the interactions between multiple AWS services (Lambda, API Gateway, and DynamoDB) took more time than anticipated, particularly when setting permissions and roles.

What You Learned

This project taught us several key lessons about software development and collaboration within a team:

    Building Serverless Applications: We gained practical experience in building serverless applications using AWS services like Lambda and DynamoDB.

    Frontend and Backend Integration: We learned how to effectively integrate the frontend (HTML, JavaScript) with a backend API using Axios for sending and retrieving data via API requests.

    Team Collaboration: This project reinforced the importance of communication and task delegation in a team environment, ensuring everyone stays on the same page and code contributions are well-integrated.

    Problem-Solving in Real Time: We learned to anticipate and react quickly to unexpected challenges like CORS errors and API issues.

    Significance of Project: The Crop Pest Management System is crucial because it provides an easily scalable tool to manage pests, which directly impacts food security. Farmers can use this tool to mitigate the effects of pests on crop yields, potentially saving millions in lost production.

This document summarizes our team's journey through the development of the Crop Pest Management System, from its inception to completion. We are excited to have developed a system that can make a real impact on the agricultural community.

Explanation about the dataflow and architecture code of this project:

Crop Pest Management System: Dataflow and Code Logic
1. Overview of the Project

The Crop Pest Management System is a serverless web application that allows users to manage pest data for two crops: corn and wheat. It provides functionality for adding, updating, and viewing pest information through a responsive web interface that interacts with a backend hosted on AWS services. The system is built using AWS Lambda functions, API Gateway, and DynamoDB for storage. The frontend consists of HTML, JavaScript (Axios), and CSS for user interaction.

This document describes the data flow and code logic across the frontend and backend of the system, detailing how each component interacts to achieve the system’s functionality.
2. Dataflow Overview

The Crop Pest Management System follows a structured and well-defined dataflow that can be summarized as follows:

    User Interaction (Frontend)
        The user accesses the system via a web interface built using HTML and JavaScript (Axios). The interface allows the user to:
            Add new pests for corn and wheat.
            Retrieve a list of existing pests for each crop.
            Update pest information.
        The user submits data through HTML forms or clicks buttons that trigger API calls.

    Frontend to Backend Communication (Axios & API Gateway)
        When a user submits data (e.g., adding a new pest), the frontend JavaScript makes a corresponding HTTP request (GET, POST, PUT) using Axios. These requests are sent to the AWS API Gateway, which routes them to the appropriate AWS Lambda function based on the HTTP method and endpoint.
        The API Gateway acts as a bridge between the user-facing frontend and the serverless backend.

    Lambda Functions (Backend Logic)
        The AWS Lambda functions serve as the backend processing units. Each function is responsible for handling specific operations (e.g., creating, updating, or retrieving pests). The Lambda functions are invoked by API Gateway upon receiving user requests.
        The system contains separate Lambda functions for:
            Creating pests (both corn and wheat)
            Updating pests
            Retrieving pest lists
        Inside each Lambda function, business logic is executed. For instance, when a new pest is created, the function processes the input, validates it, and writes it to DynamoDB.

    DynamoDB (Data Storage)
        DynamoDB acts as the persistent data store, holding information about pests for both crops. The table structure includes partition keys (pestId) and attributes (pestName).
        Upon invocation, the Lambda functions either read from or write to DynamoDB. For example, when a user requests all wheat pests, the Lambda function retrieves the data from the WheatPests table and returns it as a response.

    Backend to Frontend Response
        After the Lambda function processes the request and interacts with DynamoDB, it returns a response (either success or failure) to the API Gateway, which in turn sends the response back to the frontend.
        The JavaScript code on the frontend processes this response, updating the user interface accordingly (e.g., displaying a success message, showing a list of pests, etc.).

3. Code Logic Breakdown

The following sections detail the code logic for each key component in the Crop Pest Management System.
3.1 Frontend: index.js and index.html

The frontend is responsible for gathering input from the user and sending API requests to the backend.

    HTML Forms:
    The HTML file contains forms where users can input pest details (e.g., pest name, pest ID). There are separate buttons for adding, updating, and retrieving pests. Each button is linked to corresponding JavaScript functions.

    JavaScript (index.js):
        Event Listeners:
        JavaScript uses addEventListener() to detect user actions such as button clicks (e.g., "Add Wheat Pest", "Get Corn Pests").
        Axios API Calls:
        JavaScript makes HTTP requests using Axios to send the user input data to the API Gateway. For example, the addWheatPest() function collects data from the form and sends a POST request to the /wheat-pests endpoint via Axios.
        UI Updates:
        Upon receiving a response from the backend, JavaScript updates the UI by either displaying a success message or rendering a list of pests.

3.2 Backend: Lambda Functions

AWS Lambda functions form the core logic of the backend. Each Lambda function is responsible for handling a specific request (e.g., create, update, or retrieve pests).

    CreateWheatPestActivity.java:
    This class is triggered when a user submits a request to add a new wheat pest. The flow of this function is as follows:
        Receive the request payload (pest details).
        Validate the input (ensure the pest ID and name are present).
        Save the new pest details to DynamoDB using a WheatPestDAO.
        Return a success response to the frontend.

    GetWheatPestsActivity.java:
    This function retrieves all pests from the WheatPests table in DynamoDB. The flow is:
        Query the DynamoDB table to fetch all pest entries.
        Convert the database records into a readable format using a ModelConverter.
        Return the list of pests to the frontend for display.

    UpdateWheatPestActivity.java:
    This function is invoked when a user wants to update an existing pest. The flow:
        Fetch the existing pest record from DynamoDB based on pestId.
        Update the relevant fields (e.g., pest name).
        Save the updated pest data back to the database.
        Return a confirmation response to the frontend.

3.3 Data Storage: DynamoDB

The backend relies on DynamoDB for storing pest data. There are two tables:

    CornPests: Contains pest data for corn crops.
        Partition Key: pestId
        Attributes: pestName
    WheatPests: Contains pest data for wheat crops.
        Partition Key: pestId
        Attributes: pestName

The Lambda functions interact with these tables to read, write, or update pest information. The data stored in DynamoDB is retrieved using the DynamoDBMapper class in Java.
3.4 API Gateway and Routing

API Gateway acts as the entry point for all HTTP requests from the frontend. It is configured with routes (endpoints) for each crop and operation:

    POST /wheat-pests: Triggers the Lambda function that adds a new wheat pest.
    GET /wheat-pests: Fetches the list of wheat pests from DynamoDB.
    PUT /wheat-pests: Updates an existing wheat pest.

The API Gateway forwards requests to the appropriate Lambda function based on the HTTP method (POST, GET, PUT) and the resource path.
4. Sequence Example: Create Wheat Pest

To understand the complete dataflow, let’s walk through the sequence of creating a new wheat pest:

    User Input:
    The user fills in the pest ID and name on the HTML form and clicks the "Add Wheat Pest" button.

    Frontend (JavaScript):
    The addWheatPest() function is triggered, which gathers the form data and sends it via Axios as a POST request to /wheat-pests.

    API Gateway:
    The request hits the AWS API Gateway, which routes the request to the CreateWheatPestActivity Lambda function.

    Lambda Function:
    The Lambda function processes the request, validating the input and writing the pest data to the WheatPests DynamoDB table using WheatPestDAO.

    DynamoDB:
    The pest data is stored in DynamoDB with a unique pestId.

    Response:
    The Lambda function returns a success message back to the API Gateway, which forwards it to the frontend.

    UI Update:
    JavaScript receives the success message and displays it to the user, confirming the new pest has been added.

Conclusion

The Crop Pest Management System efficiently handles pest data using a serverless architecture. The frontend and backend work together to provide a seamless experience
for users, leveraging AWS services for scalability and performance. By integrating DynamoDB, Lambda functions, and API Gateway, the system offers a robust solution for managing pest data in agricultural settings.