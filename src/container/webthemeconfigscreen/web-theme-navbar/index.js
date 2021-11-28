import React from "react"
import "./navbar.scss";
import { IconButton } from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import { useNavigate } from "react-router-dom";

const NavBar = () => {
    let navigate = useNavigate();

    return ( 
        <div className="navbar">
            <IconButton onClick={() => navigate('/')}>
                <ArrowBackIcon className="icon"/>
            </IconButton>
            <h6> Theme Config </h6>
        </div >
    );
}

export default NavBar;