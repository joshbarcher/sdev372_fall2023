package edu.greenriver.sdev.jokesapi.controllers;

import edu.greenriver.sdev.jokesapi.model.Joke;
import edu.greenriver.sdev.jokesapi.services.JokeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JokesApi
{
    private JokeService service;

    public JokesApi(JokeService service)
    {
        this.service = service;
    }

    @GetMapping("jokes") //http://localhost:8080/jokes
    public List<Joke> allJokes()
    {
        return service.getAllJokes();
    }

    @GetMapping("jokes/random")
    public Joke random()
    {
        return service.random();
    }

    @GetMapping("jokes/{jokeId}") //http://localhost:8080/jokes/3
    public Joke getJokeById(@PathVariable int jokeId)
    {
        return service.getJokeById(jokeId);
    }

    //pass in a new Joke object through the request body
    @PostMapping("jokes")
    public Joke addJoke(@RequestBody Joke joke)
    {
        return service.addJoke(joke);
    }

    @PutMapping("jokes")
    public Joke editJoke(@RequestBody Joke joke)
    {
        return service.updateJoke(joke);
    }

    @DeleteMapping("jokes")
    public void deleteJoke(@RequestBody Joke joke)
    {
        service.deleteJoke(joke.getId());
    }
}
