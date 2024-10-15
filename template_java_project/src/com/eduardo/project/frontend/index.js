import express from 'express';
import axios from 'axios';

const app = express();
const port = 3000;

app.use(express.json());

// Mock data for corn pests
const cornPests = [
    { pestId: 'CP001', pestName: 'Common Corn Borer' },
    { pestId: 'CP002', pestName: 'Corn Streak' },
    { pestId: 'CP003', pestName: 'Corn Leaf Blight' }
];

// Mock data for wheat pests
const wheatPests = [
    { pestId: 'WP001', pestName: 'Common Wheat Streak' },
    { pestId: 'WP002', pestName: 'Wheat Leaf Blight' },
    { pestId: 'WP003', pestName: 'Wheat Streak' }
];
//http request to fetch data from external API
async function fetchData(url) {
    try {
        const response = await axios.get(url);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        return null;
    }
}

// Fetch data from external API for wheat pests
app.get('/wheat-pests-external', async (req, res) => {
    const externalWheatPestsData = await fetchData(
        'https://example.com/wheat-pests-api'
    );

    if (externalWheatPestsData) {
        wheatPests.push(...externalWheatPestsData);
        res.json(externalWheatPestsData);
    } else {
        res.status(500).json({ message: 'Error fetching data from external API' });
    }
});
// Fetch data from external API for corn pests
app.get('/corn-pests-external', async (req, res) => {
    const externalCornPestsData = await fetchData(
        'https://example.com/corn-pests-api'
    );

    if (externalCornPestsData) {
        cornPests.push(...externalCornPestsData);
        res.json(externalCornPestsData);
    } else {
        res.status(500).json({ message: 'Error fetching data from external API' });
    }
});
// Get corn pests by ID
app.get('/corn-pests/:id', (req, res) => {
    const pestId = req.params.id;
    const foundPest = cornPests.find(p => p.pestId === pestId);

    if (!foundPest) {
        return res.status(404).json({ message: 'Pest not found' });
    }

    res.json(foundPest);
});
// Get wheat pests by ID
app.get('/wheat-pests/:id', (req, res) => {
    const pestId = req.params.id;
    const foundPest = wheatPests.find(p => p.pestId === pestId);

    if (!foundPest) {
        return res.status(404).json({ message: 'Pest not found' });
    }

    res.json(foundPest);
});
// Delete corn pest by ID
app.delete('/corn-pests/:id', (req, res) => {
    const pestId = req.params.id;
    const existingPestIndex = cornPests.findIndex(p => p.pestId === pestId);

    if (existingPestIndex === -1) {
        return res.status(404).json({ message: 'Pest not found' });
    }

    cornPests.splice(existingPestIndex, 1);
    res.status(204).send();
});


// Get corn pests
app.get('/corn-pests', (req, res) => {
    res.json(cornPests);
});

// Get wheat pests
app.get('/wheat-pests', (req, res) => {
    res.json(wheatPests);
});

// Add corn pest
app.post('/corn-pests', (req, res) => {
    const newPest = req.body;
    cornPests.push(newPest);
    res.status(201).json(newPest);
});

// Update corn pest
app.put('/corn-pests/:id', (req, res) => {
    const updatedPestId = req.params.id;
    const updatedPest = req.body;

    const existingPestIndex = cornPests.findIndex(p => p.pestId === updatedPestId);

    if (existingPestIndex === -1) {
        return res.status(404).json({ message: 'Pest not found' });
    }

    cornPests[existingPestIndex] = updatedPest;
    res.json(updatedPest);
});

// Update wheat pest
app.put('/wheat-pests/:id', (req, res) => {
    const updatedPestId = req.params.id;
    const updatedPest = req.body;

    const existingPestIndex = wheatPests.findIndex(p => p.pestId === updatedPestId);

    if (existingPestIndex === -1) {
        return res.status(404).json({ message: 'Pest not found' });
    }

    wheatPests[existingPestIndex] = updatedPest;
    res.json(updatedPest);
});

// Function to update a corn pest
function updateCornPest() {
    const pestId = document.getElementById('cornPestId').value;
    const pestName = document.getElementById('cornPestName').value;

    const updatedPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.put(`/corn-pests/${pestId}`, updatedPest)
        .then(response => {
            console.log('Corn pest updated:', response);
            document.getElementById('response').innerText = 'Corn pest updated successfully!';
        })
        .catch(error => console.error('Error updating corn pest:', error));
}

// Function to update a wheat pest
function updateWheatPest() {
    const pestId = document.getElementById('wheatPestId').value;
    const pestName = document.getElementById('wheatPestName').value;

    const updatedPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.put(`/wheat-pests/${pestId}`, updatedPest)
        .then(response => {
            console.log('Wheat pest updated:', response);
            document.getElementById('response').innerText = 'Wheat pest updated successfully!';
        })
        .catch(error => console.error('Error updating wheat pest:', error));
}

// Function to display pests
function displayPests(pests) {
    const resultList = document.getElementById('resultList');
    resultList.innerHTML = '';  // Clear the list

    pests.forEach(pest => {
        const listItem = document.createElement('li');
        listItem.textContent = `${pest.pestId}: ${pest.pestName}`;
        resultList.appendChild(listItem);
    });
}

// Function to display error message
function displayErrorMessage(message) {
    const resultList = document.getElementById('resultList');
    resultList.innerHTML = '';  // Clear the list

    const errorMessage = document.createElement('li');
    errorMessage.textContent = message;
    resultList.appendChild(errorMessage);
}



// Event listeners for wheat and corn actions
document.getElementById('get-corn').addEventListener('click', getCornPests);
document.getElementById('add-corn').addEventListener('click', addCornPest);
document.getElementById('update-corn').addEventListener('click', updateCornPest);

document.getElementById('get-wheat').addEventListener('click', getWheatPests);
document.getElementById('add-wheat').addEventListener('click', addWheatPest);
document.getElementById('update-wheat').addEventListener('click', updateWheatPest);

// Function to get corn pests from backend
function getCornPests() {
    axios.get('/corn-pests')
        .then(response => {
            const pests = response.data;
            displayPests(pests);
        })
        .catch(error => console.error('Error getting corn pests:', error));
}

// Function to add a new corn pest
function addCornPest() {
    const pestId = document.getElementById('cornPestId').value;
    const pestName = document.getElementById('cornPestName').value;

    const newPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.post('/corn-pests', newPest)
        .then(response => {
            console.log('Corn pest added:', response);
            document.getElementById('response').innerText = 'Corn pest added successfully!';
        })
        .catch(error => console.error('Error adding corn pest:', error));
}

// Function to update a corn pest
function updateCornPest() {
    const pestId = document.getElementById('cornPestId').value;
    const pestName = document.getElementById('cornPestName').value;

    const updatedPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.put('/corn-pests', updatedPest)
        .then(response => {
            console.log('Corn pest updated:', response);
            document.getElementById('response').innerText = 'Corn pest updated successfully!';
        })
        .catch(error => console.error('Error updating corn pest:', error));
}

// Function to get wheat pests from backend
function getWheatPests() {
    axios.get('/wheat-pests')
        .then(response => {
            const pests = response.data;
            displayPests(pests);
        })
        .catch(error => console.error('Error getting wheat pests:', error));
}

// Function to add a new wheat pest
function addWheatPest() {
    const pestId = document.getElementById('wheatPestId').value;
    const pestName = document.getElementById('wheatPestName').value;

    const newPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.post('/wheat-pests', newPest)
        .then(response => {
            console.log('Wheat pest added:', response);
            document.getElementById('response').innerText = 'Wheat pest added successfully!';
        })
        .catch(error => console.error('Error adding wheat pest:', error));
}

// Function to update a wheat pest
function updateWheatPest() {
    const pestId = document.getElementById('wheatPestId').value;
    const pestName = document.getElementById('wheatPestName').value;

    const updatedPest = {
        pestId: pestId,
        pestName: pestName
    };

    axios.put('/wheat-pests', updatedPest)
        .then(response => {
            console.log('Wheat pest updated:', response);
            document.getElementById('response').innerText = 'Wheat pest updated successfully!';
        })
        .catch(error => console.error('Error updating wheat pest:', error));
}

// Function to display pests in the UI
function displayPests(pests) {
    const resultList = document.getElementById('result-list');
    resultList.innerHTML = '';  // Clear the list

    pests.forEach(pest => {
        const listItem = document.createElement('li');
        listItem.textContent = `${pest.pestId}: ${pest.pestName}`;
        resultList.appendChild(listItem);
    });
}
