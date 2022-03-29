package aspects;

import exceptions.InvalidDateException;
import exceptions.NoMovieException;
import exceptions.NoTicketsException;
import model.Movie;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Movie;
import database.MoviesRepo;
import service.MovieService;
import controller.MovieController;

import java.util.List;

public aspect LogAspectJ {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    pointcut listMovies(): call(void controller.MovieController.getAllMovies());
    pointcut getMovie(): call(void controller.MovieController.getMovieByTitle());
    pointcut confirmTickets(Movie movie):
            call(void controller.MovieController.retrieveTickets(Movie)) && args(movie);
    pointcut printing():
            call(void controller.MovieView.printReceipt());
    pointcut getMovieFromRepo(String title):
            call(List<Movie> database.MoviesRepo.getMovieByTitle(String)) && args(title);
    pointcut getMovieFromService(String title):
            call(List<Movie> service.MovieService.getMovieByTitle(String)) && args(title);

    pointcut invalidDate(String date, String title):
            call(List<Movie> service.MovieService.getMovieByTitleAndDate(String, String)) && args(title,date);

    pointcut noDirector(MoviesRepo repo, Movie movie):
            call(void database.*.*(Movie))
            && args(movie)
            && target(repo);

    Object around(MoviesRepo moviesRepo, Movie movie):
            noDirector(moviesRepo, movie)
            {
                Signature m = thisJoinPoint.getSignature();
                logger.info("POST - Adding movie...");
                if(movie.getDirector().length() < 2){
                    movie.setDirector("Anonymous");
                }
                return proceed(moviesRepo, movie);
            }

    void around(): listMovies(){
        logger.info("LIST - will list all movies");
        proceed();
        logger.info("LIST - the movies have been listed");
    }

    before(): getMovie(){
        logger.info("GET- Getting movie by title...");
    }
    before(Movie movie): confirmTickets(movie){
        logger.info("GET- Checking for tickets...");
    }
    after(Movie movie): confirmTickets(movie){
        logger.info("After confirming tickets");
    }

    after(String title) throwing (NoMovieException e): getMovieFromRepo(title)
            {
                logger.info("There is no movie called {} in the database - REPO", title);
            }
   after(String title) throwing (NoMovieException e): getMovieFromService(title)
            {
                logger.info("There is no movie called {} in the database - SERVICE ", title);
            }
    after(String title, String date) throwing (InvalidDateException e): invalidDate(title, date)
            {
                logger.warn("Invalid date format - {}", date);
            }

    after(String title) returning (List<Movie> movies): getMovieFromRepo(title)
            {
                logger.info("Successfully retrieved movie(s) from database");
            }

    after(): printing(){
        logger.info("GET- Printing tickets...");
    }


}
