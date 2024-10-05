// Base API URL (replace with your actual API Gateway URL)
const API_BASE_URL = 'https://your-api-gateway-url';

// Function to get pest data (GET request) and display results in a list
async function getPestData(crop) {
    const pestId = document.getElementById('pestId').value;
    const url = `${API_BASE_URL}/${crop}-pests`;

    try {
        const response = await axios.get(url, {
            params: { pestId: pestId }
        });
        displayPestsList(response.data);  // Display pests in a list format
    } catch (error) {
        displayError(error);
    }
}

// Function to add a new pest (POST request)
async function addPest(crop) {
    const pestId = document.getElementById('pestId').value;
    const pestName = document.getElementById('pestName').value;
    const url = `${API_BASE_URL}/${crop}-pests`;

    try {
        const response = await axios.post(url, {
            pestId: pestId,
            pestName: pestName
        });
        displayResult(response.data);
    } catch (error) {
        displayError(error);
    }
}

// Function to update pest data (PUT request)
async function updatePest(crop) {
    const pestId = document.getElementById('pestId').value;
    const pestName = document.getElementById('pestName').value;
    const url = `${API_BASE_URL}/${crop}-pests`;

    try {
        const response = await axios.put(url, {
            pestId: pestId,
            pestName: pestName
        });
        displayResult(response.data);
    } catch (error) {
        displayError(error);
    }
}

// Function to display the list of pests in the <ul> element
function displayPestsList(data) {
    const resultList = document.getElementById('result-list');
    resultList.innerHTML = '';  // Clear the list before adding new items

    if (Array.isArray(data) && data.length > 0) {
        data.forEach(pest => {
            const listItem = document.createElement('li');
            listItem.textContent = pest.PestName || 'Unnamed Pest';
            resultList.appendChild(listItem);
        });
    } else {
        const listItem = document.createElement('li');
        listItem.textContent = 'No pests found';
        resultList.appendChild(listItem);
    }
}

// Helper function to display results (e.g., success messages)
function displayResult(data) {
    document.getElementById('resultDisplay').innerText = JSON.stringify(data, null, 2);
}

// Helper function to display errors
function displayError(error) {
    document.getElementById('resultDisplay').innerText = `Error: ${error.response ? error.response.data : error.message}`;
}

// Event listeners for Corn Pest operations
document.getElementById('get-corn-pests').addEventListener('click', function() {
    getPestData('corn');
});
document.getElementById('post-corn-pests').addEventListener('click', function() {
    addPest('corn');
});
document.getElementById('put-corn-pests').addEventListener('click', function() {
    updatePest('corn');
});

// Event listeners for Wheat Pest operations
document.getElementById('get-wheat-pests').addEventListener('click', function() {
    getPestData('wheat');
});
document.getElementById('post-wheat-pests').addEventListener('click', function() {
    addPest('wheat');
});
document.getElementById('put-wheat-pests').addEventListener('click', function() {
    updatePest('wheat');
});
