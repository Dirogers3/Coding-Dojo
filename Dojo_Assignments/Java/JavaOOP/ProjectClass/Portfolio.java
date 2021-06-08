package ProjectClass;
import java.util.*;
public class Portfolio {
    private ArrayList<Project> projects = new ArrayList<Project>();
    
    public Portfolio(){

    }

    public Portfolio(ArrayList<Project> projects){
        this.projects = projects;
    }
    public void setProject(Project project){
        projects.add(project);
    }

    public ArrayList<Project> getProject(){
        return projects;
    }

    public Double getPortfoliocost(){
        Double totalcost = 0.00;
        for (Project project : projects) {
            totalcost = totalcost + project.getInitialCost();
        }
        return totalcost;
    }
    
    public void ShowPortfolio(){
        for (Project project : projects) {
            System.out.println(project.elevatorPitch());
        }
    }
}
