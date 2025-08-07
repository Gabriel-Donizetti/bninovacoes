import { ThemeProvider } from "@mui/material";
import { Router } from "./services/routes";
import { Theme } from "./theme";

export default function App() {
    return (
        <>
            <ThemeProvider theme={Theme}>
                <Router />
            </ThemeProvider>
        </>
    );
}