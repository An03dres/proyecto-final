document.addEventListener('DOMContentLoaded', () => {
    fetch('https://api.example.com/artists')
        .then(response => response.json())
        .then(data => {
            const artistsDiv = document.getElementById('artists');
            const artistSelect = document.getElementById('artist');
            data.forEach(artist => {
                const artistCard = document.createElement('div');
                artistCard.className = 'col-md-4';
                artistCard.innerHTML = `
                    <div class="card">
                        <img class="card-img-top" src="${artist.image}" alt="${artist.name}">
                        <div class="card-body">
                            <h5 class="card-title">${artist.name}</h5>
                            <p class="card-text">${artist.bio}</p>
                        </div>
                    </div>
                `;
                artistsDiv.appendChild(artistCard);

                const option = document.createElement('option');
                option.value = artist.id;
                option.textContent = artist.name;
                artistSelect.appendChild(option);
            });
        });

    document.getElementById('bookingForm').addEventListener('submit', event => {
        event.preventDefault();
        const artistId = document.getElementById('artist').value;
        const date = document.getElementById('date').value;
        fetch('https://api.example.com/bookings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ artistId, date })
        })
        .then(response => response.json())
        .then(data => {
            alert('Appointment booked successfully!');
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
