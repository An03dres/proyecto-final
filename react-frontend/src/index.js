import React from 'react';
import ReactDOM from 'react-dom/client';
import {
    createBrowserRouter,
    RouterProvider,
  } from "react-router-dom";
import App from "./App";
import ErrorPage from "./pages/Error";
import Home from "./pages/Home";
import About from "./pages/About";
// import Artists from "./pages/Artists";
// import Booking from "./pages/Booking";
// import Register from "./pages/Register";
// import Login from "./pages/Login";

const router = createBrowserRouter([
    {
      element: <App />,
      errorElement: <ErrorPage />,
      children: [
        {
            path: "/",
            element: <Home />,
        },
        {   
            path: "about",
            element: <About />,
        },
        // {   
        //     path: "artists",
        //     element: <Artists />,
        // },
        // {   
        //     path: "booking",
        //     element: <Booking />,
        // },
        // {   
        //     path: "register",
        //     element: <Register />,
        // },
        // {
        //     path: "login",
        //     element: <Login />,
        // },
      ],
    },
  ]);

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
)
