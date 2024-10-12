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
