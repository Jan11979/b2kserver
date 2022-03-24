import './HeadFrame.scss';
import React from "react";
import {useTheme} from "@mui/material/styles";
import IconButton from "@mui/material/IconButton";
import Brightness7Icon from "@mui/icons-material/Brightness7";
import Brightness4Icon from "@mui/icons-material/Brightness4";
import SaveIcon from '@mui/icons-material/Save';
import {ColorModeContext} from "../App";
import {useLocation, useNavigate, useSearchParams} from "react-router-dom";
import {
    LOCATION_LOAD_SAVE,
    LOCATION_ROOT
} from "../controller/DataService";


export function HeadFrame() {
    const theme = useTheme();
    const colorMode = React.useContext(ColorModeContext);
    let navigate = useNavigate();
    const location = useLocation();

    const [searchParams, setSearchParams] = useSearchParams();

    let navString = "&fbtype=" + searchParams.get('fbtype') +
                    "&startaddresse=" + searchParams.get('startaddresse') +
                    "&faderquantity=" + searchParams.get('faderquantity') +
                    "&universe=" + searchParams.get('universe') +
                    "&RGBMixer=" + searchParams.get('RGBMixer');

    const onClickLoadSave = () => {
        if (location.pathname.includes(LOCATION_LOAD_SAVE)) {
            navigate({ pathname: LOCATION_ROOT, search: navString });
        } else {
            navigate({ pathname: LOCATION_LOAD_SAVE, search: navString, });
        }
    }

    return (
        <div className="Head">
            <div className="HeadMenu">
                <IconButton  onClick={onClickLoadSave} ><SaveIcon fontSize="large"/></IconButton>
            </div>
            <div className="DarkMode">
                <IconButton  onClick={colorMode.toggleColorMode} color="inherit">
                    {theme.palette.mode === 'dark' ? <Brightness7Icon fontSize="large"/> :
                        <Brightness4Icon fontSize="large"/>}
                </IconButton>
            </div>
        </div>
    );
}
