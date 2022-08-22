import axios from "axios";

export class AkademisyenViewApi {
    getAkademisyen() {
        return axios.get("/akademisyen");
    }

    addAkademisyen(formState) {
        return axios.post("/akademisyen", formState);
    }

    updateAkademisyen(id,newData){
        return axios.put("/akademisyen/"+id,newData);
    }

    deleteAkademisyen(id){
        return axios.delete("/akademisyen/"+id);
    }

}