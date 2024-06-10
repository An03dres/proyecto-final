// document.addEventListener('DOMContentLoaded', () => {
//     fetch('https://api.example.com/artists')
//         .then(response => response.json())
//         .then(data => {
//             const artistsDiv = document.getElementById('artists');
//             const artistSelect = document.getElementById('artist');
//             data.forEach(artist => {
//                 const artistCard = document.createElement('div');
//                 artistCard.className = 'col-md-4';
//                 artistCard.innerHTML = `
//                     <div class="card">
//                         <img class="card-img-top" src="${artist.image}" alt="${artist.name}">
//                         <div class="card-body">
//                             <h5 class="card-title">${artist.name}</h5>
//                             <p class="card-text">${artist.bio}</p>
//                         </div>
//                     </div>
//                 `;
//                 artistsDiv.appendChild(artistCard);

//                 const option = document.createElement('option');
//                 option.value = artist.id;
//                 option.textContent = artist.name;
//                 artistSelect.appendChild(option);
//             });
//         });

//     document.getElementById('bookingForm').addEventListener('submit', event => {
//         event.preventDefault();
//         const artistId = document.getElementById('artist').value;
//         const date = document.getElementById('date').value;
//         fetch('https://api.example.com/bookings', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({ artistId, date })
//         })
//         .then(response => response.json())
//         .then(data => {
//             alert('Appointment booked successfully!');
//         })
//         .catch(error => {
//             console.error('Error:', error);
//         });
//     });
// });

document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8082/api/artists')
        .then(response => response.json())
        .then(artists => {
            console.log(artists)
            const artistSelect = document.getElementById('artist')
            const artistsDiv = document.getElementById('artists');
            artists.forEach(
                artist => {
                    const option = document.createElement('option')
                    option.value = artist.id;
                    option.textContent = artist.name;
                    artistSelect.appendChild(option);
                    
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
                }
            )
        })
        .catch(error => {
            console.error('Error', error)
        })
    })
 
    // id bigint AI PK
    // date datetime(6)
    // artist_id bigint
    
// date, artist_id 

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('bookingForm').addEventListener('submit', submit);
});

function submit(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the values from the form fields
    const artist = document.getElementById('artist').value;
    const date = document.getElementById('date').value;

    // Check if the form fields are filled
    if (artist && date) {
        // Here you can handle the form submission,
        // for example, sending the data to a server using fetch or AJAX
        console.log('Artist:', artist);
        console.log('Date:', date);

        // Example of sending data to a server (replace with your actual URL and logic)
        
        fetch('http://localhost:8082/api/bookings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ artist_id: artist, date: date }),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Display a success message or redirect
        })
        .catch((error) => {
            console.error('Error:', error);
            // Display an error message
        });
        

        // Display a simple alert for demonstration purposes
        alert('Booking successful!\nArtist: ' + artist + '\nDate: ' + date);
    } else {
        alert('Please fill out all fields.');
    }
}