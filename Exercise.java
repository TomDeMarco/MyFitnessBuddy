import java.util.List;

public class Exercise {
    private String exerciseName;
    private List<String> muscleGroupsWorked;
    private int sets;
    private int reps;
    private int length;
    private String date;

    public Exercise(String exerciseName, List<String> muscleGroupsWorked, int sets, int reps, int length, String date) {
        this.exerciseName = exerciseName;
        this.muscleGroupsWorked = muscleGroupsWorked;
        this.sets = sets;
        this.reps = reps;
        this.length = length;
        this.date = date;
    }
}

