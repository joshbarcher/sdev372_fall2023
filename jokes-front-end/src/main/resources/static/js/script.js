//wait until the page loads!
window.onload = async function() {
    await fetchJokes();

    //set an event handler for submitting a new joke
    let addJokeButton = document.querySelector("button");
    addJokeButton.onclick = addJoke;

    console.log("onload() ended");

    updateRow();

    //add event handlers to delete a row
    let deleteLinks = document.querySelectorAll(".delete");
    for (let i = 0; i < deleteLinks.length; i++)
    {
        deleteLinks[i].onclick = deleteHandler;
    }
};

//this runs when the delete link is clicked on any row in the table
function deleteHandler(event)
{
    //what does this do?
    event.preventDefault();

    //how do I know which link was clicked?
    //console.log(event.target);

    let row = event.target.parentElement.parentElement;
    console.log(row);
    console.log("Id", row.children[0].textContent);
}

function updateRow()
{
    //update the hunger games record in the table
    let id = 2;
    let title = "Catching Fire";
    let pages = 350;

    //select all <tr> elements in a <tbody>
    let rows = document.querySelectorAll("tbody tr");
    for (let i = 0; i < rows.length; i++)
    {
        let tr = rows[i];
        console.log(tr.children);

        //access the child elements of our <tr>?
        let tdId = tr.children[0];
        let otherId = parseInt(tdId.textContent);

        if (id === otherId)
        {
            console.log("found a match with id", id);

            tr.children[1].textContent = title;
            tr.children[2].textContent = pages.toString();
        }
    }
}

async function addJoke(event)
{
    //stop the form from submitting, we will use fetch() instead!
    event.preventDefault();

    let newJoke = {
        jokeText: document.querySelector("input#joke-text").value
    };

    let uri = "http://localhost:8080/jokes";
    let config = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newJoke)
    };

    let response = await fetch(uri, config);
    let json = await response.json();

    let section = document.querySelector("#jokes-list");
    addSingleJoke(json, section);

    console.log("Joke added", json);
}

async function fetchJokes()
{
    let uri = "http://localhost:8080/jokes";
    let config = {
        method: "get",
        mode: "cors"
    };
    let response = await fetch(uri, config);
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
    let section = document.querySelector("#jokes-list");
    for (let i = 0; i < jokesArray.length; i++)
    {
        let joke = jokesArray[i];
        addSingleJoke(joke, section);

        //assemble the HTML for a joke using a string-template literal
        /*let html = `<div class="card">
                <h1>Joke #<span id="joke-id">${joke.id}</span></h1>
                <p id="joke-body">${joke.jokeText}</p>
            </div>`;*/

        //section.innerHTML += html; //section.innerHTML = section.innerHTML + html;
    }
}

function addSingleJoke(joke, section)
{
    //create HTML elements
    let div = document.createElement("div");
    let h1 = document.createElement("h1");
    let p = document.createElement("p");

    //connect them (parent to child)
    div.appendChild(h1);
    div.appendChild(p);

    //add text or HTML attributes
    h1.textContent = `Joke #${joke.id}`;
    p.textContent = joke.jokeText;
    div.className = "card";

    //add the div to the section
    section.appendChild(div);
}