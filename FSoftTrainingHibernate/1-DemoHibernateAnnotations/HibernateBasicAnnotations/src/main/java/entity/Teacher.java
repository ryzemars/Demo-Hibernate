package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.UUID;

@Entity
public class Teacher {
    //@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_uuid")
    private UUID uuid;

    //@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherGenerator")
    //set name of the table in DB is serial
    @SequenceGenerator(name = "teacherGenerator", sequenceName = "sequence_pool", initialValue = 7, allocationSize = 3)
    @Column(name = "sequence_id")
    private Long sequenceId;

    @Id
    /*@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGenerator")
    //set name of the table in DB is serial
    @SequenceGenerator(name = "tableGenerator", sequenceName = "table_pool", initialValue = 5, allocationSize = 4)*/
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "teacher_name")
    private String name;

    public Teacher() {}

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uuid=" + uuid +
                ", sequenceId=" + sequenceId +
                ", tableId=" + tableId +
                ", name='" + name + '\'' +
                '}';
    }
}
