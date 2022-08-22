import axios from "axios";

export class LoginApi {
 getLogin () {
        return axios.get("/login");
}


}