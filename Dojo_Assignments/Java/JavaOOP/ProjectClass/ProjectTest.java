package ProjectClass;

public class ProjectTest {
    public static void main(String[] args){
        Project movies = new Project();
        movies.setName("Harry Potter");
        System.out.println(movies.elevatorPitch());

        movies.setDescription("Wizards all over the world gather together");
        System.out.println(movies.elevatorPitch());

        movies.SetInitialCost(20.00);
        System.out.println(movies.elevatorPitch());

        Project games = new Project("Battlefront II",39.99, "Starwars war games"
        );
        System.out.println("THIS WILL SHOW EVERYTHING IN THE PORTFOLIO:");
        Portfolio projects = new Portfolio();
        projects.setProject(games);
        projects.setProject(movies);
        projects.ShowPortfolio();
        Double cost = projects.getPortfoliocost();
        System.out.println(cost);
        
    
    }
}
