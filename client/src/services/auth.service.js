import axios from "axios";
import authHeader from "./auth-header";
const API_URL = process.env.REACT_APP_API_URL + "/users";

const register = (firstName, lastName, email, password) => {
    return axios.post(API_URL + "/register", {
        firstName,
        lastName,
        email,
        password,
    });
};

const login = async (email, password) => {
    const response = await axios.post(API_URL + "/login", {
        email,
        password,
    });
    if (response.data.token) {
        localStorage.setItem("token", JSON.stringify(response.data.token));
    }
    return response;
};

const getCurrentLoggedInUser = async () => {
    const response = await axios.get(API_URL + "/me", { headers: authHeader() });
    if (response.data.userId) {
        return response;
    }
};

const authService = {
    register,
    login,
    getCurrentLoggedInUser,
};

export default authService;
