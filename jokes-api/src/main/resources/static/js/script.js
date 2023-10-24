//wait until the page loads!
window.onload = async function() {
    await fetchJokes();

    console.log("onload() ended");
};

async function fetchJokes()
{
    let uri = "http://localhost:8080/jokes";
    let config = {
        method: "get"
    };

    //use the await, async keywords to make your
    //code appear more synchronous
    let response = await fetch(uri, config);

    //convert the body of the response to JSON format
    //using JSON.parse()
    let json = await response.json();
    addCards(json);

/*    fetch(uri, config)
        .then(function(response) {
            console.log(response);
            return response.json();
        })
        .then(function(json) {
            console.log(json);
        });*/
}

function addCards(jokesArray)
{
    //loop over my array
    for (let i = 0; i < jokesArray.length + 1; i++)
    {
        let joke = jokesArray[i];

        //assemble the HTML for a joke using a string-template literal
        let html = `<div class="card">
                <h1>Joke #<span id="joke-id">${joke.id}</span></h1>
                <p id="joke-body">${joke.jokeText}</p>
            </div>`;

        let section = document.querySelector("#jokes-list");
        section.innerHTML = html;
    }
}