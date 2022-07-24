import { zodResolver } from "@hookform/resolvers/zod";
import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { loginSchema } from "../schemas/auth.schema";
import InputArea from "./controls/InputArea";
import authService from "../services/auth.service";
import { setCredentials } from "../store/authSlice";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const Login = () => {
    const [registerError, setRegisterError] = useState(null);

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { success } = useSelector((state) => state.auth);

    const {
        register,
        formState: { errors },
        handleSubmit,
        reset,
    } = useForm({
        mode: "onSubmit",
        resolver: zodResolver(loginSchema),
    });
    const onSubmit = async (data) => {
        reset();
        try {
            const res = await authService.login(data.email, data.password);
            if (res.status === 200 && res.data.token) {
                console.log("success logging in");
                dispatch(setCredentials({ token: res.data.token }));
                console.log(success);
                navigate("/");
            } else {
                setRegisterError(res.data.message);
            }
        } catch (error) {
            setRegisterError(error.message);
        }
    };
    return (
        <div>
            <form
                onSubmit={handleSubmit(onSubmit)}
                autoComplete='off'
                className='relative w-80 m-auto grid grid-rows-5 gap-2 pt-24'
            >
                <InputArea
                    name='email'
                    type='email'
                    label='Enter Email'
                    register={register("email")}
                    icon={
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            width='24'
                            height='24'
                            style={{ fill: " rgba(0, 0, 0, 1)", transform: "", msFilter: "" }}
                        >
                            <path d='M20 4H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2zm0 4.7-8 5.334L4 8.7V6.297l8 5.333 8-5.333V8.7z'></path>
                        </svg>
                    }
                    errors={errors}
                />
                <InputArea
                    name='password'
                    type='password'
                    label='Password'
                    register={register("password")}
                    icon={
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            width='24'
                            height='24'
                            className='p-0'
                            style={{ fill: " rgba(0, 0, 0, 1)", transform: "", msFilter: "" }}
                        >
                            <path d='M20 12c0-1.103-.897-2-2-2h-1V7c0-2.757-2.243-5-5-5S7 4.243 7 7v3H6c-1.103 0-2 .897-2 2v8c0 1.103.897 2 2 2h12c1.103 0 2-.897 2-2v-8zM9 7c0-1.654 1.346-3 3-3s3 1.346 3 3v3H9V7z'></path>
                        </svg>
                    }
                    errors={errors}
                />
                <input
                    className='bg-slate-800 text-slate-100 h-fit p-2 pr-2 pl-2 rounded-md hover:font-semibold hover:text-white hover:shadow-sm'
                    type='submit'
                    value='Login'
                />
            </form>
        </div>
    );
};

export default Login;
