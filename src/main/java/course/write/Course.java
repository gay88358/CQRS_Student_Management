package course.write;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public boolean equals(Object o) {
        Course c = (Course)o;
        return c.id.equals(id) && c.name.equals(this.name);
    }


}
