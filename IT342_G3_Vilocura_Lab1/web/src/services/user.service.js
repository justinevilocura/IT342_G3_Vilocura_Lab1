import axios from "axios";
import AuthService from "./auth.service";

const API_URL = "http://localhost:8080/api/user/";

const getPublicContent = () => {
    return axios.get(API_URL + "all");
};

const getUserBoard = () => {
    const user = AuthService.getCurrentUser();

    if (user && user.accessToken) {
        return axios.get(API_URL + "me", { headers: { Authorization: 'Bearer ' + user.accessToken } });
    } else {
        return Promise.reject("No access token found");
    }
};

const UserService = {
    getPublicContent,
    getUserBoard,
};

export default UserService;
