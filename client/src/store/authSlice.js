import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    token: "",
    error: null,
    user: null,
    success: false,
};

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        setCredentials: (state, action) => {
            state.success = true;
            state.token = action.payload.token;
        },
        setUser: (state, action) => {
            state.user = action.payload.user;
        },
        incrementByAmount: (state, action) => {
            state.value += action.payload;
        },
    },
});

// Action creators are generated for each case reducer function
export const { setCredentials, setUser } = authSlice.actions;

export default authSlice.reducer;
