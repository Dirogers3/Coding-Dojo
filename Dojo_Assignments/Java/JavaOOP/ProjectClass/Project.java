package ProjectClass;
public class Project {
    private String name;
    private String description;
    private Double initialCost;

    //CONSTRUCTERS
    public Project(){

    }

    public Project(String name){
        this.name = name;
    }

    public Project(String name, Double cost, String description){
        this.name = name;
        this.initialCost = cost;
        this.description = description;
    }

     public Project(String name, String description){
         this.name = name;
         this.description = description;
     }

     public String elevatorPitch() {
         return name + "(" + initialCost + ")" + ":" + description;
     }


     
     public String getName(){
         return name;
     }

     public void setName(String name){
         this.name = name;
     }

     public String getDescription(){
         return description;
     }

     public void setDescription(String description){
         this.description = description;
     }
     
     public void SetInitialCost(Double cost){
        this.initialCost = cost;
     }

     public Double getInitialCost(){
         return initialCost;
     }

     
}
    

