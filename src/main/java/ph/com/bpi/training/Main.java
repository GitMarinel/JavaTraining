package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	 // Start server on port 4567 (default)
    	
        port(4567);
        
        // add routes here

        // Get Profile List
     // Health check route
        get("/check-connection", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("status", "Server is running");
            return mapper.writeValueAsString(response);
        });

        // GET movies → retrieve all movies
        get("/movies", (req, res) -> {
            res.type("application/json");
            List<Movie> movies = movieRepository.findAll();
            return mapper.writeValueAsString(movies);
        });
        
        get("/hello", (req, res) -> "Hello World");


        // POST movies → accept Movie object and save
        post("/movies", (req, res) -> { res.type("application/json"); 
        Movie movie = mapper.readValue(req.body(), Movie.class); 
        EntityManager emLocal = EntityManagerUtil.getInstance().createEntityManager(); 
        MovieRepository repo = new MovieRepository(emLocal); 
        Movie saved = repo.save(movie); 
        emLocal.close(); 
        return mapper.writeValueAsString(saved); }); 

        System.out.println("Starting Spark server...");
        // Create Profile List
        
    }
    
    

}
