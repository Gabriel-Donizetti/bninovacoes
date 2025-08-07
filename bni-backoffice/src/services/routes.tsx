import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Login from "../containers/auth";
import Home from "../containers/home";

const routes = createBrowserRouter([
    {
        path: "/",
        element: <Login />
    },
    {
        path: "/home",
        element: <Home />
    }
])

export const Router: React.FC = () => {
    return <RouterProvider router={routes} />
}