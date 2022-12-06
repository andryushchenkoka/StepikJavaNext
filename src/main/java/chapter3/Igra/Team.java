package chapter3.Igra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {

    private String name;
    private List<T> participantList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNewParticipant(T participant){
        participantList.add(participant);

        System.out.printf("В команду %s добавлен учатник: %s\n", this.name, ((Participant)participant).getName());
    }

    public void playWith(Team<T> team){
        Random random = new Random();
        int i = random.nextInt(2);
        String winnerName = i == 0 ? this.name : team.getName();

        System.out.println("Победила команда: " + winnerName);
    }
}
