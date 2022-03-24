import { LoginData } from "../model/BackendConnection";
import axios from "axios";
import {STORAGE_KEY_TOKEN} from "./DataService";



export const postLogin = (loginData: LoginData) =>
    axios.post(`/auth/login`, loginData).then(response => response.data)
// export async function postLogin(loginData: LoginData) {
//     const rawResponse = await fetch(`/auth/login`, {
//         method: 'POST',
//         headers: {"Authorization": "Bearer" + "No Token",'Content-Type': 'application/json'},
//         body: JSON.stringify(loginData)
//     });
//     return rawResponse.json();
// }

export async function getPing() {
    return await fetch(`/service/ping`, {
        method: 'GET',
        headers: {"Authorization": "Bearer" + localStorage.getItem(STORAGE_KEY_TOKEN) || "No Token"},
    });
}



