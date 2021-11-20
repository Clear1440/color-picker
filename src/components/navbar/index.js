import React from "react"
import FavoriteIcon from '@mui/icons-material/Favorite';
import SettingsIcon from '@mui/icons-material/Settings';
import "./navbar.scss";
import { IconButton } from "@mui/material";

export const NavBar = () => {
    return ( 
        <div className="navbar">
            <IconButton onClick={() => console.log('go back settings')}>
                <SettingsIcon className="icon"/>
            </IconButton>
            <h6> Color Picker </h6>
            <IconButton onClick={() => console.log('go home')}>
                <FavoriteIcon className="icon"/> 
            </IconButton>
        </div >
    );
}
