import axios from "axios";

export class AsistanViewApi {
    getAsistan() {
        return axios.get("https://localhost:8080/asistans");
    }

    addAsistan(formState) {
        return axios.post("/asistans", formState);
    }

    updateAsistan(id,newData){
        return axios.put("/asistans/"+id,newData);
    }

    deleteAsistan(id){
        return axios.delete("/asistans/"+id);
    }
}