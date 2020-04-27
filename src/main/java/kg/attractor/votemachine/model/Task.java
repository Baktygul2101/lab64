package kg.attractor.votemachine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Task {

  //  public static final Candidate EMPTY = new Candidate("Anon Y Mouse", "anon.jpg");
  public static final Task EMPTY = new Task("Anon Y Mouse");
    @Id
    private String id;
    private String title;

    public Task(String title) {
        Objects.requireNonNull(title);
        this.id = String.valueOf(title.hashCode()); //UUID.randomUUID().toString();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
// <img src="/image/${person.photo}">-->