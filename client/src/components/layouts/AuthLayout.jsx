import React, { useState } from "react";
import { Link, Outlet } from "react-router-dom";

const AuthLayout = () => {
    const [isMenuVisible, setIsMenuVisible] = useState(false);
    return (
        <div className='h-screen w-full'>
            <nav className='w-full h-12 bg-slate-800 text-cyan-300 flex flex-row justify-center items-center shadow-md'>
                <div className='relative w-10/12 mx-auto flex flex-row justify-between items-center'>
                    <h1 className='text-xl text-cyan-100'>Expense Tracker</h1>
                    <ul
                        className={
                            "xs:flex xs:flex-row xs:gap-4 xs:relative xs:top-0 xs:bg-transparent xs:p-0 " +
                            (isMenuVisible
                                ? "absolute top-11 p-4 rounded-md right-0 bg-slate-600 flex flex-col items-center gap-4"
                                : "hidden")
                        }
                    >
                        <li className='hover:text-cyan-50'>
                            <Link to='/auth/login'>Login</Link>
                        </li>
                        <li className='hover:text-cyan-50'>
                            <Link to='/auth/register'>Register</Link>
                        </li>
                    </ul>
                    {isMenuVisible ? (
                        <i
                            onClick={() => setIsMenuVisible(!isMenuVisible)}
                            class='fa-solid fa-xmark text-2xl hover:text-cyan-50 absolute right-0 xs:hidden transition-all'
                        ></i>
                    ) : (
                        <i
                            onClick={() => setIsMenuVisible(!isMenuVisible)}
                            className='fa-solid fa-bars text-xl hover:text-cyan-50 absolute right-0 xs:hidden transition-all'
                        ></i>
                    )}
                </div>
            </nav>

            <Outlet />
        </div>
    );
};

export default AuthLayout;
