import { Route, Routes } from "react-router-dom";
import AuthLayout from "./components/layouts/AuthLayout";
import Login from "./components/Login";
import PrivateRoute from "./components/PrivateRoute";
import Register from "./components/Register";
import Dashboard from "./components/Dashboard";

function App() {
    return (
        <div className='bg-slate-200'>
            <Routes>
                <Route path='auth' element={<AuthLayout />}>
                    <Route path='login' element={<Login />} />
                    <Route path='register' element={<Register />} />
                </Route>
                <Route path='' element={<PrivateRoute />}>
                    <Route path='' element={<Dashboard />} />
                </Route>
            </Routes>
        </div>
    );
}

export default App;
