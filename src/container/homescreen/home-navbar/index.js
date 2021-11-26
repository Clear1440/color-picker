import React from "react"
import FavoriteIcon from '@mui/icons-material/Favorite';
import SettingsIcon from '@mui/icons-material/Settings';
import "./navbar.scss";
import { IconButton } from "@mui/material";
import { useNavigate } from "react-router-dom";

const NavBar = () => {
    let navigate = useNavigate();
    return ( 
        <div className="navbar">
            <IconButton onClick={() => navigate('settings')}>
                <SettingsIcon className="cog"/>
            </IconButton>
            <h6> Color Picker </h6>
            <IconButton onClick={() => {navigate('favorites');}}>
                <FavoriteIcon className="heart"/>
            </IconButton>
        </div >
    );
}

export default NavBar;