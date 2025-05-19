Description
In this challenge, the REST API contains information about a collection of movies released after the year 2010, directed by acclaimed directors. Given a threshold value, your task is to use the API to retrieve a list of directors who have directed more movies than the specified threshold. Specifically, the API should return the names of directors whose movie count is strictly greater than the given threshold, sorted alphabetically.

To access the movie collection, perform an HTTP GET request to the following endpoint:

https://challenge.iugolabs.com/api/movies/search?page=<pageNumber>
where <pageNumber> is an integer denoting the page of the results to return.

The response to such request is a JSON with the following 5 fields:

page: The current page of the results
per_page: The maximum number of movies returned per page.
total: The total number of movies on all pages of the result.
total_pages: The total number of pages with results.
data: An array of objects containing movies returned on the requested page
Each movie record has the following schema:

Title: title of the movie
Year: year the movie was released
Rated: movie rating
Released: movie release date
Runtime: movie duration time in minutes
Genre: move genre
Director: movie director
Writer: movie writer
Actors: movie actors
Task
Fork the provided repository and implement a REST API endpoint using the provided template:

/api/directors?threshold=X
This endpoint must return a JSON object containing the names of directors whose number of movies directed is strictly greater than the given threshold.

The names should be returned in alphabetical order.

Sample : /api/directors?threshold=4

Json response:

{  "directors": ["Martin Scorsese","Woody Allen"] }