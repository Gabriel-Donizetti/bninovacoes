import axios from "axios";
import { errorInterceptor, responseInterceptor } from "./interceptors";
import { Enviroments } from "../../../environment";

const Api = axios.create({
    baseURL: Enviroments.DEV_URL_BASE,
    headers: {
        'Content-Type': 'application/json'
    }
});

Api.interceptors.response.use(
    (response) => responseInterceptor(response),
    (error) => errorInterceptor(error),
);

export { Api }
