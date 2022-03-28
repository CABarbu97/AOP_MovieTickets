package aspects;
import service.MovieService;

public aspect LogAspectJ {
    void around(): call(void MovieService.AddMovie()) {
        System.out.println("Adding movie...");
        proceed();
        System.out.println("Movie has been added...");
    }
}
