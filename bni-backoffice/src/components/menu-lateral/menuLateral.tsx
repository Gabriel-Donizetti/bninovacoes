import { Box, Divider, Drawer, Typography, useMediaQuery, useTheme } from "@mui/material"


export const MenuLateral: React.FC<React.PropsWithChildren> = ({ children }) => {

    const theme = useTheme();

    const smDown = useMediaQuery(theme.breakpoints.down('sm'));

    return (
        <>
            <Drawer open={true} variant={smDown ? 'temporary' : 'persistent'}>
                <Box width={theme.spacing(28)}>
                    <Box width={'100%'} height={theme.spacing(28)} display={'flex'} alignItems={'center'} justifyContent={'cemter'}>
                        <Typography variant="h2" align="center" gutterBottom>
                            BNInovações
                        </Typography>
                    </Box>
                    <Divider />

                    <Box flex={1}>

                    </Box>
                </Box>
            </Drawer>

            <Box height={"100vh"} margin={smDown ? 0 : theme.spacing(28)}>
                {children}
            </Box>
        </>
    )
}