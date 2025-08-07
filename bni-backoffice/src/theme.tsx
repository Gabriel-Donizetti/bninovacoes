import { createTheme } from "@mui/material";
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import RadioButtonUncheckedIcon from '@mui/icons-material/RadioButtonUnchecked';

export const Theme = createTheme({
  palette: {
    primary: {
      main: "#000108",
    },
    secondary: {
      main: "#9C3939",
    },
    error: {
      main: "#ff5252",
    },
    info: {
      main: "#2196f3",
    },
    success: {
      main: "#4caf50",
    },
    warning: {
      main: "#fb8c00",
    },
    background: {
      default: "#f5f2f2",
    },
  },
  breakpoints: {
    values: {
      xs: 0,
      sm: 600,
      md: 960,
      lg: 1264,
      xl: 1904,
    },
  },
  shape: {
    borderRadius: 14,
  },
  typography: {
    h1: {
      fontSize: "96px",
      fontStyle: "normal",
      fontWeight: 300,
      lineHeight: "96px",
      letterSpacing: "-1.44px",
    },
    h2: {
      fontSize: "96px",
      fontStyle: "normal",
      fontWeight: 300,
      lineHeight: "76px",
      letterSpacing: "-0.5px",
      wordBreak: "break-word",
    },
    h3: {
      fontSize: "48px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "50px",
    },
    h4: {
      fontSize: "34px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "40px",
      letterSpacing: "0.085px",
    },
    h5: {
      fontSize: "24px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "32px",
    },
    h6: {
      fontSize: "20px",
      fontStyle: "normal",
      fontWeight: 500,
      lineHeight: "32px",
      letterSpacing: "0.05px",
    },
    subtitle1: {
      fontSize: "16px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "28px",
      letterSpacing: "0.024px",
    },
    subtitle2: {
      fontSize: "14px",
      fontStyle: "normal",
      fontWeight: 500,
      lineHeight: "22px",
      letterSpacing: "0.014px",
    },
    body1: {
      fontSize: "16px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "24px",
      letterSpacing: "0.08px",
    },
    body2: {
      fontSize: "14px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "20px",
      letterSpacing: "0.035px",
    },
    button: {
      fontSize: "14px",
      fontStyle: "normal",
      fontWeight: 500,
      lineHeight: "36px",
      letterSpacing: "0.175px",
      textTransform: "uppercase",
    },
    caption: {
      fontSize: "12px",
      fontStyle: "normal",
      fontWeight: 400,
      lineHeight: "20px",
      letterSpacing: "0.048px",
    },
    overline: {
      fontSize: "12px",
      fontStyle: "normal",
      fontWeight: 500,
      lineHeight: "32px",
      letterSpacing: "0.24px",
      textTransform: "uppercase",
    },
  },
  spacing: 12,
  components: {
    MuiTypography: {
      styleOverrides: {
        root: {
          margin: "24px",
        },
      },
    },
    MuiButton: {
      styleOverrides: {
        root: {
          margin: "12px",
          width: "80%",
          color: "white",
          ":disabled": {
            backgroundColor: "#0000001F",
            color: "#00000042",
          },
        },
      },
      defaultProps: {
        size: "large",
        variant: "contained"
      },
    },
    MuiInputLabel: {
      styleOverrides: {
        root: {
          color: "t",
        },
      },
      defaultProps: {
        size: "small",
      },
    },
    MuiOutlinedInput: {
      styleOverrides: {
        root: {
          color: "primary",
        },
      },
      defaultProps: {
        size: "small",
      },
    },
    MuiFormControl: {
      styleOverrides: {
        root: {
          width: "100%",
          marginBottom: "24px",
        },
      },
    },
    MuiLink: {
      styleOverrides: {
        root: {
          color: "primary",
          textDecoration: "none",
        },
      },
    },
    MuiCheckbox: {
      defaultProps: {
        icon: <RadioButtonUncheckedIcon />,
        checkedIcon: <CheckCircleIcon />,
      },
    },
  },
});