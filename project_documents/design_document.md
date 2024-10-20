[Crop Pest Management System] Design Document
1. Problem Statement

The Crop Pest Management System is designed to help farmers and agricultural professionals monitor and manage pest infestations for two crops: corn and wheat. The main goal is to provide a system where users can easily add, update, and view pests associated with each crop via a web interface, backed by an AWS serverless architecture. This system will enhance agricultural productivity by helping users manage pests more effectively, leading to better crop protection and improved yields.
2. Top Questions to Resolve in Review

   How can we ensure that the system handles scalability as more crops or pests are added in the future?
   Should we add any user authentication for specific roles, such as admin or general user, to manage pest data?
   How do we handle errors such as invalid data submissions (e.g., incorrect pest names or IDs) within the UI and backend?
   What security measures (e.g., API key validation) should be implemented in the AWS API Gateway?

3. Use Cases

U1. As a farmer, I want to view all pests associated with my wheat crops so I can monitor potential threats.

U2. As an agricultural professional, I want to add new pests to the corn pest database when I identify new infestations in the field.

U3. As a user, I want to update information about a pest (e.g., name, description) if I discover more accurate information.

U4. As a user, I want to view a list of pests from either corn or wheat categories to stay informed about potential threats.
4. Project Scope
   4.1. In Scope

   Implementing APIs to add, update, and retrieve pests for both corn and wheat.
   Building a serverless backend using AWS Lambda to process requests and interact with DynamoDB.
   Creating a frontend web interface where users can manage pests.
   Setting up DynamoDB tables to store pest data for both corn and wheat crops.

4.2. Out of Scope

    Adding authentication/authorization for user roles (e.g., admin vs. general user) will not be covered at this time.
    Expanding beyond corn and wheat pests.
    Real-time notifications or alerts for pest updates.

5. Proposed Architecture Overview

The system follows a serverless architecture powered by AWS Lambda, API Gateway, and DynamoDB. The frontend is built using HTML and JavaScript with Axios for HTTP requests. Users interact with the web interface to manage pest data (add, view, update), which is then processed through API Gateway to Lambda functions. These functions query or modify the data stored in DynamoDB tables.

Class Diagram:

    Frontend: index.html, index.js (Handles user interactions and sends API requests)
    Lambda Functions:
        CreateCornPestActivity, GetCornPestActivity, UpdateCornPestActivity
        CreateWheatPestActivity, GetWheatPestActivity, UpdateWheatPestActivity
    DynamoDB: Two tables CornPests and WheatPests to store pest data.
    ModelConverter: Converts DynamoDB records into response models for the API.

Why this architecture?

    Serverless architecture ensures scalability and cost efficiency, only charging for actual usage.
    Separation of concerns is maintained by having different Lambda functions for each action (create, update, get).
    DynamoDB allows fast retrieval of pest data with flexible schema design.

6. API
   6.1 Public Models

   CornPestModel: { pestId: String, pestName: String }
   WheatPestModel: { pestId: String, pestName: String }

6.2 First Endpoint: Create Corn Pest

Description: Allows a user to create a new corn pest in the database.

Request:

    POST /corn-pests
    Payload: { pestId: String, pestName: String }

Response:

    On success: { status: 'success', pestId: '123', pestName: 'Corn Pest Name' }
    On failure: { error: 'Invalid data' }

Sequence Diagram:

    User inputs pest data → Sends POST request via Axios → API Gateway → CreateCornPest Lambda → DynamoDB → Response back to frontend → UI update with success or failure message.

6.3 Second Endpoint: Get Wheat Pests

Description: Retrieves a list of wheat pests from the database.

Request:

    GET /wheat-pests

Response:

    On success: [{ pestId: '456', pestName: 'Wheat Pest Name' }, ...]
    On failure: { error: 'Unable to fetch pests' }

7. Tables

   CornPests:
   Partition Key: pestId (String)
   Attributes: pestName (String)
   Stores corn-related pests.

   WheatPests:
   Partition Key: pestId (String)
   Attributes: pestName (String)
   Stores wheat-related pests.

8. Pages

Main Page: The page will have buttons to add, update, and retrieve pests. There will be separate sections for corn and wheat pests.

    Add Pest Section: Input fields for pestId and pestName. Submit buttons for both corn and wheat pests.
    Pest List Section: Displays a list of pests after retrieval, with buttons to update existing pests.
    Behavior: When the user clicks “Add Wheat Pest,” the form data is submitted to the /wheat-pests endpoint, and the page updates to reflect the added pest.

Mockup:

    [Add Pest Form] → [Submit Button]
    [List of Pests]

Behavior:

    User fills in pest data → Submits → API request → Backend processes → Page updates with the pest list.