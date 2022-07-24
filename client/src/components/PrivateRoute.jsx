import { Navigate, Outlet } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { useEffect } from "react";
import authService from "../services/auth.service";
import { setUser } from "../store/authSlice";

function PrivateRoute({ children }) {
    const { success } = useSelector((state) => state.auth);
    const dispatch = useDispatch();
    console.log(success);
    useEffect(() => {
        const response = authService.getCurrentLoggedInUser();
        if (response) {
            dispatch(setUser(response.data));
        }
    }, [dispatch]);
    return success ? <Outlet /> : <Navigate to='/auth/login' />;
}

export default PrivateRoute;
