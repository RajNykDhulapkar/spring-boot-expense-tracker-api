import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/categories";

const addCategory = (body) => {
    return axios.post(API_URL, body, { headers: authHeader() });
};
const getAllCategories = () => {
    return axios.get(API_URL, { headers: authHeader() });
};
const getCategoryById = (categoryId) => {
    return axios.get(API_URL + `/${categoryId}`, { headers: authHeader() });
};
const updateCategoryById = (body) => {
    return axios.put(API_URL, body, { headers: authHeader() });
};
const deleteCategory = () => {
    return axios.delete(API_URL, { headers: authHeader() });
};

const CategoryService = {
    addCategory,
    getAllCategories,
    getCategoryById,
    updateCategoryById,
    deleteCategory,
};

export default CategoryService;
