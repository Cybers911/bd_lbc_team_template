document.getElementById('get-corn').addEventListener('click', getCornPests);
document.getElementById('add-corn').addEventListener('click', addCornPest);
document.getElementById('update-corn').addEventListener('click', updateCornPest);

document.getElementById('get-wheat').addEventListener('click', getWheatPests);
document.getElementById('add-wheat').addEventListener('click', addWheatPest);
document.getElementById('update-wheat').addEventListener('click', updateWheatPest);

function getCornPests() {
    axios.get('/corn-pests')
        .then(response => {
            const pests = response.data;
            displayPests(pests);
        })
        .catch(error => console.error('Error getting corn pests:', error));
}

function addCornPest() {
    const newPest = {
        pestId: 'new-corn-pest-id',  // Replace with actual values
        pestName: 'New Corn Pest'
    };
    axios.post('/corn-pests', newPest)
        .then(response => console.log('Corn pest added:', response))
        .catch(error => console.error('Error adding corn pest:', error));
}

function updateCornPest() {
    const updatedPest = {
        pestId: 'existing-corn-pest-id',  // Replace with actual values
        pestName: 'Updated Corn Pest'
    };
    axios.put('/corn-pests', updatedPest)
        .then(response => console.log('Corn pest updated:', response))
        .catch(error => console.error('Error updating corn pest:', error));
}

function getWheatPests() {
    axios.get('/wheat-pests')
        .then(response => {
            const pests = response.data;
            displayPests(pests);
        })
        .catch(error => console.error('Error getting wheat pests:', error));
}

function addWheatPest() {
    const newPest = {
        pestId: 'new-wheat-pest-id',  // Replace with actual values
        pestName: 'New Wheat Pest'
    };
    axios.post('/wheat-pests', newPest)
        .then(response => console.log('Wheat pest added:', response))
        .catch(error => console.error('Error adding wheat pest:', error));
}

function updateWheatPest() {
    const updatedPest = {
        pestId: 'existing-wheat-pest-id',  // Replace with actual values
        pestName: 'Updated Wheat Pest'
    };
    axios.put('/wheat-pests', updatedPest)
        .then(response => console.log('Wheat pest updated:', response))
        .catch(error => console.error('Error updating wheat pest:', error));
}

function displayPests(pests) {
    const resultList = document.getElementById('result-list');
    resultList.innerHTML = '';  // Clear the list

    pests.forEach(pest => {
        const listItem = document.createElement('li');
        listItem.textContent = `${pest.pestId}: ${pest.pestName}`;
        resultList.appendChild(listItem);
    });
}
