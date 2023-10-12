package edu.greenriver.sdev.jokesapi.controllers;

import edu.greenriver.sdev.jokesapi.model.Joke;
import edu.greenriver.sdev.jokesapi.services.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Joke>> allJokes()
    {
        return new ResponseEntity<>(service.getAllJokes(), HttpStatus.OK);
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
    public ResponseEntity<Joke> addJoke(@RequestBody Joke joke)
    {
        return new ResponseEntity<>(service.addJoke(joke), HttpStatus.CREATED);
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
