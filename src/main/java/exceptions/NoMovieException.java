package exceptions;

public class NoMovieException extends RuntimeException{
    public NoMovieException(String message) {
        super(message);
    }
}
