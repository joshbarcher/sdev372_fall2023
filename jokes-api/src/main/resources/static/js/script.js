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
    let json = await response.json();
    console.log(json);

/*    fetch(uri, config)
        .then(function(response) {
            console.log(response);
            return response.json();
        })
        .then(function(json) {
            console.log(json);
        });*/

    console.log("fetchJokes() ended");
}