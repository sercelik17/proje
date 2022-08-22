import axios from "axios";

export class StudentViewApi {
    getStudents() {
        return axios.get("/students");
    }


    addStudent(formState) {
        return axios.post("/students", formState);
    }

    updateStudent(id,newData){
        return axios.put("/students/"+id,newData);
    }

    deleteStudent(id){
        return axios.delete("/students/"+id);
    }
}