document.addEventListener('DOMContentLoaded', () => {
    const apiKey = '54414218b5a510cae2a807dc84a93fd1'; 
    const apiUrl = `https://api.themoviedb.org/3/trending/movie/day?api_key=${apiKey}`;
    const tendenciasContainer = document.getElementById('tendencias');

    async function fetchTendencias() {
        try {
            const response = await fetch(apiUrl);
            const data = await response.json();
            displayMovies(data.results);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    function displayMovies(movies) {
        tendenciasContainer.innerHTML = ''; 

        movies.forEach(movie => {
            const movieElement = document.createElement('div');
            movieElement.classList.add('pelicula');

            const movieLink = document.createElement('a');
            movieLink.href = `descripcion.html?id=${movie.id}`;

            const movieImage = document.createElement('img');
            movieImage.src = `https://image.tmdb.org/t/p/w500${movie.poster_path}`;
            movieImage.alt = movie.title;

            movieLink.appendChild(movieImage);
            movieElement.appendChild(movieLink);
            tendenciasContainer.appendChild(movieElement);
        });
    }

    fetchTendencias();
});