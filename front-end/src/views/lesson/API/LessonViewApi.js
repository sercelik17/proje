import axios from "axios";

export class LessonViewApi {
    getLesson() {
        return axios.get("https://localhost:8080/lessons");
    }

    addLesson(formState) {
        return axios.post("https://localhost:8080/lessons", formState);
    }

    updateLesson(id,newData){
        return axios.put("/lessons/"+id,newData);
    }

    deleteLesson(id){
        return axios.delete("/lessons/"+id);
    }
}