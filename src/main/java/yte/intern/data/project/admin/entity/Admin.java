package yte.intern.data.project.admin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.data.project.common.entity.BaseEntity;
import yte.intern.data.project.student.entity.Student;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Admin extends BaseEntity {
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String username,
                 String password
                 ) {
        this.username = username;
        this.password = password;

    }

    public void update(Admin updatedAdmin) {
        this.username = updatedAdmin.username;
        this.password = updatedAdmin.password;

    }
}
